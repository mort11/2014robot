package org.mort11.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.mort11.RobotMap;
import org.mort11.commands.dt.DriveFPS;
import org.mort11.commands.dt.DriveFPSJoystick;
import org.mort11.commands.dt.DriveFPSLeftJoy;
import org.mort11.commands.dt.DriveFPSRightJoy;
import org.mort11.commands.dt.DriveLinear;
import org.mort11.commands.dt.DriveLinearLeft;
import org.mort11.commands.dt.DriveLinearRight;
import org.mort11.commands.dt.DrivePercentRight;
import org.mort11.util.DriveStyle;
import org.mort11.util.DriveTrainConstants;

/**
 *
 * @author Sahit Chintalapudi
 */
public class RightDriveTrain extends DriveTrainSide
{

    public RightDriveTrain()
    {
        super(RobotMap.DT_RIGHT_PORT, RobotMap.DT_ENCODER_RIGHT_A,
              RobotMap.DT_ENCODER_RIGHT_B,false, false);
    }

    protected DriveFPSJoystick getJoystickFPSDrive() {
        return new DriveFPSRightJoy();
    }

    protected DriveLinear getLinearDrive() {
        return new DriveLinearRight();
    }

}
