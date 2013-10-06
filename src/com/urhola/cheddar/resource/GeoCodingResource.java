package com.urhola.cheddar.resource;

import com.urhola.cheddar.resource.common.Coordinate;
import com.urhola.cheddar.resource.geocoding.Details;

/**
 *
 * @author janikoskela
 */
public class GeoCodingResource implements Resource {

    private String locType;
    private String locTypeId;
    private String name;
    private String matchedName;
    private String lang;
    private String city;
    private String coords;
    private Coordinate coordinates;
    private Details details;

    public Details getDetails() {
        return this.details;
    }
    
    public Coordinate getCoordinates() {
        //this is ugly, pls figure out a better way to do this
        if (this.coordinates == null) {
            String[] xy = this.coords.split(",");
            this.coordinates = new Coordinate(xy[0], xy[1]);
        }
        return this.coordinates;
    }
       
    public String getLocationType() {
        return locType;
    }

    public String getLocationTypeId() {
        return locTypeId;
    }

    public String getName() {
        return name;
    }

    public String getMatchedName() {
        return matchedName;
    }

    public String getLanguage() {
        return lang;
    }

    public String getCity() {
        return city;
    }
}
