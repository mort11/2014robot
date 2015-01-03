package org.mort11.util;

import com.sun.squawk.util.Arrays;

/**
 *
 * @author Will
 */
public class InterpolatedLookupTable
{

    private final float[] keys, values;

    public InterpolatedLookupTable(int size)
    {
        keys = new float[size];
        values = new float[size];
        //nasty hack to make the table fill correctly
        Arrays.fill(keys, Float.MAX_VALUE);
        Arrays.fill(values, Float.MAX_VALUE);
    }

    //requires pairs to be inputted in order. FIXME
    public void put(float key, float value)
    {
        int index = Arrays.binarySearch(keys, key);
        //Shift arrays, insert values, discarding the last element of the arrays
        index = -(index + 1);
        System.
                arraycopy(keys, index, keys, index + 1, keys.length
                - (index + 1));
        System.arraycopy(values, index, values, index + 1, values.length
                - (index + 1));
        keys[index] = key;
        values[index] = value;
    }

    /**
     *
     * @return the value associated with key, or an approximation based on
     * linear interpolation
     */
    public float get(float key)
    {
        int index = Arrays.binarySearch(keys, key);
        if (index < 0) { //Interpolate
            index = -(index + 1);
            return values[index]
                    + (values[index + 1] + values[index])
                    * (key - keys[index]) / keys[index];
        }
        return values[index]; //Got a hit
    }
}
