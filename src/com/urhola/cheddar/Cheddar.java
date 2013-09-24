package com.urhola.cheddar;

import com.urhola.cheddar.request.GeoCodingRequest;
import com.urhola.cheddar.request.LineInformationRequest;
import com.urhola.cheddar.request.RequestFactory;
import com.urhola.cheddar.request.RouteRequest;

/**
 *
 * @author janikoskela
 */
final public class Cheddar {
    
    private static String apiUsername;
    private static String apiPassword;
    
    public static GeoCodingRequest createGeoCodingRequest() throws IllegalArgumentException {
        return RequestFactory.createGeoCodingRequest();
    }
    
    public static RouteRequest createRouteRequest() throws IllegalArgumentException {
        return RequestFactory.createRouteRequest();
    }
    
    public static LineInformationRequest createLineInformationRequest() throws IllegalArgumentException {
        return RequestFactory.createLineInformationRequest();
    }
    
    public static void setApiUsername(String username) {
        Credential.setApiUsernmae(apiUsername);
    }

    public static void setApiPassword(String password) {
        Credential.setApiPassword(apiPassword);
    }
}
