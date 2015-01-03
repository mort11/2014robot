/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mort11.commands.dt;

import org.mort11.OI;

/**
 *
 * @author gridbug
 */
public class DriveLinearRight extends DriveLinear
{

    public DriveLinearRight()
    {
        super(rightDT);
    }

    protected double getSpeed()
    {
        return OI.doThreshold(-oi.getRightJoy().getY());
    }

}
