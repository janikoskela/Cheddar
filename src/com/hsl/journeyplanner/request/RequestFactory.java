package com.hsl.journeyplanner.request;

import com.hsl.journeyplanner.resource.common.Coordinate;
import java.util.List;

/**
 *
 * @author  Koskela Jani
 */
public abstract class RequestFactory {
    
    public static GeocodingRequest createGeoCodingRequest(String key) throws IllegalArgumentException {
        return new GeocodingRequest(key);
    }
    
    public static RouteRequest createRouteRequest(Coordinate to, Coordinate from) throws IllegalArgumentException {
        return new RouteRequest(to, from);
    }
    
    public static LineInformationRequest createLineInformationRequest(List<String> queries) throws IllegalArgumentException {
        return new LineInformationRequest(queries);
    }
    
    public static LineInformationRequest createLineInformationRequest(String query) throws IllegalArgumentException {
        return new LineInformationRequest(query);
    }
}
