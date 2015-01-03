/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.mort11.subsystems;

import org.mort11.RobotMap;
import org.mort11.commands.dt.DriveFPSJoystick;
import org.mort11.commands.dt.DriveFPSLeftJoy;
import org.mort11.commands.dt.DriveLinear;
import org.mort11.commands.dt.DriveLinearLeft;
import org.mort11.commands.dt.DrivePercentLeft;

/**
 *
 * @author gridbug
 */
public class LeftDriveTrain extends DriveTrainSide
{
    
    public LeftDriveTrain()
    {
        super(RobotMap.DT_LEFT_PORT, RobotMap.DT_ENCODER_LEFT_A,
              RobotMap.DT_ENCODER_LEFT_B,true, false);
    }
    
    protected DriveFPSJoystick getJoystickFPSDrive() {
        return new DriveFPSLeftJoy();
    }

    protected DriveLinear getLinearDrive() {
        return new DriveLinearLeft();
    }
    
}
