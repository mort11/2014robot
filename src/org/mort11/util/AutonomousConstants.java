package org.mort11.util;

import java.lang.Math;

/**
 * @author Ryan Thant
 * @author Annegret Werner
 */
public class AutonomousConstants
{

    public static final boolean HOTGOAL = true;
    public static final int HOTWAIT = 5;
    public static final int DT_2_BALL = 2;
    public static final int WALL_DISTANCE = 16;
    public static final double GOAL_YAW = 0; //determined by camera
    public static final double GOAL_YAW_OFFSET = GOAL_YAW - 5;
    public static final double SHOOT_DISTANCE = WALL_DISTANCE
            / Math.cos(GOAL_YAW_OFFSET);
    public static final double SHOOT_DISPLACEMENT = SHOOT_DISTANCE
            - WALL_DISTANCE;
}
