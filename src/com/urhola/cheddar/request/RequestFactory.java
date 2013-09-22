package com.urhola.cheddar.request;

/**
 *
 * @author janikoskela
 */
public abstract class RequestFactory {
    
    public static GeoCodingRequest createGeoCodingRequest() throws IllegalArgumentException {
        return new GeoCodingRequest();
    }
    
    public static RouteRequest createRouteRequest() throws IllegalArgumentException {
        return new RouteRequest();
    }
    
    public static LineInformationRequest createLineInformationRequest() throws IllegalArgumentException {
        return new LineInformationRequest();
    }
}
