package com.hsl.journeyplanner.util;

import java.util.List;

/**
 *
 * @author  Koskela Jani
 */
public abstract class Utils {
    
    /**
     * Transforms a list to a string which is passed to HSL API
     * 
     * @param list
     * @return 
     */
    public static String convertListToString(List<?> list) {
        String output = null;
        try {
        for (int i = 0; i < list.size(); i++) {
            if (i == 0)
                output = list.get(i).toString();
            else
                output += "|" + list.get(i).toString();
        }
        return output;
        } catch (NullPointerException e) {
            return null;
        }
    }
}
