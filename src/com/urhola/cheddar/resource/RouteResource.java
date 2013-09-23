package com.urhola.cheddar.resource;

import com.urhola.cheddar.resource.route.Leg;
import com.urhola.cheddar.resource.route.Location;
import java.util.List;

/**
 *
 * @author janikoskela
 */
public class RouteResource<T> {

    private double length;
    private double duration;
    private List<Leg> legs;

    public double getLength() {
        return length;
    }

    public double getDuration() {
        return duration;
    }

    public List<Leg> getLegs() {
        return legs;
    }
}

