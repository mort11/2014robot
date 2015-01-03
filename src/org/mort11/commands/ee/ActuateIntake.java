package org.mort11.commands.ee;

import org.mort11.commands.CommandBase;
import org.mort11.util.IntakeState;

/**
 *
 * @author admin
 */
public class ActuateIntake extends CommandBase
{

    private IntakeState targetState;

    public ActuateIntake(IntakeState targetState)
    {
        this.targetState = targetState;
        requires(intake);
    }

    public ActuateIntake()
    {
        this(null);
    }

    protected void initialize()
    {
    }

    protected void execute()
    {   
        IntakeState newState = targetState;
        if(newState == null){
            newState = intake.getIntakeState() == IntakeState.in ? IntakeState.out: IntakeState.in;
        }
        
        if (newState == IntakeState.in) {
            intake.setIn(true);
            intake.setOut(false);
        } else {
            intake.setIn(false);
            intake.setOut(true);
        }
        intake.setIntakeState(newState);
    }

    protected boolean isFinished()
    {
        return true;
    }

    protected void end()
    {
    }

    protected void interrupted()
    {
    }
}