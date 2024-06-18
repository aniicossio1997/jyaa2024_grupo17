package com.app;

import jakarta.ws.rs.ext.Provider;
import org.glassfish.hk2.api.JustInTimeInjectionResolver;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

/**
 *
 */
@Provider
public class ApplicationBinder extends AbstractBinder {

    @Override
    protected void configure() {
        bind(JustInTimeServiceResolver.class).to(JustInTimeInjectionResolver.class);
    }

}