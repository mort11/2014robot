/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mort11.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.mort11.RobotMap;
import org.mort11.util.EndEffectorConstants;
import org.mort11.util.ShotType;

/**
 *
 * @author gridbug
 */
public class HardStop extends Subsystem
{
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private final Solenoid stopper1, stopper2;
    private ShotType currentShot = ShotType.STANDARD;
    
    public HardStop(){
        stopper1 = new Solenoid(RobotMap.STOP_SOLENOID_PORT1);
        stopper2 = new Solenoid(RobotMap.STOP_SOLENOID_PORT2);
    }
    
    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void setShotType(ShotType state)
    {
        currentShot = state;
        if(state == ShotType.STANDARD){
            stopper1.set(false);
            stopper2.set(true);
        }else if (state == ShotType.LOB) {
            stopper1.set(true);
            stopper2.set(false);
        }else if (state == ShotType.GOALIE) {
            stopper1.set(false);
            stopper2.set(false);
        }
    }
    
    public ShotType getShotType(){
        return currentShot;
    }
    
}
