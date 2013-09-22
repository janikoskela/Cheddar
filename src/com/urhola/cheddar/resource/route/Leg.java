package com.urhola.cheddar.resource.route;

import java.util.List;

/**
 *
 * @author janikoskela
 */
public class Leg<T> {
    private double length;
    private double duration;
    private String type;
    private String code;
    private List<Location> locs;
    
    public double getLength() {
        return length;
    }

    public double getDuration() {
        return duration;
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