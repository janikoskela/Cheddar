package com.urhola.cheddar.parse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.urhola.cheddar.resource.GeoCodingResource;
import com.urhola.cheddar.resource.LineInformationResource;
import com.urhola.cheddar.resource.RouteResource;
import java.lang.reflect.Type;
import java.util.List;

/**
 *
 * @author janikoskela
 */
public class ParseFactory {
    public static List<GeoCodingResource> parseGeoCodingResponse(String response) {
        Type listType = new TypeToken<List<GeoCodingResource>>(){}.getType();
        return parse(response, listType);
    }
    
    public static List<RouteResource> parseRouteResponse(String response) {
        Type listType = new TypeToken<List<List<RouteResource>>>(){}.getType();
        return (List<RouteResource>) parse(response, listType).get(0);
    }
    
    public static List<LineInformationResource> parseLineInformationResponse(String response) {
        Type listType = new TypeToken<List<LineInformationResource>>(){}.getType();
        return parse(response, listType);
    }
    
    private static <T>List <T> parse(String response, Type listType) {
        return new Gson().fromJson(response, listType);    
    }
}
