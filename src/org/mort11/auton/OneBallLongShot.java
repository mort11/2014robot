/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mort11.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 * @author wm
 */
public class OneBallLongShot extends CommandGroup {
    
    public OneBallLongShot() {
        addSequential(new LaunchLongShot());
        addSequential(new WaitCommand(1));
        addSequential(new DriveIntoZone1());
    }
}
