/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mort11.commands.dt;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author wm
 */
public class DriveRelativeBoth extends CommandGroup {
    
    public DriveRelativeBoth(double percent) {
        addParallel(new DriveRelativeLeft(percent));
        addParallel(new DriveRelativeRight(percent));
    }
}
