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
public class DrivePercentBoth extends CommandGroup {
    
    public DrivePercentBoth(double percent) {
        if(Math.abs(percent) > 1){
            percent = percent/Math.abs(percent);
        }
        addParallel(new DrivePercentLeft(percent));
        addParallel(new DrivePercentRight(percent));
    }
}
