package com.hsl.journeyplanner.resource;

import com.hsl.journeyplanner.resource.route.Leg;
import java.util.List;

/**
* <h1>Route resource</h1>
* Routing returns the route between two coordinate points. 
* In routing it is recommended to use street addresses (their coordinates)
* as it is difficult for the end user to know where exactly a stop is located. 
* There might be several stops with the same name that are located far away 
* from each other (for example the stop “Sturenkatu” in Helsinki).
*
* @author  Koskela Jani
*/
public class RouteResource<T> implements Resource {

    /**
     * Length of the route in meters.
     */
    private String length;
    /**
     * Duration of the route in seconds.
     */
    private String duration;
    /**
     * Array of legs (part of the route) of the route.
     */
    private List<Leg> legs;

    /**
     * Gets the length of the route in meters.
     *
     * @return  length   length
     */
    public Double getLength() {
        return Double.parseDouble(length);
    }

    /**
     * Gets the duration of the route in seconds.
     *
     * @return  duration   duration
     */
    public Double getDuration() {
        return Double.parseDouble(duration);
    }

    /**
     * Gets the array of legs (part of the route) of the route.
     *
     * @return  legs   legs
     */
    public List<Leg> getLegs() {
        return legs;
    }
}

