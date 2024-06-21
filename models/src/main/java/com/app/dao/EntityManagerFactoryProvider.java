package com.app.dao;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import org.glassfish.hk2.api.Factory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryProvider implements Factory<EntityManagerFactory> {
    protected EntityManagerFactory emf;
    private static final String UNIDAD_DE_PERSISTENCIA = "miUP";

    @PostConstruct
    public void setup() {
        emf = Persistence.createEntityManagerFactory(UNIDAD_DE_PERSISTENCIA);
    }

    @Override
    public EntityManagerFactory provide() {
        return emf;
    }

    @Override
    public void dispose(EntityManagerFactory instance) {
    }

}
