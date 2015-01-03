/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mort11.auton;

import org.mort11.auton.cheesy.CheesyDrive;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.mort11.commands.dt.ResetLeftEncoder;
import org.mort11.commands.dt.ResetRightEncoder;
import org.mort11.commands.dt.ShiftGear;
import org.mort11.commands.ee.ActuateIntake;
import org.mort11.commands.ee.Prime;
import org.mort11.commands.ee.SetShotType;
import org.mort11.util.Gear;
import org.mort11.util.IntakeState;
import org.mort11.util.ShotType;

/**
 *
 * @author gridbug
 */
public class GoaliePoleAuton extends CommandGroup
{
    
    public GoaliePoleAuton()
    {
        addSequential(new ActuateIntake(IntakeState.in));
        addParallel(new SetShotType(ShotType.GOALIE));
        addParallel(new Prime());
        addSequential(new ShiftGear(Gear.LowGear));
        addSequential(new ResetLeftEncoder());
        addSequential(new ResetRightEncoder());
        addSequential(new CheesyDrive());
    }    
    
}
