package com.app;

import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import jakarta.servlet.annotation.HandlesTypes;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.server.ResourceConfig;

import java.util.Set;

@HandlesTypes({MyApplication.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        // Configurar Jersey aquí
        System.out.println("MyServletContainerInitializer is starting up...");
        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.packages("com.app");
        // Registrar el servlet de Jersey
        ServletRegistration.Dynamic registration = ctx.addServlet("JerseyServlet", new ServletContainer(resourceConfig));
        registration.setLoadOnStartup(1);

        registration.addMapping("/api/*");
    }
}