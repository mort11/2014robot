/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mort11.commands.ee;

import org.mort11.commands.CommandBase;
import org.mort11.subsystems.HardStop;
import org.mort11.util.ShotType;

/**
 *
 * @author gridbug
 */
public class SetShotType extends CommandBase
{
    
    private final ShotType type;
    
    public SetShotType(ShotType type)
    {
        requires(hardStop);
        this.type = type;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
    
    public SetShotType()
    {
        this(hardStop.getShotType() == ShotType.STANDARD ? ShotType.LOB :
             ShotType.STANDARD);
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
        hardStop.setShotType(type);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return true;
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
