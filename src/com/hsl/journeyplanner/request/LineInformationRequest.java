package com.hsl.journeyplanner.request;

import com.hsl.journeyplanner.annotation.Title;
import com.hsl.journeyplanner.parse.ParseFactory;
import com.hsl.journeyplanner.resource.LineInformationResource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
* <h1>Line information request</h1>
* Describes line parameters which are sent to Reittiopas API.
* In order to send the request to Reittiopas API, execute-method must be executed.
* Upon execution LineInformationResource is returned.
* Documentation and validation rules are from http://developer.reittiopas.fi/pages/en/http-get-interface-version-2.php#lines
*
* @author  Koskela Jani
*/
public class LineInformationRequest extends Request {
    
    /**
     * List of query strings.
     */
    @Title("query")
    private List<String> query;
    
    /**
     * List of transport type ids.
     */
    @Title("transport_type")
    private List<TransportType> transportType;
    
    private static final String ACTION_NAME = "lines";
    
    /**
     *  List of transport type ids.
    */
    public enum TransportType {
        HELSINKI_INTERNAL_BUS_LINES("1"), TRAMS("2"), ESPOO_INTERNAL_BUS_LINES("3"),
        VANTAA_INTERNAL_BUS_LINES("4"), REGIONAL_BUS_LINES("5"), METRO("6"), FERRY("7"),
        U_LINES("8"), COMMUTER_TRAINS("12"), HELSINKI_SERVICE_LINES("21"), HELSINKI_NIGHT_BUSES("22"),
        ESPOO_SERVICE_LINES("23"), VANTAA_SERVICE_LINES("24"), REGION_NIGHT_BUSES("25"),
        KIRKKONUMMI_INTERNAL_BUS_LINES("36"), KERAVA_INTERNAL_BUS_LINES("39");
        
        private String type;
        private TransportType(String type) {
            this.type = type;
        }
        
        @Override
        public String toString(){
            return type;
        }
    }
    
    /**
     * Creates the request
     *
     * @param  queries   queries may be long JORE code, short code (like one shown on the bus) or string that will be searched from the name of the line (minimum length of the search string is 4). E.g. query=2102T 1|14|Tapiola
     */
    public LineInformationRequest(List<String> queries) {
        this.query = queries;
    }
    
    /**
     * Creates the request.
     *
     * @param  query   query may be long JORE code, short code (like one shown on the bus) or string that will be searched from the name of the line (minimum length of the search string is 4). E.g. query=2102T 1|14|Tapiola
     */
    public LineInformationRequest(String query) {
        List<String> queries = new ArrayList<>();
        queries.add(query);
        this.query = queries;
    }
    
    /**
     * Limits request with transport types.
     * If not set all transport types are valid
     *
     * @param  transportTypes   list of transport types
     */
    public void setTransportTypes(List<TransportType> transportTypes) {
        this.transportType = transportTypes;
    }
    
    /**
     * Sets a query.
     *
     * @param  query   query may be long JORE code, short code (like one shown on the bus) or string that will be searched from the name of the line (minimum length of the search string is 4). E.g. query=2102T 1|14|Tapiola
     */
    public void setQuery(String query) {
        List<String> queries = new ArrayList<>();
        queries.add(query);
        this.query = queries;
    }

    /**
     * Sets a list of queries
     *
     * @param  queries   queries may be long JORE code, short code (like one shown on the bus) or string that will be searched from the name of the line (minimum length of the search string is 4). E.g. query=2102T 1|14|Tapiola
     */
    public void setQuery(List<String> queries) {
        this.query = queries;
    }

    /**
     * Gets a list of queries
     *
     * @return  queries   queries may be long JORE code, short code (like one shown on the bus) or string that will be searched from the name of the line (minimum length of the search string is 4). E.g. query=2102T 1|14|Tapiola
     */
    public List<String> getQuery() {
        return query;
    }

    /**
     * Gets transport types
     *
     * @return  transportTypes   list of transport types
     */
    public List<TransportType> getTransportType() {
        return transportType;
    }

    /**
     * Executes request
     *
     * @return  a list of LineInformationResource
     * @throws java.io.IOException
     */
    @Override
    public List<LineInformationResource> execute() throws IOException {
        return super.execute();
    }
        
    @Override
    protected String getActionName() {
        return ACTION_NAME;
    }

    @Override
    protected List<LineInformationResource> parseResponse(String response) {
        return ParseFactory.parseLineInformationResponse(response);
    }
}
