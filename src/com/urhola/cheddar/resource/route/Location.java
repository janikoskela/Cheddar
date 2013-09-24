package com.urhola.cheddar.resource.route;

import com.urhola.cheddar.resource.common.Coordinate;

/**
 *
 * @author janikoskela
 */
public class Location {

    private Coordinate coord;
    private String arrTime;
    private String depTime;
    private String name;
    private String code;
    private String shortCode;
    private String stopAddress;

    public Coordinate getCoord() {
        return coord;
    }

    public float getArrTime() {
        return Float.parseFloat(arrTime);
    }

    public float getDepTime() {
        return Float.parseFloat(depTime);
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
