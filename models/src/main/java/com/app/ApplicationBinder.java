package com.app;

import com.app.dao.EntityManagerFactoryProvider;
import com.app.dao.EntityManagerProvider;
import com.app.dao.implementations.*;
import com.app.dao.interfaces.*;
import com.app.resources.MateriaPrimaResource;
import jakarta.inject.Singleton;
import jakarta.ws.rs.ext.Provider;
import org.glassfish.hk2.api.JustInTimeInjectionResolver;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 */
@Provider
public class ApplicationBinder extends AbstractBinder {

    @Override
    protected void configure() {
        bindFactory(EntityManagerFactoryProvider.class)
                .to(EntityManagerFactory.class)
                .in(Singleton.class);
        bindFactory(EntityManagerProvider.class)
                .to(EntityManager.class);

        // DAO
        bind(ConsumoInsumoDao.class).to(IConsumoInsumoDao.class);
        bind(ConsumoMateriaPrimaDao.class).to(IConsumoMateriaPrimaDao.class);
        bind(EntregaProductoDao.class).to(IEntregaProductoDao.class);
        bind(EstadoLoteDao.class).to(IEstadoLoteDao.class);
        bind(EstadoMateriaPrimaDao.class).to(IEstadoMateriaPrimaDao.class);
        bind(FamiliaProductoraDao.class).to(IFamiliaProductoraDao.class);
        bind(IngredienteRecetaDao.class).to(IIngredienteRecetaDao.class);
        bind(IngresoInsumoDao.class).to(IIngresoInsumoDao.class);
        bind(IngresoMateriaPrimaDao.class).to(IIngresoMateriaPrimaDao.class);
        bind(InsumoDao.class).to(IInsumoDao.class);
        bind(LoteProductoElaboradoDao.class).to(ILoteProductoElaboradoDao.class);
        bind(MateriaPrimaDao.class).to(IMateriaPrimaDao.class);
        bind(NotaDao.class).to(INotaDao.class);
        bind(PuntoVentaDao.class).to(IPuntoVentaDao.class);
        bind(RecetaDao.class).to(IRecetaDao.class);
        bind(UsuarioDao.class).to(IUsuarioDao.class);

        // SERVICES
        bind(JustInTimeServiceResolver.class).to(JustInTimeInjectionResolver.class);
    }


}