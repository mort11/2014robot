/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mort11.commands.dt;

import edu.first.util.preferences.DoublePreference;
import org.mort11.commands.CommandBase;
import org.mort11.util.DriveTrainConstants;

/**
 *
 * @author wm
 */
public abstract class SetLoopConstant extends CommandBase {
    protected double newVal;
    public SetLoopConstant(double newVal) {
        this.newVal= newVal;
    }

    protected abstract DoublePreference getConstantPreference();
    
    protected void execute() {
        getConstantPreference().set(newVal);
        System.out.println(getConstantPreference().getKey() + " = "+ newVal);
    }

    protected boolean isFinished() {
        return true;
    }

    protected void initialize() {
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
