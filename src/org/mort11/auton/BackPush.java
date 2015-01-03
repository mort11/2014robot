/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mort11.auton;

import org.mort11.auton.cheesy.CheesyWait;
import org.mort11.commands.dt.MoveBoth;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.mort11.commands.dt.ResetLeftEncoder;
import org.mort11.commands.dt.ResetRightEncoder;
import org.mort11.commands.dt.ShiftGear;
import org.mort11.commands.ee.ActuateIntake;
import org.mort11.commands.ee.Load;
import org.mort11.commands.ee.SetShotType;
import org.mort11.commands.ee.Unload;
import org.mort11.util.Gear;
import org.mort11.util.IntakeState;
import org.mort11.util.ShotType;

/**
 *
 * @author gridbug
 */
public class BackPush extends CommandGroup
{
    
    public BackPush()
    {
        addParallel(new ActuateIntake(IntakeState.in));
        addSequential(new SetShotType(ShotType.STANDARD));
        addParallel(new ShiftGear(Gear.LowGear));
        addParallel(new ResetLeftEncoder());
        addParallel(new ResetRightEncoder());
        addParallel(new Load(.2));
        addSequential(new ActuateIntake(IntakeState.in));
        addSequential(new MoveBoth(-20, -20, 1));
        addSequential(new CheesyWait(2, 4));
        addSequential(new Unload());
    }
}
