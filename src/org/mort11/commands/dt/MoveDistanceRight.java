/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.mort11.commands.dt;

import org.mort11.commands.CommandBase;

/**
 *
 * @author gridbug
 */
public class MoveDistanceRight extends MoveDistance
{
    public MoveDistanceRight(double dist, double speed)
    {
        super(rightDT, dist, speed);
    }
}
