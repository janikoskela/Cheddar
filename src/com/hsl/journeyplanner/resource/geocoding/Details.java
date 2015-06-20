package com.hsl.journeyplanner.resource.geocoding;

import java.io.Serializable;

/**
* <h1>Details about a location</h1>
* Detailed information about the location such as houseNumber for addresses, 
* poiClass for POIs and codes for stops.
* 
* @author  Koskela Jani
*/
final public class Details implements Serializable{
    /**
     * House number.
    */
    private String houseNumber;
    
    /**
     * POI class
    */
    private String poiClass;
    
    /**
     * stop codes.
    */
    private String codes;

    /**
     * Gets house number.
     *
     * @return  houseNumber   house number
     */
    public String getHouseNumber() {
        return houseNumber;
    }

    /**
     * Gets POI class.
     *
     * @return  poiClass   POI class
     */
    public String getPoiClass() {
        return poiClass;
    }

    /**
     * Gets stop codes.
     *
     * @return  codes   stop codes
     */
    public String getCodes() {
        return codes;
    }
}
