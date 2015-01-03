/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.mort11.commands.dt;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.mort11.commands.dt.MoveDistanceLeft;
import org.mort11.commands.dt.MoveDistanceRight;

/**
 *
 * @author gridbug
 */
public class MoveBoth extends CommandGroup{
        public MoveBoth(double left, double right, double speed){
            this.addParallel(new MoveDistanceLeft(left, speed));
            this.addSequential(new MoveDistanceRight(right, speed));
//            this.addParallel(new TrapezoidMoveLeft(left, .3, speed));
//            this.addSequential(new TrapezoidMoveRight(right, .3, speed));
        }
        
    }
