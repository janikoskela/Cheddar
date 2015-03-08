package com.hsl.journeyplanner;

/**
 *
 * @author  Koskela Jani
 */
public final class Credential {
    /**
    * Reittiopas API username
    */
    private static String ApiUsername;
    
    /**
    * Reittiopas API password
    */
    private static String ApiPassword;

    /**
     * Gets Reittiopas API username
     *
     * @return  ApiUsername   username
     */
    public static String getApiUsernmae() {
        return ApiUsername;
    }

    /**
     * Sets Reittiopas API username to be included into requests 
     *
     * @param  ApiUsername   username
     */
    public static void setApiUsernmae(String ApiUsername) {
        Credential.ApiUsername = ApiUsername;
    }

    /**
     * Gets Reittiopas API password
     *
     * @return  ApiPassword   password
     */
    public static String getApiPassword() {
        return ApiPassword;
    }

    /**
     * Sets Reittiopas API password to be included into requests 
     *
     * @param  ApiPassword   password
     */
    public static void setApiPassword(String ApiPassword) {
        Credential.ApiPassword = ApiPassword;
    }
}
