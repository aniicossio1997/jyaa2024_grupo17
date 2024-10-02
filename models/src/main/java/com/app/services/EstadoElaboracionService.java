package com.app.services;

import com.app.dao.implementations.ElaboracionDao;
import com.app.dao.interfaces.*;
import com.app.models.*;
import com.app.services.interfaces.IEstadoElaboracionService;
import com.app.services.interfaces.IEstadoIngresoMateriaPrimaService;
import com.app.viewModels.EstadoElaboracionCreateViewModel;
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
    private IEstadoElaboracionDao estadoElaboracionDao;
    @Inject
    private IElaboracionDao elaboracionDao;
    @Inject
    private IUsuarioDao _usuarioDao;

    @Override
    public EstadoViewModel create(EstadoElaboracionCreateViewModel entityToAdd) {
        Elaboracion elaboracion = this.elaboracionDao.getById(entityToAdd.elaboracionId);

        Usuario user=_usuarioDao.getById(entityToAdd.usuarioId);

        EstadoElaboracion estado = new EstadoElaboracion(user, new Date(), entityToAdd.estado, elaboracion);
        elaboracion.updateEstado(estado);
        estadoElaboracionDao.save(estado);
        return this.toViewModel(estado);
    }

    private EstadoViewModel toViewModel(EstadoElaboracion imp) {
        return  new EstadoViewModel(
                imp.getId(),
                new NameableViewModel(imp.getAutor().getId(), imp.getAutor().getNombre() +" " + imp.getAutor().getApellido()),
                imp.getEstado().getValue(),
                imp.getFecha()
        );
    }
}
