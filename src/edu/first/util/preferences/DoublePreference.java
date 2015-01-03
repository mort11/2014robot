package edu.first.util.preferences; 

import edu.first.util.log.Logger;
import edu.wpi.first.wpilibj.Preferences;

/**
 * Preference that holds a double value.
 *
 * @since June 13 13
 * @author Joel Gallant
 */
public final class DoublePreference extends Preference {

    private final double defaultValue;
    private double value;
    /**
     * Constructs the preference with its key used to access it in
     * {@link Preferences}.
     *
     * @param key string to access preference
     * @param defaultValue value to set if none exist
     */
    public DoublePreference(String key, double defaultValue) {
        super(key);
        this.defaultValue = defaultValue;        
        value = PREFERENCES.getDouble(key, defaultValue);
    }

    /**
     * Sets the value of the preference. Will not save over reboot.
     *
     * @param value new value of preference
     */
    public void set(double value) {
        this.value = value;
//        Logger.getLogger(getClass()).debug("Setting " + getKey() + " to " + value);
        PREFERENCES.putDouble(getKey(), value);
    }

    /**
     * Returns the current value of the preference.
     *
     * @return value of preference
     */
    public double get() {
        return value;
    }

    /**
     * If the preference does not exist ({@link Preference#exists()}), creates
     * it with the default value.
     */
    public void create() {
        if (!exists()) {
            set(defaultValue);
        }
    }
}
