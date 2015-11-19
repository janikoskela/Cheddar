package com.hsl.journeyplanner.request;

import com.hsl.journeyplanner.annotation.Title;
import com.hsl.journeyplanner.parse.ParseFactory;
import com.hsl.journeyplanner.resource.GeocodingResource;
import com.hsl.journeyplanner.resource.common.Coordinate;
import java.io.IOException;
import java.util.List;

/**
* <h1>Reverse geocoding request</h1>
* Describes reverse geocoding parameters which are sent to Reittiopas API.
* In order to send the request to Reittiopas API, execute-method must be executed.
* Upon execution GeocodingResource is returned.
* Documentation and validation rules are from http://developer.reittiopas.fi/pages/en/http-get-interface-version-2.php#geocode
*
* @author  Koskela Jani
*/
public class ReverseGeocodingRequest extends Request {

    /**
     * Coordinate.
     */
    @Title("coordinate")
    private Coordinate coordinate;
    
    /**
     * Limit for the number of locations returned.
     */
    @Title("limit")
    private int limit;
    
    /**
     * Radius of the search in meters.
     */
    @Title("radius")
    private int radius;
    
    /**
     * Limit the search to given location types.
     */
    @Title("result_contains")
    private LocationType resultContains;
    
    private final static String ACTION_NAME = "reverse_geocode";
    
    /**
     * Location types.
     */
    public enum LocationType {
        ADDRESS("address"), STOP("stop"), POI("poi");
        
        private String locationType;
        private LocationType(String locationType) {
            this.locationType = locationType;
        }
        
        @Override
        public String toString(){
            return locationType;
        }
    }

    public ReverseGeocodingRequest(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
    
    /**
     * Executes request
     *
     * @return  a list of GeocodingResources
     * @throws java.io.IOException
     */
    @Override
    public List<GeocodingResource> execute() throws IOException {
        return super.execute();
    }
    
    @Override
    protected String getActionName() {
        return ACTION_NAME;
    }

    @Override
    protected List<GeocodingResource> parseResponse(String response) {
        return ParseFactory.parseGeocodingResponse(response);
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public LocationType getResultContains() {
        return resultContains;
    }

    public void setResultContains(LocationType resultContains) {
        this.resultContains = resultContains;
    }
}
