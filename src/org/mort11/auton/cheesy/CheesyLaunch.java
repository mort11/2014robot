/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.mort11.auton.cheesy;

import org.mort11.commands.ee.Launch;

/**
 *
 * @author gridbug
 */
public class CheesyLaunch extends Launch
{
    protected void execute(){
        if(!visionServer.getRightStatus()){
            super.execute();
        }
    }
}
