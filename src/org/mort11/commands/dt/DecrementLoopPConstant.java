/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.mort11.commands.dt;

import org.mort11.util.DriveTrainConstants;

/**
 *
 * @author wm
 */
public class DecrementLoopPConstant extends SetLoopPConstant{

    public DecrementLoopPConstant() {
        super(DriveTrainConstants.CONTROL_LOOP_P.get());
    }
    
    protected void initialize(){
        newVal = DriveTrainConstants.CONTROL_LOOP_P.get() - DriveTrainConstants.CONTROL_LOOP_DELTA_P.get();
    }
    
    
}
