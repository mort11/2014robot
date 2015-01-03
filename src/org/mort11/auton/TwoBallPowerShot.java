/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mort11.auton;

import org.mort11.commands.dt.SoftBrake;
import org.mort11.commands.dt.MoveBoth;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.PrintCommand;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.mort11.commands.CommandBase;
import org.mort11.commands.dt.ResetLeftEncoder;
import org.mort11.commands.dt.ResetRightEncoder;
import org.mort11.commands.dt.ShiftGear;
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
public class TwoBallPowerShot extends CommandGroup
{

    public TwoBallPowerShot()
    {
        addParallel(new ActuateIntake(IntakeState.out));
        addSequential(new SetShotType(ShotType.STANDARD));
        addParallel(new ShiftGear(Gear.LowGear));
        addParallel(new ResetLeftEncoder());
        addParallel(new ResetRightEncoder());
        addParallel(new SetCAMAngle(EndEffectorConstants.CAM_PRIMED_DEG.get() -10));
        addSequential(new WaitCommand(.3));
        addParallel(new PrintCommand("Catapult Down"));
        addParallel(new SetShotType(ShotType.LOB));
        addParallel(new CamIdle());
        addSequential(new WaitCommand(.3));
        addParallel(new PrintCommand("Catapult Up"));
        addParallel(new Load(.6));
        addSequential(new MoveBoth(-2, -2, .7), .9);
        
//        addSequential(new WaitCommand(.5));

        addSequential(new MoveBoth(6.5+2, 6.5+2, .9
        ));
        addParallel(new PrintCommand("Done with movement"));
        addSequential(new SoftBrake(),.1);
        addParallel(new Prime());
        addSequential(new Unload(.4), .1);
        addParallel(new DontLoad());
        addParallel(new SetShotType(ShotType.STANDARD));
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
