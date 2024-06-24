package com.app.services;

import com.app.models.enums.EstadoMateriaPrimaEnum;
import com.app.services.interfaces.IEstadoIngresoMateriaPrimaTypesService;
import org.glassfish.hk2.api.PerLookup;
import org.jvnet.hk2.annotations.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@PerLookup
public class EstadoIngresoMateriaPrimaTypesService implements IEstadoIngresoMateriaPrimaTypesService {
    @Override
    public List<String> getAll() {
        List<String> enumValues = Arrays.stream(EstadoMateriaPrimaEnum.values())
                .map(EstadoMateriaPrimaEnum::getValue)
                .collect(Collectors.toList());
        return  enumValues;
    }
}
