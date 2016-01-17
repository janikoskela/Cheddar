package com.hsl.journeyplanner.resource.route;

import com.hsl.journeyplanner.resource.common.Coordinate;
import java.io.Serializable;
import java.util.List;

/**
* <h1>Leg of a route</h1>
* Part of the route
*
* @author  Koskela Jani
*/
final public class Leg implements Serializable {
    public static final String ID_TRANSPORT_TYPE_HELSINKI_INTERNAL_BUS = "1";
    public static final String ID_TRANSPORT_TYPE_TRAM = "2";
    public static final String ID_TRANSPORT_TYPE_ESPOO_INTERNAL_BUS = "3";
    public static final String ID_TRANSPORT_TYPE_VANTAA_INTERNAL_BUS = "4";
    public static final String ID_TRANSPORT_TYPE_REGIONAL_BUS = "5";
    public static final String ID_TRANSPORT_TYPE_METRO = "6";
    public static final String ID_TRANSPORT_TYPE_FERRY = "7";
    public static final String ID_TRANSPORT_TYPE_U_LINES = "8";
    public static final String ID_TRANSPORT_TYPE_TRAIN = "12";
    public static final String ID_TRANSPORT_TYPE_HELSINKI_SERVICE_LINES = "21";
    public static final String ID_TRANSPORT_TYPE_HELSINKI_NIGHT_BUSES = "22";
    public static final String ID_TRANSPORT_TYPE_ESPOO_SERVICE_LINES = "23";
    public static final String ID_TRANSPORT_TYPE_VANTAA_SERVICE_LINES = "24";
    public static final String ID_TRANSPORT_TYPE_REGION_NIGHT_BUSES = "25";
    public static final String ID_TRANSPORT_TYPE_KIRKKONUMMI_INTERNAL_BUS_LINES = "36";
    public static final String ID_TRANSPORT_TYPE_KERAVA_INTERNAL_BUS_LINES = "39";
    public static final String ID_TRANSPORT_TYPE_WALK = "walk";
    
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
     * Shape (list of coordinates) of the leg (only in full detail).
     */
    private List<Coordinate> shape;
    
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

    /**
     * Gets the list of coordinates of the leg.
     *
     * @return  shape   shapes
     */
    public List<Coordinate> getShape() {
        return shape;
    }
}