/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.mort11.commands.dt;

import org.mort11.subsystems.DriveTrainSide;

/**
 *
 * @author gridbug
 */
public class DrivePercentRight extends DrivePercent
{

    public DrivePercentRight(double percent)
    {
        super(rightDT, percent);
    }
    
}
