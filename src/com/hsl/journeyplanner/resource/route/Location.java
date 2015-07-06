package com.hsl.journeyplanner.resource.route;

import com.hsl.journeyplanner.resource.common.Coordinate;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author  Koskela Jani
 */
final public class Location implements Serializable{

    /**
     * Coordinate of the location.
     */
    private Coordinate coord;
    
    /**
     * Arrival time to the location, format yyyyMMddHHmm.
     */
    private String arrTime;
    
    /**
     * Departure time from the location, format yyyyMMddHHmm.
     */
    private String depTime;
    
    /**
     * Name of the location.
     */
    private String name;
    
    /**
     * Long code of the stop.
     */
    private String code;
    
    /**
     * Short code of the stop.
     */
    private String shortCode;
    
    /**
     * Address of the stop.
     */
    private String stopAddress;

    public Coordinate getCoord() {
        return coord;
    }
    
    /**
     * Gets the arrival time to the location.
     *
     * @return  arrTime   arrival time
     */
    public Date getArrTime() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm", Locale.ENGLISH);
        try {
            cal.setTime(sdf.parse(arrTime));
        } catch (ParseException e) {
            return null;
        }
        return cal.getTime();
    }

    /**
     * Gets the departure time to the location, format yyyyMMddHHmm.
     *
     * @return  depTime   departure time
     */
    public Date getDepTime() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm", Locale.ENGLISH);
        try {
            cal.setTime(sdf.parse(depTime));
        } catch (ParseException e) {
            return null;
        }
        return cal.getTime();
    }

    /**
     * Gets the name of the location
     *
     * @return  name   location name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the long code of the location
     *
     * @return  code   location code
     */
    public String getCode() {
        return code;
    }

    /**
     * Gets the short code of the location
     *
     * @return  shortCode   location code
     */
    public String getShortCode() {
        return shortCode;
    }

    /**
     * Gets the address of the stop
     *
     * @return  stopAddress   stop address
     */
    public String getStopAddress() {
        return stopAddress;
    }
}
