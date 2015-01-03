/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mort11.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.mort11.auton.cheesy.CheesyLaunch;
import org.mort11.commands.dt.MoveBoth;
import org.mort11.commands.dt.ResetLeftEncoder;
import org.mort11.commands.dt.ResetRightEncoder;
import org.mort11.commands.dt.ShiftGear;
import org.mort11.commands.dt.SoftBrake;
import org.mort11.commands.ee.ActuateIntake;
import org.mort11.commands.ee.DontLoad;
import org.mort11.commands.ee.Launch;
import org.mort11.commands.ee.Load;
import org.mort11.commands.ee.Prime;
import org.mort11.commands.ee.SetShotType;
import org.mort11.util.Gear;
import org.mort11.util.IntakeState;
import org.mort11.util.ShotType;

/**
 *
 * @author gridbug
 */
public class TwoBallLongShot extends CommandGroup
{
    
    public TwoBallLongShot()
    {
        addSequential(new LaunchLongShot());
        addParallel(new Load());
        addParallel(new WaitCommand(1.3));
        addSequential(new MoveBoth(-2,-2, .7));
        addSequential(new MoveBoth(2,2, .7));
        addSequential(new SoftBrake(),.1);
        addSequential(new WaitCommand(.5));
        addSequential(new CheesyLaunch(), 3);
        addParallel(new DontLoad(), .1);
        addSequential(new DriveIntoZone1());
    }
}
