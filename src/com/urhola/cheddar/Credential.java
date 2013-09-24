package com.urhola.cheddar;

/**
 *
 * @author janikoskela
 */
public final class Credential {
    public static String ApiUsername;
    public static String ApiPassword;

    public static String getApiUsernmae() {
        return ApiUsername;
    }

    public static void setApiUsernmae(String ApiUsernmae) {
        Credential.ApiUsername = ApiUsernmae;
    }

    public static String getApiPassword() {
        return ApiPassword;
    }

    public static void setApiPassword(String ApiPassword) {
        Credential.ApiPassword = ApiPassword;
    }
}
