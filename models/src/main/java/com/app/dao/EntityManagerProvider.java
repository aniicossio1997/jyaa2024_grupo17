package com.app.dao;

import jakarta.inject.Inject;
import org.glassfish.hk2.api.Factory;
import org.glassfish.jersey.server.CloseableService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class EntityManagerProvider implements Factory<EntityManager> {

    private final EntityManagerFactory emf;
    private final CloseableService closeableService;

    @Inject
    public EntityManagerProvider(EntityManagerFactory emf, CloseableService closeableService) {
        this.emf = emf;
        this.closeableService = closeableService;
    }

    @Override
    public EntityManager provide() {
        final EntityManager em = emf.createEntityManager();
        closeableService.add(em::close);
        return em;
    }

    @Override
    public void dispose(EntityManager entityManager) {
        entityManager.close();
    }

}