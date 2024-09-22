package com.app;

import com.app.exceptions.ServerExceptionMapper;
import com.app.filters.AuthFilter;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/ui")
public class AngularApplication extends ResourceConfig {
    public AngularApplication() {
        packages("com.app");
        //register(NoResultExceptionMapper.class);

    }
}