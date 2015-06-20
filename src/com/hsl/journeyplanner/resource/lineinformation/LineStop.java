package com.hsl.journeyplanner.resource.lineinformation;

import java.io.Serializable;

/**
* <h1>Line stop resource</h1>
* Describes stops through which the line passes
* 
* @author  Koskela Jani
*/
final public class LineStop implements Serializable{
    
    /**
     * An address of the stop
     */
    private String address;

    /**
     * Gets the address
     *
     * @return  address  stop address
     */
    public String getAddress() {
        return address;
    }
}
