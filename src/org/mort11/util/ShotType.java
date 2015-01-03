/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.mort11.util;

/**
 *
 * @author gridbug
 */
public class ShotType
{
    private ShotType(int val, String name)
    {
        this.val = val;
        this.name = name;
    }
    public final String name;
    public final int val;
    
    public static final ShotType STANDARD = new ShotType(0, "STANDARD");
    public static final ShotType LOB = new ShotType(1, "LOB");
    public static final ShotType GOALIE = new ShotType(2, "Goalie");
}
