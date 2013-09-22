package com.urhola.cheddar.resource.route;

import com.urhola.cheddar.resource.common.Coordinate;

/**
 *
 * @author janikoskela
 */
public class Location {

    private Coordinate coord;
    private float arrTime;
    private float depTime;
    private String name;
    private String code;
    private String shortCode;
    private String stopAddress;

    public Coordinate getCoord() {
        return coord;
    }

    public float getArrTime() {
        return arrTime;
    }

    public float getDepTime() {
        return depTime;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getShortCode() {
        return shortCode;
    }

    public String getStopAddress() {
        return stopAddress;
    }
}
