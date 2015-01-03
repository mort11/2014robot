/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mort11.commands.dt;

import org.mort11.commands.CommandBase;
import org.mort11.subsystems.DriveTrainSide;

/**
 *
 * @author admin
 */
public abstract class Brake extends DriveFPS
{
    
    protected Brake(DriveTrainSide dt){
        super(dt);
        sp = 0;
    }
    
}