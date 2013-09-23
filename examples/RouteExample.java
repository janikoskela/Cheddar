package hsl.library.tester;

import com.urhola.cheddar.Cheddar;
import com.urhola.cheddar.request.GeoCodingRequest;
import com.urhola.cheddar.request.RouteRequest;
import com.urhola.cheddar.resource.common.Coordinate;
import com.urhola.cheddar.resource.route.Leg;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author janikoskela
 */
public class HslLibraryTester {

    private final static String API_USERNAME = "foo";
    private final static String API_PASSWORD = "bar";
    
    /*
     * Just a simple example how to make a route request. Spits out the legs of the route.
     */
    public static void main(String[] args) throws IOException {
        Cheddar.setApiUsername(API_USERNAME);
        Cheddar.setApiPassword(API_PASSWORD);
        
        GeoCodingRequest fromRequest = Cheddar.createGeoCodingRequest();
        fromRequest.setLocationName("mannerheimintie");
        Coordinate from = fromRequest.execute().get(0).getCoordinates();
        
        GeoCodingRequest toRequest = Cheddar.createGeoCodingRequest();
        toRequest.setLocationName("upseerinkatu");
        Coordinate to = toRequest.execute().get(0).getCoordinates();
        
        RouteRequest req = Cheddar.createRouteRequest();
        req.setFrom(from);
        req.setTo(to);
        List<Leg> legs = req.execute().get(0).getLegs();
        
        for (Leg leg : legs)
            System.out.println(leg.getType());
    }
}
