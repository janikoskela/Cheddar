package com.urhola.cheddar.resource;

import com.urhola.cheddar.resource.lineinformation.LineStop;
import java.util.List;

/**
 *
 * @author janikoskela
 */
public class LineInformationResource {

    private String code;
    private String code_short;
    private int transport_type_id;
    private String line_start;
    private String line_end;
    private String name;
    private String timetable_url;
    private List<String> line_shape;
    private List<LineStop> line_stops;

    public String getCode() {
        return code;
    }

    public String getCode_short() {
        return code_short;
    }

    public int getTransport_type_id() {
        return transport_type_id;
    }

    public String getLine_start() {
        return line_start;
    }

    public String getLine_end() {
        return line_end;
    }

    public String getName() {
        return name;
    }

    public String getTimetable_url() {
        return timetable_url;
    }

    public List<String> getLine_shape() {
        return line_shape;
    }

    public List<LineStop> getLine_stops() {
        return line_stops;
    }
}