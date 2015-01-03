/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mort11.auton.cheesy;

import org.mort11.commands.CommandBase;

/**
 *
 * @author gridbug
 */
public class CheesyDrive extends CommandBase
{
    
    public static final double SPEED_CONST = .6;
    
    public CheesyDrive()
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(leftDT);
        requires(rightDT);
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
        if (visionServer.getLeftStatus()&&!visionServer.getRightStatus()) {
            leftDT.set(SPEED_CONST);
            rightDT.set(SPEED_CONST);
        }else if(!visionServer.getLeftStatus()&&visionServer.getRightStatus()){
            leftDT.set(-SPEED_CONST);
            rightDT.set(-SPEED_CONST);
        }else{
            leftDT.set(0);
            rightDT.set(0);
        }
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
