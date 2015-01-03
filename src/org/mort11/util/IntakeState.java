package org.mort11.util;

/**
 *
 * @author admin
 */
public class IntakeState
{

    private IntakeState(int val, String name)
    {
        this.val = val;
        this.name = name;
    }
    
    public String toString(){
        return name;
    }
    private final int val;
    private final String name;
    public static final IntakeState in = new IntakeState(0, "in");
    public static final IntakeState out = new IntakeState(1, "out");
}
