package com.hsl.journeyplanner.resource.route;

import java.util.List;

/**
* <h1>Leg of a route</h1>
* Part of the route
*
* @author  Koskela Jani
*/
public class Leg {
    /**
     * Length of the leg in meters.
     */
    private String length;
    /**
     * Duration of the leg in seconds.
     */
    private String duration;
    /**
     * Type of the leg: walk or transport type id.
     */
    private String type;
    /**
     * Line code.
     */
    private String code;
    /**
     * Aarray of locations on the leg (limited detail only lists start and end locations).
     */
    private List<Location> locs;
    
    /**
     * Gets the length of the leg in meters.
     *
     * @return  length   leg length
     */
    public double getLength() {
        return Double.parseDouble(length);
    }

    /**
     * Gets the duration of the leg in seconds.
     *
     * @return  duration   leg duration
     */
    public double getDuration() {
        return Double.parseDouble(duration);
    }

    /**
     * Gets the type of the leg: walk or transport type id
     *
     * @return  type   leg type
     */
    public String getType() {
        return type;
    }

    /**
     * Gets the line code.
     *
     * @return  code   leg code
     */
    public String getCode() {
        return code;
    }

    /**
     * Gets the array of locations on the leg (limited detail only lists start and end locations).
     *
     * @return  locs   locations
     */
    public List<Location> getLocs() {
        return locs;
    }
}