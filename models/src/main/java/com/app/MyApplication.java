package com.app;

    import com.app.filters.AuthFilter;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import com.app.exceptions.ServerExceptionMapper;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;

public class MyApplication extends ResourceConfig {
    public MyApplication() {
        packages("com.app");
        //register(NoResultExceptionMapper.class);
        register(ServerExceptionMapper.class);
        register(AuthFilter.class);
        register(AngularFilter.class);
        register(new ApplicationBinder());

        register(OpenApiResource.class);

        property(ServletProperties.FILTER_STATIC_CONTENT_REGEX, "/swagger/.*");
        property(ServletProperties.FILTER_STATIC_CONTENT_REGEX, "/ui/.*");
    }
}