/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.mort11.commands.dt;

import edu.first.util.preferences.DoublePreference;
import org.mort11.util.DriveTrainConstants;

/**
 *
 * @author wm
 */
public class SetLoopIConstant extends SetLoopConstant{

    public SetLoopIConstant(double newVal) {
        super(newVal);
    }
    
    
    protected DoublePreference getConstantPreference() {
        return DriveTrainConstants.CONTROL_LOOP_I;
    }

}
