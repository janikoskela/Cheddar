package com.hsl.journeyplanner.connection;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 *
 * @author  Koskela Jani
 */
final public class Connection {
    
    private final static int TIME_OUT_LENGTH = 2000;

    public static String sendRequest(String url) throws IOException {
        URL u = new URL(url);
        HttpURLConnection urlConnection = (HttpURLConnection) u.openConnection();
        urlConnection.setReadTimeout(TIME_OUT_LENGTH);
        int responseCode = urlConnection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK)
            throw new IOException("Server returned error. This may be caused due to invalid username and/or password");
        InputStream in = new BufferedInputStream(urlConnection.getInputStream());
        String out = Connection.readStream(in);
        urlConnection.disconnect();
        return out;
    }
    
    private static String readStream(InputStream in) throws IOException {
        String line;
        BufferedReader r = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        while((line = r.readLine()) != null) 
                sb.append(line);
        return sb.toString();
    }
}