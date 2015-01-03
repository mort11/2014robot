/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mort11.auton;

import org.mort11.commands.dt.SoftBrake;
import org.mort11.auton.cheesy.CheesyWait;
import org.mort11.commands.dt.MoveBoth;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.PrintCommand;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.mort11.commands.CommandBase;
import org.mort11.commands.dt.ResetLeftEncoder;
import org.mort11.commands.dt.ResetRightEncoder;
import org.mort11.commands.dt.ShiftGear;
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
public class OneBallPowerShot extends CommandGroup
{
    public OneBallPowerShot()
    {
        addSequential(new ActuateIntake(IntakeState.out));
        addSequential(new SetShotType(ShotType.STANDARD));
        addParallel(new Prime());
        addSequential(new ShiftGear(Gear.LowGear));
        addSequential(new ResetLeftEncoder());
        addSequential(new ResetRightEncoder());
        addSequential(new WaitCommand(.5));
        addSequential(new MoveBoth(10,10 , 1));
        addSequential(new PrintCommand("Done with movement, "+CommandBase.leftDT.getDist()));
        addSequential(new SoftBrake(),.1);
        addSequential(new PrintCommand("Ready to Launch"));
        addSequential(new CheesyWait(1.2, 3.5));
        addSequential(new Launch());
    }
}
