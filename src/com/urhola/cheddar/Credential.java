package com.urhola.cheddar;

/**
 *
 * @author janikoskela
 */
public final class Credential {
    private static String ApiUsername;
    private static String ApiPassword;

    public static String getApiUsernmae() {
        return ApiUsername;
    }

    public static void setApiUsernmae(String ApiUsername) {
        Credential.ApiUsername = ApiUsername;
    }

    public static String getApiPassword() {
        return ApiPassword;
    }

    public static void setApiPassword(String ApiPassword) {
        Credential.ApiPassword = ApiPassword;
    }
}
