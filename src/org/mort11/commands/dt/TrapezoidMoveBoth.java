package org.mort11.commands.dt;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.mort11.commands.dt.TrapezoidMoveLeft;
import org.mort11.commands.dt.TrapezoidMoveRight;

/**
 *
 * @author wm
 */
public class TrapezoidMoveBoth extends CommandGroup {
    
    public TrapezoidMoveBoth(double ldistance,double rdistance, double maxSpeed) {
        addParallel(new TrapezoidMoveLeft(ldistance, maxSpeed));
        addParallel(new TrapezoidMoveRight(rdistance, maxSpeed));
    }
}
