package org.mort11.commands.dt;

import org.mort11.commands.CommandBase;
import org.mort11.util.DriveTrainConstants;

/**
 *
 * @author Sahit Chintalapudi
 */
public class Turn extends CommandBase
{

    double degrees;

    public Turn(double degrees)
    {

        this.degrees = degrees;
        requires(leftDT);
        requires(rightDT);
    }

    protected void initialize()
    {
    }

    protected void execute()
    {
//        double error = imu.getYaw() - degrees;
//        if (Math.abs(error) > DriveTrainConstants.ACCEPTABLE_TURN_ERROR) {
//            if (leftDT.getLeftTime() < DriveTrainConstants.CONTROL_LOOP_HERTZ) {
//                return;
//            }
//            leftDT.driveSpeed(error * DriveTrainConstants.TURN_P);
//            rightDT.driveSpeed(error * DriveTrainConstants.TURN_P);
//        }
    }

    protected boolean isFinished()
    {
        return leftDT.getCurVal() == 0 && rightDT.getCurVal()== 0;
    }

    protected void end()
    {
    }

    protected void interrupted()
    {
    }
}