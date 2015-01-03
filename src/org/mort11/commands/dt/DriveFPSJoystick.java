/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.mort11.commands.dt;

import edu.wpi.first.wpilibj.Joystick;
import org.mort11.OI;
import org.mort11.subsystems.DriveTrainSide;

/**
 *
 * @author gridbug
 */
public abstract class DriveFPSJoystick extends DriveFPS
{

    private final Joystick joy;
    
    public DriveFPSJoystick(DriveTrainSide side, Joystick joy)
    {
        super(side);
        this.joy = joy;
    }
    
    protected void execute(){
        sp = gears.getGear().maxFPS * OI.doThreshold(-joy.getY());
        super.execute();
    }
    
}
