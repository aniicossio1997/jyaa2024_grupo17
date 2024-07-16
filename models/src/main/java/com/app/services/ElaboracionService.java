package com.app.services;

import com.app.dao.interfaces.*;
import com.app.exceptions.InvalidParameterException;
import com.app.models.*;
import com.app.services.interfaces.IElaboracionService;
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
public class ElaboracionService implements IElaboracionService {

    @Inject
    private IUsuarioDao usuarioDao;
    @Inject
    private IRecetaDao recetaDao;

    @Inject
    private IElaboracionDao elaboracionDao;

    @Inject
    private IInsumoDao insumoDao;

    @Inject
    private IIngresoMateriaPrimaDao ingresoMateriaPrimaDao;

    @Inject
    private MappingService mappingService;

    @Override
    public List<ElaboracionViewModel> getAll(Long recetaId) {
        if (recetaId != null) {
            return ListUtils.mapList(elaboracionDao.getByRecetaId(recetaId), mappingService::toViewModel);
        }
        return ListUtils.mapList(elaboracionDao.getAll(), mappingService::toViewModel);
    }


    @Override
    public ElaboracionDetalleViewModel getById(Long id) {
        return mappingService.toDetalleViewModel(elaboracionDao.getById(id));
    }

    @Override
    public ElaboracionDetalleViewModel create(ElaboracionCreateViewModel view) {
        Receta receta = recetaDao.getById(view.recetaId);
        Elaboracion elaboracion = new Elaboracion(view.cantidad.intValue(), "", new Date(), receta);


        List<ConsumoInsumo> consumoInsumos = new ArrayList<>();

        for (ConsumoCreateViewModel c : view.consumoInsumos) {
            Insumo insumo = insumoDao.getById(c.insumoId);
            if (insumo == null) throw new NotFoundException("insumo_not_found");
            consumoInsumos.add(new ConsumoInsumo(c.cantidad, insumo, elaboracion));
        }
        List<ConsumoMateriaPrima> consumoMateriasPrimas = new ArrayList<>();

        for (ConsumoCreateViewModel c : view.consumoInsumos) {
            IngresoMateriaPrima ingresoMateriaPrima = ingresoMateriaPrimaDao.getById(c.ingresoMateriaPrimaId);
            if (ingresoMateriaPrima == null) throw new NotFoundException("ingreso_materia_prima_not_found");
            consumoMateriasPrimas.add(new ConsumoMateriaPrima(c.cantidad, ingresoMateriaPrima, elaboracion));
        }

        elaboracion.setConsumoInsumos(consumoInsumos);
        elaboracion.setConsumoMateriasPrimas(consumoMateriasPrimas);

        checkCantidadesSuficientes(elaboracion);

        elaboracionDao.save(elaboracion);
        return mappingService.toDetalleViewModel(elaboracion);
    }


    private void checkCantidadesSuficientes(Elaboracion elaboracion) {
        Map<Long, Double> cantidadesMateriasPrimasRequeridas = new HashMap<>();
        Map<Long, Double> cantidadesInsumosRequeridas = new HashMap<>();

        Map<Long, Double> cantidadesMateriasPrimasAportadas = new HashMap<>();
        Map<Long, Double> cantidadesInsumosAportados = new HashMap<>();

        List<IngredienteReceta> ingredientes = elaboracion.getReceta().getIngredientes();
        for (IngredienteReceta ingrediente : ingredientes) {
            if (ingrediente.getMateriaPrima() != null) {
                cantidadesMateriasPrimasRequeridas.put(ingrediente.getId(), ingrediente.getCantidad() * elaboracion.getCantidad());
                cantidadesMateriasPrimasAportadas.put(ingrediente.getId(), 0D);
            } else {
                cantidadesInsumosRequeridas.put(ingrediente.getId(), ingrediente.getCantidad() * elaboracion.getCantidad());
                cantidadesInsumosAportados.put(ingrediente.getId(), 0D);
            }
        }

        for (ConsumoInsumo consumo : elaboracion.getConsumoInsumos()) {
            cantidadesInsumosAportados.merge(consumo.getElaboracion().getId(), consumo.getCantidad(), (Double::sum));
        }

        for (Map.Entry<Long, Double> req : cantidadesInsumosRequeridas.entrySet()) {
            Double aportado = cantidadesInsumosAportados.getOrDefault(req.getKey(), 0D);
            if (aportado < req.getValue()) {
                Optional<IngredienteReceta> ing = ingredientes.stream().filter(i -> (i.getInsumo() != null && Objects.equals(i.getInsumo().getId(), req.getKey()))).findFirst();
                throw new InvalidParameterException(MessageFormat.format("Cantidad de insumo: {0} insuficiente. Requerida: {1} Aportada: {2}", ing.map(i -> i.getInsumo().getNombre()), req.getValue(), aportado));
            }
        }
        for (ConsumoMateriaPrima consumo : elaboracion.getConsumoMateriasPrimas()) {
            cantidadesMateriasPrimasAportadas.merge(consumo.getElaboracion().getId(), consumo.getCantidad(), (Double::sum));
        }

        for (Map.Entry<Long, Double> req : cantidadesMateriasPrimasRequeridas.entrySet()) {
            Double aportado = cantidadesMateriasPrimasAportadas.getOrDefault(req.getKey(), 0D);
            if (aportado < req.getValue()) {
                Optional<IngredienteReceta> ing = ingredientes.stream().filter(i -> (i.getMateriaPrima() != null && Objects.equals(i.getMateriaPrima().getId(), req.getKey()))).findFirst();
                throw new InvalidParameterException(MessageFormat.format("Cantidad de materiaPrima: {0} insuficiente. Requerida: {1} Aportada: {2}", ing.map(i -> i.getMateriaPrima().getNombre()), req.getValue(), aportado));
            }
        }
    }

    @Override
    public boolean delete(Long id) {
        Elaboracion elaboracion = elaboracionDao.getById(id);
        elaboracion.setFechaBaja(new Date());
        elaboracionDao.save(elaboracion);
        return true;
    }

    @Override
    public ElaboracionDetalleViewModel update(Long recetaId, ElaboracionCreateViewModel view) {
        Elaboracion elaboracion = elaboracionDao.getById(recetaId);
        // IMPLEMENTAR
        return mappingService.toDetalleViewModel(elaboracion);
    }

}
