package org.mort11.commands;

import edu.wpi.first.wpilibj.DriverStation;

public class Compress extends CommandBase
{

    public Compress()
    {
        requires(comp);

    }

    protected void initialize()
    {
    }

    protected void execute()
    {
        if (DriverStation.getInstance().getBatteryVoltage() < 11 && 
                (DriverStation.getInstance().getMatchTime() < 120 &&
                DriverStation.getInstance().isFMSAttached())) {
            comp.stop();
        } else {
            comp.start();
        }
    }

    protected boolean isFinished()
    {
        return false;
    }

    protected void end()
    {
    }

    protected void interrupted()
    {
    }
}
