package com.app.services;

import com.app.dao.interfaces.IEstadoMateriaPrimaDao;
import com.app.dao.interfaces.IIngresoMateriaPrimaDao;
import com.app.dao.interfaces.IUsuarioDao;
import com.app.models.EstadoMateriaPrima;
import com.app.models.IngresoMateriaPrima;
import com.app.models.Usuario;
import com.app.services.interfaces.IEstadoElaboracionService;
import com.app.services.interfaces.IEstadoIngresoMateriaPrimaService;
import com.app.viewModels.EstadoIngresoMateriaPrimaCreateViewModel;
import com.app.viewModels.EstadoViewModel;
import com.app.viewModels.base.NameableViewModel;
import jakarta.inject.Inject;
import org.glassfish.hk2.api.PerLookup;
import org.jvnet.hk2.annotations.Service;

import java.util.Date;

@Service
@PerLookup
public class EstadoElaboracionService implements IEstadoElaboracionService {
    @Inject
    IEstadoMateriaPrimaDao estadoMateriaPrimaDao;


    @Inject
    private IIngresoMateriaPrimaDao ingresoMateriaPrimaDao;
    @Inject
    private IUsuarioDao _usuarioDao;

    @Override
    public EstadoViewModel create(EstadoIngresoMateriaPrimaCreateViewModel entityToAdd) {
        IngresoMateriaPrima ingresoMateriaPrima = this.ingresoMateriaPrimaDao.getById(entityToAdd.ingresoMateriaPrimaId);

        Usuario user=_usuarioDao.getById(Long.valueOf(entityToAdd.getUserId()));

        EstadoMateriaPrima estado = new EstadoMateriaPrima(user, new Date(), entityToAdd.estado,ingresoMateriaPrima);
        ingresoMateriaPrima.addEstado(estado);
        estadoMateriaPrimaDao.save(estado);
        return toViewModel(estado);
    }

    private EstadoViewModel toViewModel(EstadoMateriaPrima imp) {

        return  new EstadoViewModel(
                imp.getId(),
                new NameableViewModel(imp.getAutor().getId(), imp.getAutor().getNombre() +" " + imp.getAutor().getApellido()),
                imp.getEstadoName(),
                imp.getFecha()
        );
    }
}
