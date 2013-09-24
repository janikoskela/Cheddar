package com.urhola.cheddar.resource.route;

import java.util.List;

/**
 *
 * @author janikoskela
 */
public class Leg {
    private String length;
    private String duration;
    private String type;
    private String code;
    private List<Location> locs;
    
    public double getLength() {
        return Double.parseDouble(length);
    }

    public double getDuration() {
        return Double.parseDouble(duration);
    }

    public String getType() {
        return type;
    }

    public String getCode() {
        return code;
    }

    public List<Location> getLocs() {
        return locs;
    }
}