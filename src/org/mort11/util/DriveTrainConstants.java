package org.mort11.util;

import edu.first.util.preferences.DoublePreference;
import edu.first.util.preferences.IntegerPreference;

/**
 *
 * @author Annegret Werner
 */
public class DriveTrainConstants
{   
    public static final int DT_LEFT_FORWARD = -1;
    public static final int DT_RIGHT_FORWARD = 1;
    public static final double CONTROL_LOOP_HERTZ = 50;
    public static final DoublePreference ACCEPTABLE_LOOP_ERROR_PERCENT = new DoublePreference("ACCEPTABLE_LOOP_ERROR_PERCENT", 0.005);
    public static final DoublePreference CONTROL_LOOP_P = new DoublePreference("DT_CONTROL_LOOP_P",.1);
    public static final DoublePreference CONTROL_LOOP_I = new DoublePreference("DT_CONTROL_LOOP_I", .7);
    public static final DoublePreference CONTROL_LOOP_DELTA_P = new DoublePreference("DT_CONTROL_LOOP_DELTA_P",.01);
    public static final DoublePreference CONTROL_LOOP_DELTA_I = new DoublePreference("DT_CONTROL_LOOP_DELTA_I", .001);
    public static final double WHEEL_CIRCUMFERENCE_FEET = 4 * Math.PI / 12;
    public static final double LOW_MAX_FPS = 7;
    public static final double HIGH_MAX_FPS = 16;
    public static final double ACCEPTABLE_TURN_ERROR = 0;
    public static final double DT_ENCODER_CPR = 128.0;
    public static final double ENC_TO_WHEEL_RATIO = 1.0/5.0;
    public static final double DIST_PER_PULSE = (1.0 / DT_ENCODER_CPR)
            * WHEEL_CIRCUMFERENCE_FEET
            * ENC_TO_WHEEL_RATIO;
    public static final double ACCEPTABLE_ERROR_FT = 0.1;
    public static final double KAJ_Y = 1;
    public static final double KAJ_X = 1;
    public static final double TURN_P = 0;
    public static final boolean HIGH_GEAR = false;
    public static final boolean LOW_GEAR = true;
    public static final IntegerPreference DT_ENC_SAMPLES = new IntegerPreference("DT_ENC_SAMPLES",8);
    public static final DoublePreference ACCEL_TIME_MAX = new DoublePreference("ACCEL_TIME_MAX", .75);
}
