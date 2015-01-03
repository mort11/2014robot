package org.mort11.util;

/**
 *
 * @author Sahit Chintalapudi
 */
public class DriveStyle
{
    

    private DriveStyle(int val, String name)
    {
        this.val = val;
        this.name = name;
    }
    public final String name;
    public final int val;
    public static final DriveStyle TANK = new DriveStyle(1, "TANK");
    public static final DriveStyle TANK_INV = new DriveStyle(2, "TANK_INV");
    public static final DriveStyle KAJ = new DriveStyle(3, "KAJ");
    public static final DriveStyle PID_TANK = new DriveStyle(4, "PID_TANK");
}
