/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mort11.auton.cheesy;

import edu.wpi.first.wpilibj.Timer;
import org.mort11.commands.CommandBase;

/**
 *
 * @author gridbug
 */
public class CheesyWait extends CommandBase
{

    private final Timer timer;
    private final double minWait, maxWait;

    public CheesyWait(double min, double max)
    {
        timer = new Timer();
        minWait = min;
        maxWait = max;
    }

    protected void initialize()
    {
        timer.start();
    }

    protected void execute()
    {

        System.out.println("Left =" + visionServer.getLeftStatus() +
                           ", Timer = " + timer.get());
    }

    protected boolean isFinished()
    {
        return timer.get() >= maxWait || (timer.get() > minWait && visionServer.
                                          getLeftStatus());
    }

    protected void end()
    {
    }

    protected void interrupted()
    {
    }

}
