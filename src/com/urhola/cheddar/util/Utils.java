package com.urhola.cheddar.util;

import java.util.List;

/**
 *
 * @author janikoskela
 */
public abstract class Utils {
    
    /**
     * Transforms a list to a string which is passed to HSL API
     * 
     * @param list
     * @return 
     */
    public static String convertListToString(List<String> list) {
        String output = null;
        try {
        for (int i = 0; i < list.size(); i++) {
            if (i == 0)
                output = list.get(i);
            else
                output += "|" + list.get(i);
        }
        return output;
        } catch (NullPointerException e) {
            return null;
        }
    }
}
