package org.mort11.commands.ee;

import org.mort11.commands.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import org.mort11.util.EndEffectorConstants;

public class SetCAMAngle extends CommandBase
{

    private final double targetSP;
    private double sumError = 0;
    private double lastError = 0;
    private final Timer loopTimer; //reset each loop
    private final Timer errTimer; //kept running for logging purposes

    public SetCAMAngle(double targetDeg)
    {
        requires(catapult);
        if (targetDeg > 360 - 10) {
            targetSP = 360 - EndEffectorConstants.CAM_DEADBAND_DEG.get();
        } else if (targetDeg < 10) {
            targetSP = EndEffectorConstants.CAM_DEADBAND_DEG.get();
        } else {
            targetSP = targetDeg;
        }
        loopTimer = new Timer();
        errTimer = new Timer();
        setInterruptible(true);
    }

    protected void initialize()
    {
        loopTimer.start();
    }

    protected void execute()
    {
        
        errTimer.start();
        if (loopTimer.get() > 1 / EndEffectorConstants.CAM_LOOP_HERTZ) {
            double error = (targetSP - catapult.getAngle()) / 360;
//            System.out.println(targetSP);
            sumError += error;
//                        System.out.println("Err = "+error);

            if (Math.abs(error) <
                EndEffectorConstants.CAM_ACCEPTABLE_ERROR_DEG.get() / 360) {
//                System.out.println("Acceptable Error");
                error = 0;
                sumError = 0;
            }
            if ((lastError < 0 && error >= 0) || (lastError > 0 && error <= 0)) {
                sumError = 0;
            }
            if(sumError > 1/ EndEffectorConstants.CAM_I_CONSTANT.get()){
                sumError = 1/EndEffectorConstants.CAM_I_CONSTANT.get();
            }else if(sumError < -1/EndEffectorConstants.CAM_I_CONSTANT.get()){
                sumError = -1/EndEffectorConstants.CAM_I_CONSTANT.get();
            }
            double P = EndEffectorConstants.CAM_P_CONSTANT.get() * error ;
            double I = EndEffectorConstants.CAM_I_CONSTANT.get() * sumError;
            double L = EndEffectorConstants.CAM_L_CONSTANT.get() ;
//            System.out.println("P = "+P);
//            System.out.println("I = "+I);
            /** 
                       (catapult.getAngle() > 180 ? catapult.getAngle(): catapult.getAngle()-360)/360;*/
            catapult.setSpeed(P+I * (catapult.inDeadband() && P+I> 0 ? L: 1));
            lastError = error;
            loopTimer.reset();
//            System.out.println("Loop Angle = "+catapult.getAngle()+ ", DEADBAND = "+catapult.inDeadband());
        }
    }

    protected boolean isFinished()
    {
        return false;
    }

    protected void end()
    {
        loopTimer.stop();
        loopTimer.reset();
        errTimer.stop();
        errTimer.reset();
    }

    protected void interrupted()
    {
    }

    protected boolean onTarget()
    {
        return Math.abs(catapult.getAngle() - targetSP) <
               EndEffectorConstants.CAM_ACCEPTABLE_ERROR_DEG.get();
    }
}
