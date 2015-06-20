package com.hsl.journeyplanner.request;

import com.hsl.journeyplanner.annotation.AllowedStrings;
import com.hsl.journeyplanner.annotation.Title;
import com.hsl.journeyplanner.parse.ParseFactory;
import com.hsl.journeyplanner.resource.RouteResource;
import com.hsl.journeyplanner.resource.common.Coordinate;
import com.hsl.journeyplanner.resource.route.Leg;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import net.sf.oval.constraint.NotNull;
import net.sf.oval.constraint.Range;

/**
* <h1>Route request</h1>
* Describes route request which is sent to Reittiopas API.
* Routing returns the route between two coordinate points. 
* In routing it is recommended to use street addresses (their coordinates) as it 
* is difficult for the end user to know where exactly a stop is located. 
* There might be several stops with the same name that are located far away 
* from each other (for example the stop “Sturenkatu” in Helsinki).
* Documentation and validation rules are from http://developer.reittiopas.fi/pages/en/http-get-interface-version-2.php#route
* 
* In order to send the request to Reittiopas API, execute-method must be executed.
* 
* @author  Koskela Jani
*/
public class RouteRequest extends Request {
    
    private static final String ACTION_NAME = "route";
    
    /**
     * Starting coordinates.
     */
    @NotNull
    @Title("from")
    private Coordinate from;
    
    /**
     * Coordinates where route must go by.
     */
    @Title("via")
    private Coordinate via;
    
    /**
     * Ending coordinates.
     */
    @NotNull
    @Title("to")
    private Coordinate to;
    
    /**
     * Date of departure or arrival. 
     * See timeType below
     */
    @Title("date")
    @Range(min=8, max=8)
    private String date;
        
    /**
     * Time of departure or arrival. 
     * See timeType below
     */
    @Title("time")
    @Range(min=4, max=4)
    private String time;
    
    /**
     * Time of the request.
     */
    @Title("timetype")
    private TimeType timeType;
    
    /**
     * Minimum time spent at a via_point in minutes.
     */
    @Title("via_time")
    private int viaTime;
    
    /**
     * Ticket zone.
     */
    @Title("zone")
    private TicketZone zone;
    
    /**
     * Transport types.
     */
    @Title("transport_types")
    private List<TransportType> transportTypes;
        
    /**
     * Mode costs for different transport types.
     */
    @Title("optimize")
    private OptimizeMode optimize;
    
    /**
     * Walking speed (m/min)
     */
    @Title("walk_speed")
    @Range(min=1, max=500)
    private int walkSpeed = 70;
    
    /**
     * Detail level of the response.
     */
    @Title("detail")
    private Detail detail = Detail.NORMAL;
    
    /**
     * Number of routes in the response.
     */
    @Title("show")
    @Range(min=1, max=5)
    private int show = 3;
    
    /**
     * Time of the request.
     */
    public enum TimeType {
        DEPARTURE("departure"), ARRIVAL("arrival");
        
        private String type;
        private TimeType(String type) {
            this.type = type;
        }
        
        @Override
        public String toString(){
            return type;
        }
    }
    
    /**
     * Ticket zone.
     */
    public enum TicketZone {
        HELSINKI("helsinki"), ESPOO("espoo"), WHOLE("whole"), REGION("region"), VANTAA("vantaa");
        
        private String zone;
        private TicketZone(String zone) {
            this.zone = zone;
        }
        
        @Override
        public String toString(){
            return zone;
        }
    }
    
    /**
     * Transport types.
     */
    public enum TransportType {
        ALL("all"), TRAIN("train"), METRO("metro"), TRAM("tram"), SERVICE("service"), U_LINE("uline"), FERRY("ferry"), WALK("walk"), BUS("bus");
        
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
     * Detail level of the response.
     */
    public enum Detail {
        LIMITED("limited"), FULL("full"), NORMAL("normal");
        
        private String detail;
        private Detail(String detail) {
            this.detail = detail;
        }
        
        @Override
        public String toString(){
            return detail;
        }
    }
    
    /**
     * Mode costs for different transport types.
     */
    public enum OptimizeMode {
        DEFAULT("default"), FASTEST("fastest"), LEAST_WALKING("least_walking"), LEAST_TRANSFERS("least_transfers");
        
        private String mode;
        private OptimizeMode(String mode) {
            this.mode = mode;
        }
        
        @Override
        public String toString(){
            return mode;
        }
    }
    
    public RouteRequest(Coordinate from, Coordinate to) {
        this.from = from;
        this.to = to;
    }
    
    @Override
    protected String getActionName() {
        return ACTION_NAME;
    }
    
    /**
     * Executes request
     *
     * @return  a list of RouteResources
     * @throws java.io.IOException
     */
    @Override
    public List<RouteResource<Leg>> execute() throws IOException {
        return super.execute();
    }

    @Override
    protected List<RouteResource<List<Leg>>> parseResponse(String response) {
        return ParseFactory.parseRouteResponse(response);
    }

    /**
     * Sets starting coordinates.
     *
     * @param  from   starting coordinates
     */
    public void setFrom(Coordinate from) {
        this.from = from;
    }

    /**
     * Sets coordinates where route must go by.
     *
     * @param  via   via coordinates
     */
    public void setVia(Coordinate via) {
        this.via = via;
    }

    /**
     * Sets ending coordinates.
     *
     * @param  to   ending coordinates
     */
    public void setTo(Coordinate to) {
        this.to = to;
    }

    /**
     * Sets date.
     *
     * @param  date date. Default current date
     */
    public void setDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMDD", Locale.ENGLISH);
        this.date = sdf.format(date);
    }

    /**
     * Sets time.
     *
     * @param  time time. Default current time
     */
    public void setTime(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("HHMM", Locale.ENGLISH);
        this.time = sdf.format(time);
    }

    /**
     * Time of the request is for "arrival" or "departure".
     *
     * @param  timeType time type. Default TimeType.DEPARTURE
     */
    public void setTimeType(TimeType timeType) {
        this.timeType = timeType;
    }

    /**
     * Sets the minimum time spent at a via_point in minutes.
     *
     * @param  viaTime via time
     */
    public void setViaTime(int viaTime) {
        this.viaTime = viaTime;
    }

    /**
     * Limits ticket zones to the request.
     *
     * @param  zone   Default no limitations
     */
    public void setZone(TicketZone zone) {
        this.zone = zone;
    }

    /**
     * Limits transport types to the request.
     *
     * @param  transportTypes   Default TransportTypes.ALL
     */
    public void setTransportTypes(List<TransportType> transportTypes) {
        this.transportTypes = transportTypes;
    }

    /**
     * Sets the optimization mode.
     *
     * @param  optimize   Default OptimizeMode.DEFAULT
     */
    public void setOptimize(OptimizeMode optimize) {
        this.optimize = optimize;
    }

    /**
     * Sets the walking speed.
     *
     * @param  walkSpeed   Default 70 m/min, range 1-500.
     */
    public void setWalkSpeed(int walkSpeed) {
        this.walkSpeed = walkSpeed;
    }

    /**
     * Sets the detail level of the response.
     *
     * @param  detail   Default Detail.NORMAL
     */
    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    /**
     * Sets the number of routes in the response.
     *
     * @param  show   number of routes in the response. Default 3, max 5.
     */
    public void setShow(int show) {
        this.show = show;
    }
}

    