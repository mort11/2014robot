package org.mort11.util;

import edu.first.util.preferences.DoublePreference;
import edu.wpi.first.wpilibj.Preferences;

/**
 *
 * @author Annegret Werner and Sahit Chintalapudi
 */
public class EndEffectorConstants
{
    public static final int AVERAGE_POT_BITS = 8;
    public static final int CAM_TALON_PORT = 3;
    public static final int CAM_FORWARD = -1;
    public static final double CAM_LAUNCH_SPEED = 1;
    public static final DoublePreference CAM_PRIMED_DEG = new DoublePreference("CAM_PRIMED_DEG", 340);
    public static DoublePreference CAM_P_CONSTANT = 
            new DoublePreference("CAM_P_CONSTANT", 0.02); // GAIN Should be .02
    public static DoublePreference CAM_I_CONSTANT = new DoublePreference("CAM_I_CONSTANT",8); 
    public static DoublePreference CAM_L_CONSTANT = new DoublePreference("CAM_L_CONSTANT",.3); //GAIN to push back from edge of signal;
    public static DoublePreference CAM_OFFSET = 
            new DoublePreference("CAM_OFFSET",-80);
    public static DoublePreference CAM_DEADBAND_DEG = new DoublePreference("CAM_DEADBAND_DEG", 30);
    public static DoublePreference CAM_ACCEPTABLE_ERROR_DEG = new DoublePreference("CAM_ACCEPTABLE_ERROR_DEG", 2.0);                        
    public static final double CAM_LOOP_HERTZ = 50;
    public static final double CAM_SCALE  = 360.0/5.0;
    public static DoublePreference CAM_SHOOT_SPEED = new DoublePreference("CAM_SHOT_SPEED", 1);            
    public static final double INTAKE_FORWARD = 1;
    public static DoublePreference INTAKE_SPEED = new DoublePreference("ROLLER_SPEED", 1);            
    public static final double INTAKE_IN = 1;
    public static final double INTAKE_OUT = -INTAKE_IN;
    public static final int INTAKE_IN_SOLENOID_PORT = 3;
    public static final int INTAKE_OUT_SOLENOID_PORT = 4;
    public static int STOP_SOLENOID_PORT = 5;
    public static DoublePreference PASSBACK_ANGLE_DEG = new DoublePreference("PASSBACK_ANGLE_DEG",30);
}
