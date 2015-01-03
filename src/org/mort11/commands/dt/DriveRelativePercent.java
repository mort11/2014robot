/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mort11.commands.dt;

import org.mort11.commands.CommandBase;

/**
 *
 * @author gridbug
 */
public class DriveRelativePercent extends CommandBase
{
    private double sp;
    
    public DriveRelativePercent(double percent)
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        
    }
    // subsystems is scheduled to run
    protected void interrupted()
    {
        
    }

    protected void initialize()
    {
    }

    protected void execute()
    {
//        new DrivePercent(leftDT.getCurVal()+sp).start();
    }

    protected boolean isFinished()
    {
        return true;
    }

    protected void end()
    {
    }
}
