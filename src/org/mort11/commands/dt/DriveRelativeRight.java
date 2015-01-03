/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mort11.commands.dt;

/**
 *
 * @author wm
 */
public class DriveRelativeRight extends DrivePercentRight {
    
    public DriveRelativeRight(double percent) {
        super(percent + rightDT.getCurVal());

        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
}
