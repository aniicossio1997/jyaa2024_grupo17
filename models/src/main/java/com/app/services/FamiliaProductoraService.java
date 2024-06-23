package com.app.services;

import com.app.dao.FactoryDAO;
import com.app.dao.interfaces.IFamiliaProductoraDao;
import com.app.models.FamiliaProductora;
import com.app.models.MateriaPrima;
import com.app.services.interfaces.IFamiliaProductoraService;
import com.app.utils.ListUtils;
import com.app.viewModels.FamiliaProductoraPostViewModel;

import com.app.viewModels.base.NameableViewModel;
import org.glassfish.hk2.api.PerLookup;
import org.jvnet.hk2.annotations.Service;
import jakarta.inject.Inject;
import jakarta.inject.Inject;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@PerLookup
public class FamiliaProductoraService implements IFamiliaProductoraService {
    @Inject
    private IFamiliaProductoraDao familiaProductoraDao;

    @Override
    public List<NameableViewModel> getByFilter() {
        return  ListUtils.mapList(familiaProductoraDao.getAll(true), this::toViewModel);

    }

    @Override
    public FamiliaProductora save(FamiliaProductoraPostViewModel entityToAdd) {
       if(entityToAdd.nombre.isEmpty() ){
            throw new RuntimeException("¡Ocurrió un error anónimo!");
        }
        FamiliaProductora entityNew= new FamiliaProductora(entityToAdd.nombre, entityToAdd.descripcion);
        this.familiaProductoraDao.save(entityNew);
        return entityNew;
    }

    @Override
    public FamiliaProductora update(Long id,FamiliaProductoraPostViewModel entityToEdit) {
        FamiliaProductora familia = this.familiaProductoraDao.getById(id,true);
        familia.setNombre(entityToEdit.nombre);
        familia.setDescripcion(entityToEdit.descripcion);
        this.familiaProductoraDao.save(familia);
        return  familia;


    }

    @Override
    public void delete(Long id) {
        FamiliaProductora familia = this.familiaProductoraDao.getById(id);
        familia.setFechaBaja(new Date());
        this.familiaProductoraDao.save(familia);
    }

    @Override
    public FamiliaProductora getById(Long id) {
        return this.familiaProductoraDao.getById(id);
    }
    private NameableViewModel toViewModel(FamiliaProductora entity) {
        return new NameableViewModel(
                entity.getId(),
                entity.getNombre()

        );
    }
}
