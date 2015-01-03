package org.mort11.commands.dt;

import org.mort11.commands.CommandBase;
import org.mort11.util.Gear;

/**
 *
 * @author admin
 */
public class ShiftGear extends CommandBase
{

    Gear targetGear;

    public ShiftGear(Gear gear)
    {
        this.targetGear = gear;
        requires(gears);

    }

    public ShiftGear()
    {
        this(null);
    }

    protected void initialize()
    {
    }

    protected void execute()
    {
        Gear newGear = targetGear;
        if(newGear == null){
            newGear = gears.getGear() == Gear.LowGear ? Gear.HighGear : Gear.LowGear;
        }
        if (newGear == Gear.LowGear) {
            gears.setHigh(false);
            gears.setLow(true);
        } else {
            gears.setHigh(true);
            gears.setLow(false);
        }
        gears.setGear(newGear);
    }

    protected boolean isFinished()
    {
        return true;
    }

    protected void end()
    {
    }

    protected void interrupted()
    {
    }
}