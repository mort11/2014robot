/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mort11.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.PrintCommand;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.mort11.commands.CommandBase;
import org.mort11.commands.dt.BrakeBoth;
import org.mort11.commands.dt.MoveBoth;
import org.mort11.commands.dt.ResetLeftEncoder;
import org.mort11.commands.dt.ResetRightEncoder;
import org.mort11.commands.dt.ShiftGear;
import org.mort11.commands.dt.SoftBrake;
import org.mort11.commands.dt.TrapezoidMoveBoth;
import org.mort11.commands.ee.ActuateIntake;
import org.mort11.commands.ee.CamIdle;
import org.mort11.commands.ee.CatapultBallLockout;
import org.mort11.commands.ee.DontLoad;
import org.mort11.commands.ee.Launch;
import org.mort11.commands.ee.Load;
import org.mort11.commands.ee.Prime;
import org.mort11.commands.ee.SetCAMAndFinish;
import org.mort11.commands.ee.SetCAMAngle;
import org.mort11.commands.ee.SetCamIdle;
import org.mort11.commands.ee.SetCamPrime;
import org.mort11.commands.ee.SetManualCam;
import org.mort11.commands.ee.SetShotType;
import org.mort11.commands.ee.Unload;
import org.mort11.util.EndEffectorConstants;
import org.mort11.util.Gear;
import org.mort11.util.IntakeState;
import org.mort11.util.ShotType;

/**
 *
 * @author gridbug
 */
public class TwoBallPowerShotControlled extends CommandGroup
{

    public TwoBallPowerShotControlled()
    {
        addParallel(new ActuateIntake(IntakeState.out));
        addSequential(new SetShotType(ShotType.STANDARD));
        addParallel(new ShiftGear(Gear.HighGear));
        addParallel(new Prime());
        addSequential(new WaitCommand(.3));
        addParallel(new PrintCommand("Catapult Down"));
        addParallel(new Load(.6));
        addSequential(new TrapezoidMoveBoth(-2, -2, 7));
        addSequential(new TrapezoidMoveBoth(13+2, 13+2, 7
        ));
        addParallel(new PrintCommand("Done with movement"));
        addParallel(new BrakeBoth());
        addParallel(new DontLoad());
        addParallel(new PrintCommand("Ready to Launch"));
        addSequential(new WaitCommand(1.1));
        /**
         * addParallel(new PrintCommand("Launch"));
        addSequential(new Launch());
        addParallel(new Prime());
        addSequential(new WaitCommand(1.2));
        addParallel(new Load(.7));
        addSequential(new MoveBoth(-5, -5, .9));
        addSequential(new MoveBoth(3, 3, .8));
        addSequential(new Stop() ,.1);
        addSequential(new WaitCommand(.7));
        addParallel(new DontLoad());
        addParallel(new PrintCommand("Launch"));
        addSequential(new CheesyLaunch());
*/
    }
}
