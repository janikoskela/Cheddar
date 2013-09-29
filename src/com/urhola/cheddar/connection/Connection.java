package com.urhola.cheddar.connection;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


/**
 *
 * @author janikoskela
 */
final public class Connection {
    
    private static final int HTTP_STATUS_OK = 200;
    public static String sendRequest(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String resp = null;
        try {
            HttpGet httpGet = new HttpGet(url);

            // Create a custom response handler
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

                @Override
                public String handleResponse(
                        final HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status == HTTP_STATUS_OK) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }

            };
            resp = httpClient.execute(httpGet, responseHandler);

        } catch (Exception ex) {
            throw new IOException();
        }
        finally {
            httpClient.close();
            return resp;
        }
    }
}
