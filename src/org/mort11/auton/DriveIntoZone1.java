/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.mort11.auton;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.mort11.commands.dt.MoveBoth;
import org.mort11.commands.dt.SoftBrake;

/**
 *
 * @author wm
 */
class DriveIntoZone1 extends CommandGroup {

    public DriveIntoZone1() {
        addSequential(new MoveBoth(6,6,.5));
        addSequential(new SoftBrake(), .2);
    }
    
}
