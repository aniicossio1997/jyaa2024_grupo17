package com.app.services;

import com.app.dao.interfaces.*;
import com.app.exceptions.InvalidParameterException;
import com.app.models.*;
import com.app.services.interfaces.IElaboracionService;
import com.app.services.interfaces.INotaService;
import com.app.utils.ListUtils;
import com.app.viewModels.*;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import org.glassfish.hk2.api.PerLookup;
import org.jvnet.hk2.annotations.Service;

import java.text.MessageFormat;
import java.util.*;

@Service
@PerLookup
public class NotaService implements INotaService {

    @Inject
    private IUsuarioDao usuarioDao;

    @Inject
    private IElaboracionDao elaboracionDao;

    @Inject
    private INotaDao notaDao;

    @Inject
    private MappingService mappingService;

    @Override
    public NotaViewModel create(Long usuarioId, NotaCreateViewModel view) {
        Usuario autor = usuarioDao.getById(usuarioId);
        Elaboracion elaboracion = elaboracionDao.getById(view.elaboracionId);

        if (elaboracion == null) throw new InvalidParameterException("elaboracion_not_found");

        Nota nota = new Nota(autor, view.descripcion, elaboracion);

        elaboracion.getNotas().add(nota);

        this.elaboracionDao.save(elaboracion);

        return mappingService.toViewModel(nota);
    }
    @Override
    public boolean delete(Long notaId) {
        Nota nota = notaDao.getById(notaId);
        if (nota == null) throw new InvalidParameterException("nota_not_found");
        nota.setFechaBaja(new Date());
        notaDao.save(nota);
        return true;
    }

}
