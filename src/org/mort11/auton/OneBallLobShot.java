/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mort11.auton;

import org.mort11.commands.dt.SoftBrake;
import org.mort11.auton.cheesy.CheesyWait;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.PrintCommand;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.mort11.commands.dt.MoveDistanceLeft;
import org.mort11.commands.dt.MoveDistanceRight;
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
 * @author SCh
 */
public class OneBallLobShot extends CommandGroup{
    public OneBallLobShot() 
    {
        addSequential(new ActuateIntake(IntakeState.out));
        addSequential(new SetShotType(ShotType.LOB));
        addParallel(new Prime());
        addSequential(new ShiftGear(Gear.LowGear));
        addSequential(new ResetLeftEncoder());
        addSequential(new ResetRightEncoder());
        addSequential(new WaitCommand(.5));
        addSequential(new MoveDistanceRight(13.25, 1), 4.5);
        addSequential(new MoveDistanceLeft(13.25, 0.9), 4.5);
        addSequential(new PrintCommand("Done with movement"));
        addSequential(new SoftBrake(),.1);
        addSequential(new PrintCommand("Ready to Launch"));
        addSequential(new CheesyWait(1.2, 3.5));
        addSequential(new Launch());
    }
}
