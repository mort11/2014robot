package org.mort11.commands.dt;

import edu.wpi.first.wpilibj.Timer;
import org.mort11.commands.CommandBase;
import org.mort11.subsystems.DriveTrainSide;
import org.mort11.util.DriveTrainConstants;
import org.mort11.util.Gear;

/**
 *
 * @author admin
 */
public abstract class DriveFPS extends CommandBase
{

    protected double sp;
    protected double errorSum = 0;
    protected double lastError = 0;
    protected final Timer loopTimer;
    protected final DriveTrainSide dt;

    protected DriveFPS(DriveTrainSide side)
    {
        dt = side;
        loopTimer = new Timer();
        requires(side);
        setInterruptible(true);
    }

    protected void initialize()
    {
        loopTimer.start();
    }

    protected double getPV()
    {
        return dt.getRate();
    }

    protected double doLoop()
    {
        double error = (sp - getPV())/gears.getGear().maxFPS;
        errorSum += error;
        if (Math.abs(error) <
            DriveTrainConstants.ACCEPTABLE_LOOP_ERROR_PERCENT.get()) {
            error = 0;
            errorSum = 0;
        }
        if ((lastError < 0 && error >= 0) || (lastError > 0 && error <= 0)) {
            errorSum = 0;
        }
        if (errorSum > 1 / DriveTrainConstants.CONTROL_LOOP_I.get()) {
            errorSum = 1 / DriveTrainConstants.CONTROL_LOOP_I.get();
        } else if (errorSum < -1 / DriveTrainConstants.CONTROL_LOOP_I.get()) {
            errorSum = -1 / DriveTrainConstants.CONTROL_LOOP_I.get();
        }
        double P = DriveTrainConstants.CONTROL_LOOP_P.get() * error;
        double I = DriveTrainConstants.CONTROL_LOOP_I.get() * errorSum;
        if(this.dt != leftDT){
            System.out.println("SP = " + sp);
            System.out.println("PV = " + getPV());
            System.out.println("PVal = " + P);
            System.out.println("IVal = " + I);
            System.out.println("P = "+ DriveTrainConstants.CONTROL_LOOP_P.get());
            System.out.println("I = "+ DriveTrainConstants.CONTROL_LOOP_I.get());
            System.out.println("Dist = "+dt.getDist());
        }
        lastError = error;
        return P + I;
    }

    protected void execute()
    {

//        System.out.println(loopTimer.get());
        if (loopTimer.get() > 1 / DriveTrainConstants.CONTROL_LOOP_HERTZ) {
//            System.out.println("DriveFPS");
            dt.set(dt.getCurVal() + doLoop());
            loopTimer.reset();
        }
    }

    protected boolean isFinished()
    {
        return false;
    }

    protected void end()
    {
        loopTimer.stop();
    }

    protected void interrupted()
    {
    }

}
