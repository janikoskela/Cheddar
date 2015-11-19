package com.hsl.journeyplanner.parse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hsl.journeyplanner.resource.GeocodingResource;
import com.hsl.journeyplanner.resource.LineInformationResource;
import com.hsl.journeyplanner.resource.RouteResource;
import com.hsl.journeyplanner.resource.route.Leg;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author  Koskela Jani
 */
public class ParseFactory {
    public static List<GeocodingResource> parseGeocodingResponse(String response) {
        Type listType = new TypeToken<List<GeocodingResource>>(){}.getType();
        return parse(response, listType);
    }
    
    public static List<RouteResource<List<Leg>>> parseRouteResponse(String response) {
        Type listType = new TypeToken<List<List<RouteResource<List<Leg>>>>>(){}.getType();
        List<List<RouteResource<List<Leg>>>> res = parse(response, listType);
        List<RouteResource<List<Leg>>> result = new ArrayList<>();
        try {
            for (List<RouteResource<List<Leg>>> resChild : res) {
                result.add(resChild.get(0));
            } 
        } catch (Exception e) {}
        return result;
    }
    
    public static List<LineInformationResource> parseLineInformationResponse(String response) {
        Type listType = new TypeToken<List<LineInformationResource>>(){}.getType();
        return parse(response, listType);
    }
    
    private static <T>List <T> parse(String response, Type listType) {
        return new Gson().fromJson(response, listType);    
    }
}
