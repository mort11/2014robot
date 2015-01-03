/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mort11.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.PrintCommand;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.mort11.auton.cheesy.CheesyWait;
import org.mort11.commands.CommandBase;
import org.mort11.commands.dt.BrakeBoth;
import org.mort11.commands.dt.MoveBoth;
import org.mort11.commands.dt.ResetLeftEncoder;
import org.mort11.commands.dt.ResetRightEncoder;
import org.mort11.commands.dt.ShiftGear;
import org.mort11.commands.dt.SoftBrake;
import org.mort11.commands.dt.TrapezoidMoveBoth;
import org.mort11.commands.ee.ActuateIntake;
import org.mort11.commands.ee.Launch;
import org.mort11.commands.ee.Prime;
import org.mort11.commands.ee.SetShotType;
import org.mort11.util.Gear;
import org.mort11.util.IntakeState;
import org.mort11.util.ShotType;

/**
 *
 * @author gridbug
 */
public class OneBallPowerShotControlled extends CommandGroup
{
    public OneBallPowerShotControlled()
    {
        addSequential(new ActuateIntake(IntakeState.out));
        addSequential(new SetShotType(ShotType.STANDARD));
        addParallel(new Prime());
        addSequential(new ShiftGear(Gear.HighGear));
//        addSequential(new WaitCommand(.5));
        addSequential(new TrapezoidMoveBoth(13,13 , 10));
        addSequential(new PrintCommand("Done with movement, "+CommandBase.leftDT.getDist()));
        addParallel(new BrakeBoth());
        addSequential(new PrintCommand("Ready to Launch"));
        addSequential(new CheesyWait(.5, 3.5));
        addSequential(new Launch());
        addParallel(new Prime());
    }
}
