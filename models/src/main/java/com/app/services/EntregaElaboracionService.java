package com.app.services;

import com.app.dao.interfaces.IElaboracionDao;
import com.app.dao.interfaces.IEntregaElaboracionDao;
import com.app.dao.interfaces.IPuntoVentaDao;
import com.app.dao.interfaces.IUsuarioDao;
import com.app.exceptions.InvalidParameterException;
import com.app.models.*;
import com.app.models.enums.EstadoElaboracionEnum;
import com.app.services.interfaces.IEntregaElaboracionService;
import com.app.services.interfaces.IPuntoVentaService;
import com.app.utils.ListUtils;
import com.app.viewModels.EntregaElaboracionCreateViewModel;
import com.app.viewModels.EntregaElaboracionViewModel;
import com.app.viewModels.PuntoVentaCreateViewModel;
import com.app.viewModels.PuntoVentaViewModel;
import jakarta.inject.Inject;
import org.glassfish.hk2.api.PerLookup;
import org.jvnet.hk2.annotations.Service;

import java.util.Date;
import java.util.List;

@Service
@PerLookup
public class EntregaElaboracionService implements IEntregaElaboracionService {

    @Inject
    private IEntregaElaboracionDao entregaElaboracionDao;
    @Inject
    private IElaboracionDao elaboracionDao;
    @Inject
    private IPuntoVentaDao puntoVentaDao;

    @Inject
    private MappingService mappingService;
    @Inject
    private IUsuarioDao usuarioDao;

    @Override
    public List<EntregaElaboracionViewModel> getAll(Long elaboracionId, Long puntoVentaId) {
        List<EntregaElaboracion> entregas;
        if (elaboracionId != null) {
            entregas = entregaElaboracionDao.getByElaboracion(elaboracionId);
        } else if (puntoVentaId != null) {
            entregas = entregaElaboracionDao.getByPuntoVenta(puntoVentaId);
        } else {
            entregas = entregaElaboracionDao.getAll();
        }
        return ListUtils.mapList(entregas, mappingService::toViewModel);
    }

    @Override
    public EntregaElaboracionViewModel create(EntregaElaboracionCreateViewModel entityToAdd) {
        Elaboracion elaboracion = elaboracionDao.getById(entityToAdd.elaboracionId);
        PuntoVenta puntoVenta = puntoVentaDao.getById(entityToAdd.puntoVentaId);
        Usuario usuario = usuarioDao.getById(entityToAdd.usuarioId);

        if (entityToAdd.cantidad <= 0) {
            throw new InvalidParameterException("Debes indicar una cantidad");
        }

        long cantEntregada = elaboracion.getTotalEntregado() + entityToAdd.cantidad;

        if (cantEntregada > elaboracion.getCantidad()) {
            throw new InvalidParameterException("La cantidad excede el total disponible para entregar");
        }

        EntregaElaboracion entityNew = new EntregaElaboracion(entityToAdd.cantidad, elaboracion, puntoVenta, entityToAdd.fecha, usuario);
        this.entregaElaboracionDao.save(entityNew);

        EstadoElaboracionEnum estadoEnum = cantEntregada < elaboracion.getCantidad() ? EstadoElaboracionEnum.ENTREGADO_PARCIAL : EstadoElaboracionEnum.ENTREGADO_COMPLETO;
        if (estadoEnum != elaboracion.getEstadoActual().getEstado()) {
            EstadoElaboracion estado = new EstadoElaboracion(usuario, entityToAdd.fecha, estadoEnum, elaboracion);
            elaboracion.updateEstado(estado);
            this.elaboracionDao.save(elaboracion);
        }

        return mappingService.toViewModel(entityNew);
    }

    @Override
    public void delete(Long id) {
        EntregaElaboracion entregaElaboracion = this.entregaElaboracionDao.getById(id);
        entregaElaboracion.setFechaBaja(new Date());
        this.entregaElaboracionDao.save(entregaElaboracion);
    }

    @Override
    public EntregaElaboracionViewModel getById(Long id) {
        return mappingService.toViewModel(this.entregaElaboracionDao.getById(id));
    }

}
