/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.mort11.commands.ee;

import org.mort11.util.EndEffectorConstants;
import org.mort11.util.IntakeState;
import org.mort11.util.ShotType;

/**
 *
 * @author wm
 */
public class PassBack extends SetCAMAndFinish{

    public PassBack() {
        super(EndEffectorConstants.PASSBACK_ANGLE_DEG.get());
        requires(hardStop);
        
    }
    
    protected void initialize(){
        super.initialize();
        if(intake.getIntakeState() == IntakeState.in){
            cancel();
        }
       hardStop.setShotType(ShotType.STANDARD);
    }
}
