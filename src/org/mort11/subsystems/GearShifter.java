package org.mort11.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.mort11.RobotMap;
import org.mort11.util.Gear;
import org.mort11.commands.Compress;
import org.mort11.util.DriveTrainConstants;

/**
 *
 * @author admin    }

 */
public class GearShifter extends Subsystem
{

    private final Solenoid low;
    private final Solenoid high;
    Gear curGear;

    public GearShifter()
    {
        low = new Solenoid(RobotMap.DT_LOW_SOLENOID_PORT);
        high = new Solenoid(RobotMap.DT_HIGH_SOLENOID_PORT);
        curGear = Gear.LowGear;
        

    }


    public void shift(Gear gear)
    {
        curGear = gear;
    }

    public Gear getGear()
    {
        return curGear;
    }

    public void setLow(boolean low)
    {
        this.low.set(low);
    }

    public void setHigh(boolean high)
    {
        this.high.set(high);
    }

    public void setGear(Gear gear)
    {
        this.curGear = gear;
    }

    protected void initDefaultCommand()
    {
    }

}