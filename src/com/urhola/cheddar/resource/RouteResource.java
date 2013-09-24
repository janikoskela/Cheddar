package com.urhola.cheddar.resource;

import com.urhola.cheddar.resource.route.Leg;
import java.util.List;

/**
 *
 * @author janikoskela
 */
public class RouteResource<T> {

    private String length;
    private String duration;
    private List<Leg> legs;

    public Double getLength() {
        return Double.parseDouble(length);
    }

    public Double getDuration() {
        return Double.parseDouble(duration);
    }

    public List<Leg> getLegs() {
        return legs;
    }
}

