package org.mort11.util;

/**
 *
 * @author admin
 */
public class Gear
{

    private Gear(int val, String name, double maxFPS)
    {
        this.val = val;
        this.name = name;
        this.maxFPS = maxFPS;
    }
    
    public final int val;
    public final double maxFPS;
    public final String name;
    public static final Gear HighGear = new Gear(0, "HighGear",
                                                 DriveTrainConstants.HIGH_MAX_FPS);
    public static final Gear LowGear = new Gear(1, "LowGear",
                                                DriveTrainConstants.LOW_MAX_FPS);
}
