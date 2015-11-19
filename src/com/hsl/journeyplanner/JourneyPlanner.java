package com.hsl.journeyplanner;

import com.hsl.journeyplanner.Settings.CoordinateSystem;
import com.hsl.journeyplanner.request.GeocodingRequest;
import com.hsl.journeyplanner.request.LineInformationRequest;
import com.hsl.journeyplanner.request.RequestFactory;
import com.hsl.journeyplanner.request.ReverseGeocodingRequest;
import com.hsl.journeyplanner.request.RouteRequest;
import com.hsl.journeyplanner.resource.common.Coordinate;
import java.util.List;

/**
* <h1>HSL JourneyPlanner</h1>
* Simple java client library for the use of HSL's (Helsinki Regional Transport Authority) Journey planner interface (v2). 
* Creates requests, validates them and finally sends them to HSL's API. 
* After sending maps the response into classes which are then easy to use. 
* 
* Most of the documentation is from http://developer.reittiopas.fi/pages/en/http-get-interface-version-2.php
*
* @author  Koskela Jani
*/
final public class JourneyPlanner {
    
    /**
     * Creates and returns a GeoCodingRequest. 
     * 
     * @param  key  Search term
     *
     * @return      GeoCodingRequest which upon being executed returns the coordinates and the names of the POIs, stops and addresses
     * @throws      IllegalArgumentException when given parameters are invalid
     */
    public static GeocodingRequest createGeocodingRequest(String key) throws IllegalArgumentException {
        return RequestFactory.createGeoCodingRequest(key);
    }
    
    /**
     * Creates and returns a reverse GeoCodingRequest. 
     * 
     * @param  coordinate  Coordinate
     *
     * @return      ReverseGeoCodingRequest which upon being executed returns the coordinates and the names of the POIs, stops and addresses
     * @throws      IllegalArgumentException when given parameters are invalid
     */
    public static ReverseGeocodingRequest createReverseGeocodingRequest(Coordinate coordinate) throws IllegalArgumentException {
        return RequestFactory.createReverseGeoCodingRequest(coordinate);
    }
    
    /**
     * Creates a RouteRequest. 
     * In routing it is recommended to use street addresses (their coordinates) as it is difficult for the end user to know where exactly a stop is located.
     * There might be several stops with the same name that are located far away from each other (for example the stop “Sturenkatu” in Helsinki).
     *
     * @param  to   Coordinates
     * @param  from Coordinates
     * @return      RouteRequest which upon being executed returns the route between two coordinate points
     * @throws      IllegalArgumentException when given parameters are invalid
     */
    public static RouteRequest createRouteRequest(Coordinate to, Coordinate from) throws IllegalArgumentException {
        return RequestFactory.createRouteRequest(to, from);
    }
    
    /**
     * Creates a LineInformationRequest. 
     * The lines can be searched with JORE codes, short codes, parts line names or transport types. 
     *
     * @param  queries   List of queries
     * @return      LineInformationRequest which upon being executed returns detailed information on lines can be fetched with request type lines
     * @throws      IllegalArgumentException when given parameters are invalid
     */
    public static LineInformationRequest createLineInformationRequest(List<String> queries) throws IllegalArgumentException {
        return RequestFactory.createLineInformationRequest(queries);
    }
    
    /**
     * Creates a LineInformationRequest. 
     * The lines can be searched with JORE codes, short codes, parts line names or transport types. 
     *
     * @param  query   query
     * @return      LineInformationRequest which upon being executed returns detailed information on lines can be fetched with request type lines
     * @throws      IllegalArgumentException when given parameters are invalid
     */
    public static LineInformationRequest createLineInformationRequest(String query) throws IllegalArgumentException {
        return RequestFactory.createLineInformationRequest(query);
    }
    
    /**
     * Sets Reittiopas API username to be included into requests
     *
     * @param  username   username
     */
    public static void setApiUsername(String username) {
        Credential.setApiUsernmae(username);
    }

    /**
     * Sets Reittiopas API password to be included into requests 
     *
     * @param  password   password
     */
    public static void setApiPassword(String password) {
        Credential.setApiPassword(password);
    }
    
    public static void setInCoordinateSystem(CoordinateSystem coordinateSystem) {
        Settings.setInCoordinateSystem(coordinateSystem);
    }
    
    public static void setOutCoordinateSystem(CoordinateSystem coordinateSystem) {
        Settings.setOutCoordinateSystem(coordinateSystem);
    }
}
