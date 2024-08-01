package com.app.services;

import com.app.dao.interfaces.IPuntoVentaDao;
import com.app.models.FamiliaProductora;
import com.app.models.PuntoVenta;
import com.app.services.interfaces.IPuntoVentaService;
import com.app.utils.ListUtils;
import com.app.viewModels.FamiliaProductoraPostViewModel;
import com.app.viewModels.FamiliaProductoraViewModel;
import com.app.viewModels.PuntoVentaCreateViewModel;
import com.app.viewModels.PuntoVentaViewModel;
import jakarta.inject.Inject;
import org.glassfish.hk2.api.PerLookup;
import org.jvnet.hk2.annotations.Service;

import java.util.Date;
import java.util.List;

@Service
@PerLookup
public class PuntoVentaService implements IPuntoVentaService {
    @Inject
    private IPuntoVentaDao puntoVentaDao;

    @Override
    public List<PuntoVentaViewModel> getAll() {
        return ListUtils.mapList(puntoVentaDao.getAll(), this::toViewModel);
    }

    @Override
    public PuntoVentaViewModel save(PuntoVentaCreateViewModel entityToAdd) {
        PuntoVenta entityNew = new PuntoVenta(entityToAdd.nombre, entityToAdd.descripcion);
        this.puntoVentaDao.save(entityNew);
        return this.toViewModel(entityNew);
    }

    @Override
    public PuntoVentaViewModel update(Long id, PuntoVentaCreateViewModel entityToEdit) {
        PuntoVenta puntoVenta = this.puntoVentaDao.getById(id);
        puntoVenta.setNombre(entityToEdit.nombre);
        puntoVenta.setDescripcion(entityToEdit.descripcion);
        this.puntoVentaDao.save(puntoVenta);
        return this.toViewModel(puntoVenta);


    }

    @Override
    public void delete(Long id) {
        PuntoVenta puntoVenta = this.puntoVentaDao.getById(id);
        puntoVenta.setFechaBaja(new Date());
        this.puntoVentaDao.save(puntoVenta);
    }

    @Override
    public PuntoVentaViewModel getById(Long id) {
        return this.toViewModel(this.puntoVentaDao.getById(id));
    }

    private PuntoVentaViewModel toViewModel(PuntoVenta entity) {
        return new PuntoVentaViewModel(
                entity.getId(),
                entity.getNombre(),
                entity.getDescripcion()
        );
    }
}
