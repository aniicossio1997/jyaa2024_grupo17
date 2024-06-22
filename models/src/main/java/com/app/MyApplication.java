package com.app;

import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class MyApplication extends ResourceConfig {
    public MyApplication() {
        packages("com.app");

        register(new ApplicationBinder());

        register(OpenApiResource.class);

        property(ServletProperties.FILTER_STATIC_CONTENT_REGEX, "/swagger/.*");
    }
}