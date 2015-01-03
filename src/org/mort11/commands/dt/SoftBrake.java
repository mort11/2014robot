/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.mort11.commands.dt;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.mort11.commands.CommandBase;
import org.mort11.commands.dt.DriveLinearRight;
import org.mort11.commands.dt.DrivePercent;
import org.mort11.commands.dt.DrivePercentLeft;
import org.mort11.commands.dt.DrivePercentRight;

/**
 *
 * @author gridbug
 */
public class SoftBrake extends CommandGroup
{
    public SoftBrake(){
        this.addParallel(new DrivePercentLeft(0));
        this.addParallel(new DrivePercentRight(0));
    }
}
