package com.app;

import com.app.exceptions.NoResultExceptionMapper;
import com.app.exceptions.ServerExceptionMapper;
import com.app.resources.FamiliaProductoraResource;
import org.glassfish.jersey.server.ResourceConfig;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class MyApplication extends ResourceConfig {
    public MyApplication() {
        packages("com.app");
        //register(NoResultExceptionMapper.class);
        register(ServerExceptionMapper.class);

        register(new ApplicationBinder());

    }
}