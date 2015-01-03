package org.mort11.commands.ee;

import org.mort11.commands.CommandBase;
import org.mort11.util.EndEffectorConstants;

public class Unload extends CommandBase
{

    private final double speed;
    
    public Unload(){
        this(1);
    }
    
    public Unload(double speed)
    {
        this.speed = speed;
        setInterruptible(true);
        requires(intake);

    }

    protected void initialize()
    {
    }

    protected void execute()
    {
        intake.rollIntake(EndEffectorConstants.INTAKE_SPEED.get() * EndEffectorConstants.INTAKE_OUT * speed);
    }

    protected boolean isFinished()
    {
        return false;
    }

    protected void end()
    {
    }

    protected void interrupted()
    {
    }
}
