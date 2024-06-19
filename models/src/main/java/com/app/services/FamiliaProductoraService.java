package com.app.services;

import com.app.dao.FactoryDAO;
import com.app.dao.interfaces.IFamiliaProductoraDao;
import com.app.models.FamiliaProductora;
import com.app.services.interfaces.IFamiliaProductoraService;
import com.app.viewModels.FamiliaProductoraPostViewModel;
import jakarta.validation.Valid;
import org.glassfish.hk2.api.PerLookup;
import org.jvnet.hk2.annotations.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@PerLookup
public class FamiliaProductoraService implements IFamiliaProductoraService {
    private IFamiliaProductoraDao familiaProductoraDao= FactoryDAO.createFamiliaProductoraDao();

    @Override
    public List<FamiliaProductora> getByFilter() {
        return this.familiaProductoraDao.getAll();
    }

    @Override
    public FamiliaProductora save(FamiliaProductoraPostViewModel entityToAdd) {
       if(entityToAdd.nombre.isEmpty() ){
            throw new RuntimeException("¡Ocurrió un error anónimo!");
        }
        FamiliaProductora entityNew= new FamiliaProductora(entityToAdd.nombre, entityToAdd.descripcion);
        this.familiaProductoraDao.save(entityNew);
        // Obtener y ordenar todas las entidades por ID descendente
        List<FamiliaProductora> sortedFamilias = this.familiaProductoraDao.getAll().stream()
                .sorted(Comparator.comparingLong(FamiliaProductora::getId).reversed())
                .collect(Collectors.toList());

        // Devolver la primera entidad (la más reciente por ID)
        return sortedFamilias.get(0);
    }

    @Override
    public FamiliaProductora update(Long id,FamiliaProductoraPostViewModel entityToEdit) {
        FamiliaProductora entityNew= new FamiliaProductora(entityToEdit.nombre, entityToEdit.descripcion);
        FamiliaProductora familia = this.familiaProductoraDao.getById(id);
        familia.setNombre(entityNew.getNombre());
        familia.setDescripcion(entityNew.getDescripcion());
        this.familiaProductoraDao.save(familia);
        return  familia;


    }

    @Override
    public FamiliaProductora delete() {
        return null;
    }
}
