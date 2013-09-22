package com.urhola.cheddar.request;

import com.urhola.cheddar.annotation.AllowedValues;
import com.urhola.cheddar.annotation.Title;
import com.urhola.cheddar.parse.ParseFactory;
import com.urhola.cheddar.resource.common.Coordinate;
import com.urhola.cheddar.resource.route.Leg;
import com.urhola.cheddar.resource.RouteResource;
import java.io.IOException;
import java.util.List;
import net.sf.oval.constraint.NotNull;
import net.sf.oval.constraint.Range;

/**
 *
 * @author janikoskela
 */
public class RouteRequest extends Request {
    
    private static final String ACTION_NAME = "route";
    
    @NotNull
    @Title("from")
    private Coordinate from;
    
    @Title("via")
    private Coordinate via;
    
    @NotNull
    @Title("to")
    private Coordinate to;
    
    @Title("date")
    @Range(min=8, max=8)
    private String date;
        
    @Title("time")
    @Range(min=4, max=4)
    private String time;
    
    @Title("timetype")
    @AllowedValues({"departure", "arrival"})
    private String timeType;
    
    @Title("via_time")
    private int viaTime;
    
    @Title("zone")
    @AllowedValues({"helsinki", "espoo", "whole", "region", "vantaa"})
    private String zone;
    
    @Title("transport_types")
    @AllowedValues({"all", "bus", "train", "metro", "tram", "service", "uline", "ferry", "walk"})
    private List<String> transportTypes;
        
    @Title("optimize")
    @AllowedValues({"default", "fastest", "least_transfers", "least_walking"})
    private String optimize;
    
    /*@Title("change_margin")
    @Range(min=0, max=10)
    private int changeMargin;
    
    @Title("change_cost")
    @Range(min=1, max=99)
    private int changeCost = 5;
    
    @Title("wait_cost")
    @Range(min=0.1, max=10)
    private int waitCost;
    
    @Title("walk_cost")
    @Range(min=0.1, max=10)
    private int walkCost;*/
    
    @Title("walk_speed")
    @Range(min=1, max=500)
    private int walkSpeed = 70;
    
    @Title("detail")
    @AllowedValues({"limited", "full", "normal"})
    private String detail;
    
    @Title("show")
    @Range(min=1, max=5)
    private int show = 1;
    
    /*@Title("mode_cost_?")
    @Range(min=0.1, max=10)
    private int modeCost;
*/
    @Override
    protected String getActionName() {
        return ACTION_NAME;
    }
    
    @Override
    public List<RouteResource<Leg>> execute() throws IOException {
        return super.execute();
    }

    @Override
    protected List<RouteResource> parseResponse(String response) {
        return ParseFactory.parseRouteResponse(response);
    }

    public void setFrom(Coordinate from) {
        this.from = from;
    }

    public void setVia(Coordinate via) {
        this.via = via;
    }

    public void setTo(Coordinate to) {
        this.to = to;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setTimeType(String timeType) {
        this.timeType = timeType;
    }

    public void setViaTime(int viaTime) {
        this.viaTime = viaTime;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public void setTransportTypes(List<String> transportTypes) {
        this.transportTypes = transportTypes;
    }

    public void setOptimize(String optimize) {
        this.optimize = optimize;
    }

    /*public void setChangeMargin(int changeMargin) {
        this.changeMargin = changeMargin;
    }

    public void setChangeCost(int changeCost) {
        this.changeCost = changeCost;
    }

    public void setWaitCost(int waitCost) {
        this.waitCost = waitCost;
    }

    public void setWalkCost(int walkCost) {
        this.walkCost = walkCost;
    }*/

    public void setWalkSpeed(int walkSpeed) {
        this.walkSpeed = walkSpeed;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setShow(int show) {
        this.show = show;
    }

    /*public void setModeCost(int modeCost) {
        this.modeCost = modeCost;
    }*/
}

    