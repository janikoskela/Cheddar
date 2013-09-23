package com.urhola.cheddar.resource.common;

/**
 *
 * @author janikoskela
 */
public class Coordinate {
    private double x;
    private double y;

    public Coordinate(String x, String y) {
        this.x = Integer.valueOf(x);
        this.y = Integer.valueOf(y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
    @Override
    public String toString() {
        return this.getX() + "," + this.getY();
    }
}
