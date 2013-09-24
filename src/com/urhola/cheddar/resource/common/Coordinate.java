package com.urhola.cheddar.resource.common;

/**
 *
 * @author janikoskela
 */
public class Coordinate {
    private String x;
    private String y;

    public Coordinate(String x, String y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return Double.parseDouble(x);
    }

    public double getY() {
        return Double.parseDouble(y);
    }
    
    @Override
    public String toString() {
        return this.getX() + "," + this.getY();
    }
}
