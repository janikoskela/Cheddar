package com.hsl.journeyplanner.resource;

import com.hsl.journeyplanner.resource.common.Coordinate;
import com.hsl.journeyplanner.resource.geocoding.Details;
import java.io.Serializable;
import java.util.Objects;

/**
* <h1>Geocoding resource</h1>
* Geocoding returns the coordinates and the names of the POIs, stops and addresses. 
* Locations have been classified to different categories.
*
* @author  Koskela Jani
*/
final public class GeocodingResource implements Serializable {

    /**
     * Type of the location: street, address, poi (point of interest) or stop.
     */
    private String locType;
    /**
     * Location type id of the location (1-9 and 1008 = poi, 10 = stop, 900 = address).
     */
    private String locTypeId;
    /**
     * Name of the location.
     */
    private String name;
    /**
     * Name of the location in that was matched with the search key.
     */
    private String matchedName;
    /**
     * Language of the matched name of the location.
     */
    private String lang;
    /**
     * Name of the city the location is in.
     */
    private String city;
    /**
     * Coordinates of the location (<x,y>, e.g. 2551217,6681725).
     */
    private String coords;
    /**
     * Wrapped coordinates of the location.
     */
    private Coordinate coordinates;
    /**
     * Detailed information about the location such as houseNumber for addresses, poiClass for POIs and codes for stops.
     */
    private Details details;

    /**
     * Gets Detailed information about the location such as houseNumber for addresses, poiClass for POIs and codes for stops.
     *
     * @return  details   details
     */
    public Details getDetails() {
        return this.details;
    }
    
    /**
     * Gets wrapped coordinates of the location.
     *
     * @return  coordinates   coordinates
     */
    public Coordinate getCoordinates() {
        //this is ugly, pls figure out a better way to do this
        if (this.coordinates == null) {
            String[] xy = this.coords.split(",");
            this.coordinates = new Coordinate(xy[0], xy[1]);
        }
        return this.coordinates;
    }
       
    /**
     * Gets the type of the location: street, address, poi (point of interest) or stop
     *
     * @return  locType   location type
     */
    public String getLocationType() {
        return locType;
    }

    /**
     * Gets the location type id of the location (1-9 and 1008 = poi, 10 = stop, 900 = address).
     *
     * @return  locTypeId   location type id
     */
    public String getLocationTypeId() {
        return locTypeId;
    }

    /**
     * Gets the name of the location.
     *
     * @return  name   location name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the name of the location in that was matched with the search key.
     *
     * @return  matchedName   matched name
     */
    public String getMatchedName() {
        return matchedName;
    }

    /**
     * Gets the language of the matched name of the location.
     *
     * @return  lang   language
     */
    public String getLanguage() {
        return lang;
    }

    /**
     * Gets the name of the city the location is in.
     *
     * @return  city   city
     */
    public String getCity() {
        return city;
    }

    public void setLocType(String locType) {
        this.locType = locType;
    }

    public void setLocTypeId(String locTypeId) {
        this.locTypeId = locTypeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMatchedName(String matchedName) {
        this.matchedName = matchedName;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCoords(String coords) {
        this.coords = coords;
    }

    public void setCoordinates(Coordinate coordinates) {
        this.coordinates = coordinates;
    }

    public void setDetails(Details details) {
        this.details = details;
    }
    
    @Override
    public boolean equals(Object obj) {
        try {
            if(this == obj)
                return true;
            if((obj == null) || (obj.getClass() != this.getClass()))
                return false;
            GeocodingResource res = (GeocodingResource) obj;
            Coordinate resCoordinate = res.getCoordinates();
            Coordinate c = this.getCoordinates();
            if (c != null && resCoordinate != null) {
                if (res.coordinates.getX() == this.coordinates.getX() && res.getName().equals(this.getName()) && res.coordinates.getY() == this.coordinates.getY())
                    return true;
            }
            else {
                if (res.getName().equals(this.getName()))
                    return true;
            }
        } catch (Exception e) {}
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 + hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 47 + hash + (this.coords != null ? this.coords.hashCode() : 0);
        return hash;
    }
}
