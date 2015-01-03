/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mort11.commands.ee;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.mort11.commands.CommandBase;
import org.mort11.util.EndEffectorConstants;
import org.mort11.util.ShotType;

/**
 *
 * @author gridbug
 */
public class CatapultBallLockout extends CommandGroup
{
    public CatapultBallLockout(){
        addSequential(new SetCAMAndFinish(EndEffectorConstants.CAM_PRIMED_DEG.get()));
        addSequential(new SetShotType(ShotType.LOB));
        addSequential(new SetManualCam());
    }
}
