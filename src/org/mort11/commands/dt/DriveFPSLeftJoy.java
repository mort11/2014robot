/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.mort11.commands.dt;

import edu.wpi.first.wpilibj.Joystick;
import org.mort11.subsystems.DriveTrainSide;

/**
 *
 * @author gridbug
 */
public class DriveFPSLeftJoy extends DriveFPSJoystick
{

    public DriveFPSLeftJoy()
    {
        super(leftDT, oi.getLeftJoy());
    }
    
}
