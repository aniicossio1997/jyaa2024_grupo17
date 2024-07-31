package com.app.services;

import com.app.dao.interfaces.*;
import com.app.exceptions.InvalidParameterException;
import com.app.models.*;
import com.app.models.enums.EstadoElaboracionEnum;
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
        Usuario autor = usuarioDao.getById(1L);
        Receta receta = recetaDao.getById(view.recetaId);
        Elaboracion elaboracion = new Elaboracion(view.cantidad.intValue(), "", new Date(), receta);


        List<ConsumoInsumo> consumoInsumos = new ArrayList<>();

        List<ConsumoMateriaPrima> consumoMateriasPrimas = new ArrayList<>();

        for (ConsumoCreateViewModel c : view.consumoMateriasPrimas) {
            IngresoMateriaPrima ingresoMateriaPrima = ingresoMateriaPrimaDao.getById(c.ingresoMateriaPrimaId);
            if (ingresoMateriaPrima == null) throw new NotFoundException("ingreso_materia_prima_not_found");
            consumoMateriasPrimas.add(new ConsumoMateriaPrima(c.cantidad, ingresoMateriaPrima, elaboracion));
        }

        for (IngredienteReceta ingrediente : receta.getIngredientes()) {
            if (ingrediente.getInsumo() == null) continue;
            ConsumoInsumo consumo = new ConsumoInsumo(ingrediente.getCantidad(), ingrediente.getInsumo(), elaboracion);
            consumoInsumos.add(consumo);
        }
        elaboracion.setConsumoInsumos(consumoInsumos);
        elaboracion.setConsumoMateriasPrimas(consumoMateriasPrimas);

        EstadoElaboracion estado = new EstadoElaboracion(autor, elaboracion.getFecha(), view.estado, elaboracion);
        elaboracion.getEstados().add(estado);
        checkCantidadesSuficientes(elaboracion);

        if (!view.nota.isEmpty()) {
            Nota nota = new Nota(autor, view.nota, elaboracion);
            elaboracion.getNotas().add(nota);
        }

        elaboracionDao.save(elaboracion);

        elaboracion.setCodigo("e-" + elaboracion.getId());
        elaboracionDao.save(elaboracion);

        return mappingService.toDetalleViewModel(elaboracion);
    }


    private void checkCantidadesSuficientes(Elaboracion elaboracion) {
        Map<Long, Double> cantidadesMateriasPrimasRequeridas = new HashMap<>();

        Map<Long, Double> cantidadesMateriasPrimasAportadas = new HashMap<>();

        List<IngredienteReceta> ingredientes = elaboracion.getReceta().getIngredientes();
        for (IngredienteReceta ingrediente : ingredientes) {
            if (ingrediente.getMateriaPrima() != null) {
                cantidadesMateriasPrimasRequeridas.put(ingrediente.getMateriaPrima().getId(), ingrediente.getCantidad() * elaboracion.getCantidad());
                cantidadesMateriasPrimasAportadas.put(ingrediente.getMateriaPrima().getId(), 0D);
            }
            if (ingrediente.getInsumo() != null) {
                if (ingrediente.getInsumo().getCantidadDisponible() < ingrediente.getCantidad()) {
                    throw new InvalidParameterException(MessageFormat.format("Cantidad de insumo: {0} insuficiente. Requerido: {1} Disponible: {2}", ingrediente.getInsumo().getNombre(), ingrediente.getCantidad(), ingrediente.getInsumo().getCantidadDisponible()));
                }
            }
        }

        for (ConsumoMateriaPrima consumo : elaboracion.getConsumoMateriasPrimas()) {
            cantidadesMateriasPrimasAportadas.merge(consumo.getMateriaPrima().getId(), consumo.getCantidad(), (Double::sum));
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
