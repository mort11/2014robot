package org.mort11.commands.ee;

import org.mort11.commands.CommandBase;
import org.mort11.util.EndEffectorConstants;
import org.mort11.util.IntakeState;

public class Launch extends CommandBase
{

    public Launch()
    {
        requires(catapult);
        requires(intake);

    }

    protected void initialize()
    {
    }

    protected void execute()
    {

        if (intake.getIntakeState() == IntakeState.out) {
            catapult.setSpeed(EndEffectorConstants.CAM_LAUNCH_SPEED);
            catapult.setPrimed(false);
        } else {
            cancel();
        }
    }

    protected boolean isFinished()
    {
        return (catapult.getAngle() <90) ;
    }

    protected void end()
    {
    }

    protected void interrupted()
    {
    }
}
