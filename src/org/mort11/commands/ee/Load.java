package org.mort11.commands.ee;

import org.mort11.commands.CommandBase;
import org.mort11.commands.CommandBase;
import org.mort11.util.EndEffectorConstants;

public class Load extends CommandBase
{
    private final double speed ;
    
    public Load(){
        this(1);
    }
    
    public Load(double speed)
    {
        this.speed = speed;
        setInterruptible(true);
        requires(intake);

    }

    protected void initialize()
    {
        System.out.println("Loading");
    }

    protected void execute()
    {
        intake.rollIntake(EndEffectorConstants.INTAKE_SPEED.get() * EndEffectorConstants.INTAKE_IN * speed);
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
