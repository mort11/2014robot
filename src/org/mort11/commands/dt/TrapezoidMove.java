/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mort11.commands.dt;

import edu.wpi.first.wpilibj.Timer;
import org.mort11.commands.CommandBase;
import org.mort11.subsystems.DriveTrainSide;
import org.mort11.util.DriveTrainConstants;

/**
 *
 * @author gridbug
 */
public abstract class TrapezoidMove extends DriveFPS
{
    protected final double cruiseTime;
    protected double accelTime = DriveTrainConstants.ACCEL_TIME_MAX.get();
    protected final double maxSpeed;
    protected final Timer trapezoidTimer =  new Timer();

    /*
     accelTime + deccelTime + cruiseTime = targetTime;
    int(speed) = distance
    C  = maxSpeed
    @ cruiseTime, dspeed = 0, distance = cruiseTime * C
    @ accelTime, dspeed  1, speed = Ct, distance = (C*t/2) 
    @ deccelTime, dspeed = -1, speed = -Ct, distance = (C*t/2)
    C*ct + C*at/2 + C*dt/2 = C*ct + C*at = distance
    max accelTime || decelTime = .75
    */
    
    protected  TrapezoidMove(DriveTrainSide dt, double distance, double maxSpeed) 
    {
        super(dt);
        if(distance > maxSpeed * accelTime){
            // Can't reach max Speed
            accelTime = distance / maxSpeed;    
        }
        this.maxSpeed = Math.abs(maxSpeed) * distance/ Math.abs(distance);
        distance -= accelTime * maxSpeed;
        //should ensure distance still > 0, because floating point
        if(distance > 0){
            cruiseTime = distance / maxSpeed;
        }else{
            cruiseTime = 0;
        }
        
    }
    
    protected void initialize()
    {
        super.initialize();
        dt.resetEnc();
        trapezoidTimer.start();
        super.sp = 0;
    }


    protected void execute()
    {
        super.execute();
        double moveTime = trapezoidTimer.get();
        if(moveTime<= accelTime){
            super.sp = maxSpeed * moveTime/accelTime;
        }else if(moveTime > accelTime && moveTime <= accelTime + cruiseTime){
            super.sp = maxSpeed;
        }else if(moveTime > accelTime + cruiseTime && moveTime <= 2* accelTime + cruiseTime){
            super.sp = maxSpeed * ((2 * accelTime + cruiseTime) - moveTime)/accelTime;
        }else{
            super.sp = 0;
        }
    }

    protected boolean isFinished()
    {
        return trapezoidTimer.get() > 2* accelTime + cruiseTime;
    }

}
