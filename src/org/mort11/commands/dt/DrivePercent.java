/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mort11.commands.dt;

import edu.first.util.log.Logger;
import org.mort11.commands.CommandBase;
import org.mort11.subsystems.DriveTrainSide;

/**
 *
 * @author gridbug
 */
public abstract class DrivePercent extends CommandBase
{
    private final double sp;
    protected DriveTrainSide dt;
    
    protected DrivePercent( DriveTrainSide dt, double percent)
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        if(percent > 1){
            percent = 1;
        }else if(percent < -1){
            percent = -1;
        }
        requires(dt);
        this.dt = dt;
        sp = percent;
        setInterruptible(true);
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
        dt.set(sp);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return false;
    }

    // Called once after isFinished returns true
    protected void end()
    {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
    }
}
