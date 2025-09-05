package ru.dikidi.common.context;

import io.restassured.response.Response;

public class ProjectContext {
    private static final ThreadLocal<Response> projectData = new ThreadLocal<>();

    public static void setProjectResponse(Response response) { projectData.set(response); }

    public static Response getProjectResponse() { return projectData.get(); }
}
