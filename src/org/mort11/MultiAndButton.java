/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.mort11;

import edu.wpi.first.wpilibj.buttons.Button;

/**
 *
 * @author gridbug
 */
public class MultiAndButton extends Button
{

    private final Button[] buttons;
    
    public MultiAndButton(Button[] buttons){
        this.buttons = buttons;
    }
    
    public boolean get()
    {
        boolean retVal = true;
        for(int i = 0; i < buttons.length; i++){
            retVal = retVal && buttons[i].get();
        }
        return retVal;
    }
    
}
