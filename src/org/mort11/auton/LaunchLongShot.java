/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mort11.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.mort11.auton.cheesy.CheesyWait;
import org.mort11.commands.ee.ActuateIntake;
import org.mort11.commands.ee.Launch;
import org.mort11.commands.ee.Prime;
import org.mort11.commands.ee.SetShotType;
import org.mort11.util.IntakeState;
import org.mort11.util.ShotType;

/**
 *
 * @author wm
 */
public class LaunchLongShot extends CommandGroup {
    
    public LaunchLongShot() {
        addSequential(new ActuateIntake(IntakeState.out));
        addSequential(new SetShotType(ShotType.STANDARD));
        addParallel(new Prime());
        addSequential(new CheesyWait(1.5, 6));
        addSequential(new Launch());
    }
}
