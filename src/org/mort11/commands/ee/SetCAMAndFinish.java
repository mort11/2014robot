/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mort11.commands.ee;

import org.mort11.commands.CommandBase;

/**
 *
 * @author gridbug
 */
public class SetCAMAndFinish extends SetCAMAngle
{

    public SetCAMAndFinish(double targetDeg)
    {
        super(targetDeg);
    }
    
    protected boolean isFinished()
    {
        return onTarget();
    }
}
