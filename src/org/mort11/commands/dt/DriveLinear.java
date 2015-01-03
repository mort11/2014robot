package org.mort11.commands.dt;

import org.mort11.commands.CommandBase;
import org.mort11.subsystems.DriveTrainSide;

/**
 *
 * @author admin
 */
public abstract class DriveLinear extends CommandBase
{

    protected final DriveTrainSide side;
    
    protected DriveLinear(DriveTrainSide dt)
    {
        side = dt;
        requires(dt);
        setInterruptible(true);
    }

    protected void initialize()
    {
    }

    protected abstract double getSpeed();
    
    protected  void execute(){
        side.set(getSpeed());
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
