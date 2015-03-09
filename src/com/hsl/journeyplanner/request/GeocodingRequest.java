package com.hsl.journeyplanner.request;

import com.hsl.journeyplanner.annotation.AllowedStrings;
import com.hsl.journeyplanner.annotation.Title;
import com.hsl.journeyplanner.parse.ParseFactory;
import com.hsl.journeyplanner.resource.GeocodingResource;
import java.io.IOException;
import java.util.List;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotNull;
import net.sf.oval.constraint.Range;

/**
* <h1>Geocoding request</h1>
* Describes geocoding parameters which are sent to Reittiopas API.
* In order to send the request to Reittiopas API, execute-method must be executed.
* Upon execution GeocodingResource is returned.
* Documentation and validation rules are from http://developer.reittiopas.fi/pages/en/http-get-interface-version-2.php#geocode
*
* @author  Koskela Jani
*/
public class GeocodingRequest extends Request {

    /**
     * Search term.
     */
    @NotNull
    @Length(min=3)
    @Title("key")
    private String searchTerm;
    
    /**
     * List of city names.
     */
    @Title("cities")
    private List<City> cities;
    
    /**
     * Location types.
     */
    @Title("loc_types")
    private List<LocationType> locTypes;
    
    /**
     * Disable levenshtein error correction.
     */
    @Range(min=0, max=1)
    @Title("disable_error_correction")
    private int disableErrorCorrection;
    
    /**
     * Disable unique stop names in the result.
     */
    @Range(min=0, max=1)
    @Title("disable_unique_stop_names")
    private int disableUniqueStopNames;
    
    private final static String ACTION_NAME = "geocode";
    
    /**
     * City names.
     */
    public enum City {
        HELSINKI("helsinki"), ESPOO("espoo"), KAUNIAINEN("kauniainen"), 
        VANTAA("vantaa"), KERAVA("kerava"), KIRKKONUMMI("kirkkonummi"), SIPOO("sipoo");
        
        private String city;
        private City(String city) {
            this.city = city;
        }
        
        @Override
        public String toString(){
            return city;
        }
    }
    
    /**
     * Location types.
     */
    public enum LocationType {
        STOP("stop"), ADDRESS("address");
        
        private String type;
        private LocationType(String type) {
            this.type = type;
        }
        
        @Override
        public String toString(){
            return type;
        }
    }

    public GeocodingRequest(String searchTerm) {
        this.searchTerm = searchTerm;
    }
    
    public GeocodingRequest(String searchTerm, boolean useClientValidation) {
        this.searchTerm = searchTerm;
        this.useClientValidation = useClientValidation;
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

    /**
     * Sets the search term.
     *
     * @param  searchTerm   search term. Min length is 3 characters
     */
    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    /**
     * Limits the cities.
     * If not set all cities are valid
     *
     * @param  cities   list of cities. Allowed values are "helsinki", "espoo", "kauniainen", "kerava", "sipoo", "kirkkonummi" and "vantaa"
     */
    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    /**
     * Limits the location types.
     * If not set all location types are valid
     *
     * @param  locTypes   list of location types. Allowed values are "stop" and "address"
     */
    public void setLocTypes(List<LocationType> locTypes) {
        this.locTypes = locTypes;
    }

    /**
     * Sets if levenshtein error correction is used or not.
     * By default error correction is in use
     *
     * @param  disableErrorCorrection   if true error correction is not in use, if false error correction is in use
     */
    public void setDisableErrorCorrection(boolean disableErrorCorrection) {
        this.disableErrorCorrection = (disableErrorCorrection) ? 1 : 0;
    }

    /**
     * Sets if unique stop names are included in the result.
     * By default all stop names are included
     *
     * @param  disableUniqueStopNames   if true all stops are shown in the result, if false only one stop is included in the result for stops with same name
     */
    public void setDisableUniqueStopNames(boolean disableUniqueStopNames) {
        this.disableUniqueStopNames = (disableUniqueStopNames) ? 1 : 0;
    }
    
    @Override
    protected String getActionName() {
        return ACTION_NAME;
    }

    @Override
    protected List<GeocodingResource> parseResponse(String response) {
        return ParseFactory.parseGeocodingResponse(response);
    }
}
