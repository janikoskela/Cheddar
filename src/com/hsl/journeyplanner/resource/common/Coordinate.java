package com.hsl.journeyplanner.resource.common;

import java.io.Serializable;

/**
* <h1>Coordinate resource</h1>
* Describes a coordinate
* 
* @author  Koskela Jani
*/
final public class Coordinate implements Serializable {
    /**
     * X-coordinate.
     */
    private String x;
    /**
     * Y-coordinate.
     */
    private String y;

    /**
     * Creates a coordinate
     * @param x
     * @param y
     */
    public Coordinate(String x, String y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the x-coordinate.
     *
     * @return  x   x-coordinate
     */
    public double getX() {
        return Double.parseDouble(x);
    }

    /**
     * Gets the y-coordinate.
     *
     * @return  y   y-coordinate
     */
    public double getY() {
        return Double.parseDouble(y);
    }
    
    @Override
    public String toString() {
        return this.getX() + "," + this.getY();
    }
}
