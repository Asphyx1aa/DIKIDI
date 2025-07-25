package ru.dikidi.common.context;

import io.restassured.response.Response;

public class AuthContext {
    private static final ThreadLocal<Response> authData = new ThreadLocal<>();

    public static void setAuthResponse(Response response) {
        authData.set(response);
    }

    public static Response getAuthResponse() {
        return authData.get();
    }

}
