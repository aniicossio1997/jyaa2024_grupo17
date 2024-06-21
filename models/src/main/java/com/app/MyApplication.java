package com.app;

import org.glassfish.jersey.server.ResourceConfig;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class MyApplication extends ResourceConfig {
    public MyApplication() {
        packages("com.app", "com.app.dao");

        register(new ApplicationBinder());

    }
}