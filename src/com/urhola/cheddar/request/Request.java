package com.urhola.cheddar.request;

import com.urhola.cheddar.Cheddar;
import com.urhola.cheddar.annotation.Title;
import com.urhola.cheddar.connection.Connection;
import com.urhola.cheddar.resource.common.Coordinate;
import com.urhola.cheddar.util.Utils;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

/**
 *
 * @author janikoskela
 */
public abstract class Request {
    
    private static final String BASE_URL = "http://api.reittiopas.fi/hsl/prod/?request=";

    private void validateRequest() throws IllegalArgumentException {
        Validator validator = new Validator();
        List<ConstraintViolation> violations = validator.validate(this);
        if (violations.size() > 0)
            throw new IllegalArgumentException(violations.toString());
    }
    
    protected String getRequestUrl() {
        //TODO: use stringbuilder instead?
        String requestUrl = "";
        Field[] fields = this.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            try {
                fields[i].setAccessible(true);
                String key = fields[i].getAnnotation(Title.class).value();
                String value = null;
                if (fields[i].get(this) instanceof List)
                    value = Utils.convertListToString((List)fields[i].get(this));
                else if (fields[i].get(this) instanceof Coordinate) 
                    value = Utils.convertCoordinateToString((Coordinate)fields[i].get(this));
                else    
                    value = fields[i].get(this).toString();
                if (value != null) 
                    requestUrl += key + "=" + value + "&";
            } catch (IllegalArgumentException | IllegalAccessException | NullPointerException ex) {
                continue;
            }
        }
        if (requestUrl.endsWith(("&")))
            requestUrl = requestUrl.substring(0, requestUrl.length() - 1);
        return requestUrl;
    }
        
    private String getUrl() throws IllegalArgumentException {
        return (BASE_URL + this.getActionName() + "&user=" + Cheddar.getApiUsername() + "&pass=" + Cheddar.getApiPassword() + "&format=json&" + this.getRequestUrl()).trim();
    }
    
    public <T>List<T> execute() throws IllegalArgumentException, IOException {
        this.validateRequest();
        String url = this.getUrl();
        System.out.println(url);
        String resp = Connection.sendRequest(url);
        return this.parseResponse(resp);
    }
    
    protected abstract String getActionName();
    protected abstract <T> List<T> parseResponse(String response);

}
