package com.app.services;

import com.app.dao.FactoryDAO;
import com.app.dao.interfaces.IFamiliaProductoraDao;
import com.app.dao.interfaces.IIngresoMateriaPrimaDao;
import com.app.dao.interfaces.IMateriaPrimaDao;
import com.app.dao.interfaces.IUsuarioDao;
import com.app.exceptions.InvalidParameterException;
import com.app.models.*;
import com.app.models.enums.EstadoMateriaPrimaEnum;
import com.app.services.interfaces.IIngresoMateriaPrimaService;
import com.app.services.interfaces.IInsumoService;
import com.app.services.interfaces.IUsuarioService;
import com.app.utils.ListUtils;
import com.app.utils.MappingUtils;
import com.app.viewModels.*;
import com.app.viewModels.base.NameableViewModel;
import jakarta.inject.Inject;
import org.glassfish.hk2.api.PerLookup;
import org.jvnet.hk2.annotations.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@PerLookup
public class IngresoMateriaPrimaService implements IIngresoMateriaPrimaService {
    @Inject
    private IFamiliaProductoraDao familiaProductoraDao;
    @Inject
    private IMateriaPrimaDao materiaPrimaDao;
    @Inject
    private IIngresoMateriaPrimaDao ingresoMateriaPrimaDao;
    @Inject
    private IUsuarioDao _usuarioDao;

    @Override
    public IngresoMateriaPrimaViewModel create(IngresoMateriaPrimaCreateViewModel entityToAdd) {
        FamiliaProductora familia = familiaProductoraDao.getById(entityToAdd.familiaPrimaId,true);
        MateriaPrima materiaPrima = this.materiaPrimaDao.getById(entityToAdd.materiaPrimaId);
        Usuario user=_usuarioDao.getById(Long.valueOf(1));

        if(entityToAdd.estado ==null ){
            EstadoMateriaPrimaEnum estado=EstadoMateriaPrimaEnum.valueOf(entityToAdd.estado.toString());
            throw new InvalidParameterException("Name cannot be null or empty.");
        }


        IngresoMateriaPrima ingresoMateriaPrima = new IngresoMateriaPrima(entityToAdd.cantidad, entityToAdd.codigo, entityToAdd.descripcion,
                new Date(), entityToAdd.valorCompra);

        ingresoMateriaPrima.setMateriaPrima(materiaPrima);
        ingresoMateriaPrima.setProductor(familia);

        EstadoMateriaPrima estado= new EstadoMateriaPrima(user, (EstadoMateriaPrimaEnum) entityToAdd.estado);
        ingresoMateriaPrima.addEstado(estado);
        estado.setIngresoMateriaPrima(ingresoMateriaPrima);

        ingresoMateriaPrimaDao.save(ingresoMateriaPrima);
        return this.toViewModel(ingresoMateriaPrima);
    }

    @Override
    public List<IngresoMateriaPrimaViewModel> getByFilters() {
        return ListUtils.mapList(this.ingresoMateriaPrimaDao.getAll(), this::toViewModel);
    }

    @Override
    public boolean delete(Long id) {
        IngresoMateriaPrima entityToDelete= this.ingresoMateriaPrimaDao.getById(id);
        entityToDelete.setFechaBaja(new Date());;
        ingresoMateriaPrimaDao.save(entityToDelete);
        return  true;
        
    }

    @Override
    public IngresoMateriaPrimaDetailViewModel getById(Long id) {
        IngresoMateriaPrimaDetailViewModel result=  toViewModelDetails(this.ingresoMateriaPrimaDao.getById(id));
        return  result;
    }

    @Override
    public IngresoMateriaPrimaDetailViewModel update(Long id,
                                               IngresoMateriaPrimaUpdateViewModel entityToEdit ) {

            FamiliaProductora familia = familiaProductoraDao.getById(entityToEdit.familiaPrimaId,true);
            MateriaPrima materiaPrima = this.materiaPrimaDao.getById(entityToEdit.materiaPrimaId);
            Usuario user=_usuarioDao.getById(Long.valueOf(1));

            IngresoMateriaPrima ingresoMateriaPrima=ingresoMateriaPrimaDao.getById(id,true);

            ingresoMateriaPrima.setCantidad(entityToEdit.cantidad);
            ingresoMateriaPrima.setCodigo(entityToEdit.codigo);
            ingresoMateriaPrima.setDescripcion(entityToEdit.descripcion);
            ingresoMateriaPrima.setValorCompra(entityToEdit.valorCompra);

            ingresoMateriaPrima.setMateriaPrima(materiaPrima);
            ingresoMateriaPrima.setProductor(familia);

            if(!(ingresoMateriaPrima.getEstadoActual().getEstado().getValue().equals(entityToEdit.estado.getValue()))){
                EstadoMateriaPrima estado= new EstadoMateriaPrima(user, entityToEdit.estado);
                ingresoMateriaPrima.addEstado(estado);
                estado.setIngresoMateriaPrima(ingresoMateriaPrima);
            }

            ingresoMateriaPrimaDao.save(ingresoMateriaPrima);
            return this.toViewModelDetails(ingresoMateriaPrima);


    }


    private IngresoMateriaPrimaViewModel toViewModel(IngresoMateriaPrima imp) {
        return new IngresoMateriaPrimaViewModel(
                imp.getId(), imp.getValorCompra(),
                imp.getMateriaPrima(), imp.getFecha(),
                MappingUtils.toViewModel(imp.getProductor()),
                imp.getDescripcion(), imp.getCodigo(), imp.getCantidad(),
                imp.getEstadoActual()
        );
    }
    private IngresoMateriaPrimaDetailViewModel toViewModelDetails(IngresoMateriaPrima imp) {
        if (imp == null) {
            throw new InvalidParameterException("IngresoMateriaPrima cannot be null.");
        }

        List<EstadoViewModel> estadoViewModels = imp.getEstadosOrderById().stream()
                .map(e -> {
                    if (e == null || e.getAutor() == null) {
                        throw new InvalidParameterException("Estado or its Autor cannot be null.");
                    }
                    return new EstadoViewModel(
                            e.getId(),
                            new NameableViewModel(e.getAutor().getId(), e.getAutor().getNombre() + " " + e.getAutor().getApellido()),
                            e.getEstadoName(),
                            e.getFecha()
                    );
                })
                .collect(Collectors.toList());

        IngresoMateriaPrimaDetailViewModel entity = new IngresoMateriaPrimaDetailViewModel(
                imp.getId(),
                imp.getValorCompra(),
                imp.getMateriaPrima(),
                imp.getFecha(),
                MappingUtils.toViewModel(imp.getProductor()),
                imp.getDescripcion(),
                imp.getCodigo(),
                imp.getCantidad(),
                imp.getEstadoActual(),
                estadoViewModels
        );

        return entity;
    }

}
