package com.hsl.journeyplanner.resource;

import com.hsl.journeyplanner.resource.lineinformation.LineStop;
import java.io.Serializable;
import java.util.List;

/**
* <h1>Line information resource</h1>
* Detailed information on lines can be fetched with request type lines. 
* The lines can be searched with JORE codes, short codes, parts line names or transport types. 
*
* @author  Koskela Jani
*/
final public class LineInformationResource implements Serializable {

    /**
     * Unique, long code of the line, e.g. 2102T 1.
     */
    private String code;
    /**
     * Short code of the line (shown on the bus, e.g. 102T.
     */
    private String code_short;
    /**
     * Transport type of the line. 
     */
    private String transport_type_id;
    /**
     * Name of the start stop.
     */
    private String line_start;
    /**
     * Name of the end stop.
     */
    private String line_end;
    /**
     * Name of the line.
     */
    private String name;
    /**
     * URL of the timetable page for the line.
     */
    private String timetable_url;
    /**
     * The shape of the line's route as a list of coordinates.
     */
    private String line_shape; //arr
    /**
     * Array of stops the line passes.
     */
    private List<LineStop> line_stops;

    /**
     * Gets the unique, long code of the line, e.g. 2102T 1.
     *
     * @return  code   code
     */
    public String getCode() {
        return code;
    }

    /**
     * Gets the short code of the line (shown on the bus, e.g. 102T.
     *
     * @return  code_short   short code
     */
    public String getCodeShort() {
        return code_short;
    }

    /**
     * Gets the transport type of the line. 
     *
     * @return  transport_type_id   transport type id
     */
    public int getTransportTypeId() {
        return Integer.parseInt(transport_type_id);
    }
    
    /**
     * Gets the name of the start stop.
     *
     * @return  line_start   start stop name
     */
    public String getLineStart() {
        return line_start;
    }

    /**
     * Gets the name of the end stop.
     *
     * @return  line_end   end stop name
     */
    public String getLineEnd() {
        return line_end;
    }

    /**
     * Gets the name of the line.
     *
     * @return  name   name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the URL of the timetable page for the line.
     *
     * @return  timetable_url   timetable url
     */
    public String getTimetableUrl() {
        return timetable_url;
    }

    /**
     * Gets the shape of the line's route as a list of coordinates.
     *
     * @return  line_shape   shape of line
     */
    public String getLineShape() {
        return line_shape;
    }

    /**
     * Gets the array of stops the line passes.
     *
     * @return  line_stops   line stops
     */
    public List<LineStop> getLineStops() {
        return line_stops;
    }
}