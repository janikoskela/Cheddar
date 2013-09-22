package com.urhola.cheddar.request;

import com.urhola.cheddar.annotation.AllowedValues;
import com.urhola.cheddar.annotation.Title;
import com.urhola.cheddar.parse.ParseFactory;
import com.urhola.cheddar.resource.GeoCodingResource;
import com.urhola.cheddar.resource.geocoding.Details;
import java.io.IOException;
import java.util.List;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotNull;
import net.sf.oval.constraint.Range;



/**
 *
 * @author janikoskela
 */
public class GeoCodingRequest extends Request {

    @NotNull
    @Length(min=3)
    @Title("key")
    private String key;
    
    @Title("cities")
    @AllowedValues({"helsinki", "espoo", "kauniainen", "kerava", "sipoo", "kirkkonummi", "vantaa"})
    private List<String> cities;
    
    
    @Title("loc_types")
    @AllowedValues({"stop", "address"})
    private List<String> locTypes;
    
    @Range(min=0, max=1)
    @Title("disable_error_correction")
    private String disableErrorCorrection;
    
    @Range(min=0, max=1)
    @Title("disable_unique_stop_names")
    private String disableUniqueStopNames;
    
    private final static String ACTION_NAME = "geocode";
    
    @Override
    public List<GeoCodingResource> execute() throws IOException {
        return super.execute();
    }

    public void setLocationName(String locationName) {
        this.key = locationName;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public void setLocTypes(List<String> locTypes) {
        this.locTypes = locTypes;
    }

    public void setDisableErrorCorrection(String disableErrorCorrection) {
        this.disableErrorCorrection = disableErrorCorrection;
    }

    public void setDisableUniqueStopNames(String disableUniqueStopNames) {
        this.disableUniqueStopNames = disableUniqueStopNames;
    }
    
    @Override
    protected String getActionName() {
        return ACTION_NAME;
    }

    @Override
    protected List<GeoCodingResource> parseResponse(String response) {
        return ParseFactory.parseGeoCodingResponse(response);
    }
}
