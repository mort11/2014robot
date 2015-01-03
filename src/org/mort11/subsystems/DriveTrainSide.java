package org.mort11.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.mort11.RobotMap;
import org.mort11.commands.dt.DriveFPS;
import org.mort11.commands.dt.DriveFPSJoystick;
import org.mort11.commands.dt.DriveLinear;
import org.mort11.util.DriveStyle;
import org.mort11.util.DriveTrainConstants;

/**
 *
 * @author Sahit Chintalapudi
 */
public abstract class DriveTrainSide extends Subsystem
{

    private final Encoder enc;
    private final Talon motors;
    private double curVal = 0;
    private final boolean motorReverseDirection;
    private DriveStyle driveStyle;
    private boolean enabled = true;

    public DriveTrainSide(int motorPort, int encAPort, int encBPort,
                          boolean motorReverseDirection,
                          boolean encReverseDirection)
    {
        this.motorReverseDirection = motorReverseDirection;
        driveStyle = DriveStyle.TANK;
        motors = new Talon(motorPort);
        enc = new Encoder(encAPort, encBPort,
                          encReverseDirection, Encoder.EncodingType.k4X);
        enc.setDistancePerPulse(DriveTrainConstants.DIST_PER_PULSE);
        enc.setSamplesToAverage(DriveTrainConstants.DT_ENC_SAMPLES.get());
        enc.startLiveWindowMode();
        enc.start();
    }

    public void setEnabled(boolean b){
        enabled = b;
    }
    
    protected void initDefaultCommand(){
        setDefaultCommand(getLinearDrive());
    }
    public void set(double lspeed)
    {
        if(lspeed > 1){
            lspeed=1;
        }else if(lspeed < -1){
            lspeed=-1;
        }
        if(!enabled){
            lspeed = 0;
        }
        curVal = lspeed;
        motors.set(lspeed * (motorReverseDirection ? -1 : 1));
    }

    public double getCurVal()
    {
        return curVal;
    }

    public double getRate()
    {
        return enc.getRate();
    }

    public double getDist()
    {
        return enc.getDistance();
    }

    public DriveStyle getDriveStyle()
    {
        return driveStyle;
    }

    protected abstract DriveFPSJoystick getJoystickFPSDrive();
    
    protected abstract DriveLinear getLinearDrive();
    
    public void swapDriveStyle(){
       setDriveStyle(getDriveStyle() == DriveStyle.TANK ? DriveStyle.PID_TANK : DriveStyle.TANK);
    }
    
    public void setDriveStyle(DriveStyle driveStyle)
    {
        this.driveStyle = driveStyle;
        this.getCurrentCommand().cancel();
        if(driveStyle == DriveStyle.PID_TANK){
            this.setDefaultCommand(getJoystickFPSDrive());
        }else{
            this.setDefaultCommand(getLinearDrive());
        }
    }

    public void resetEnc()
    {
        enc.reset();
    }
}
