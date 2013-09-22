package com.urhola.cheddar.request;

import com.urhola.cheddar.annotation.Title;
import com.urhola.cheddar.parse.ParseFactory;
import com.urhola.cheddar.resource.LineInformationResource;
import java.util.List;
import net.sf.oval.constraint.NotNull;


/**
 *
 * @author janikoskela
 */
public class LineInformationRequest extends Request {
    
    @Title("query")
    @NotNull
    private List<String> query;
    
    @Title("transport_type")
    private List<String> transportType;
    
    private static final String ACTION_NAME = "lines";

    public void setQuery(List<String> query) {
        this.query = query;
    }

    public void setTransportType(List<String> transportType) {
        this.transportType = transportType;
    }

    @Override
    public List<LineInformationResource> execute() {
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
