package com.app.services;

import com.app.models.enums.EstadoElaboracionEnum;
import com.app.models.enums.EstadoMateriaPrimaEnum;
import com.app.models.enums.RolUsuario;
import com.app.models.enums.UnidadMedidaEnum;
import com.app.services.interfaces.IInfoTypesService;
import org.glassfish.hk2.api.PerLookup;
import org.jvnet.hk2.annotations.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@PerLookup
public class InfoTypesService implements IInfoTypesService {

    @Override
    public List<String> getAllUnidadMedida() {
        List<String> enumValues = Arrays.stream(UnidadMedidaEnum.values())
                .map(UnidadMedidaEnum::getValue)
                .collect(Collectors.toList());
        return  enumValues;
    }

    @Override
    public List<String> getAllRoles() {
        List<String> enumValues = Arrays.stream(RolUsuario.values())
                .map(RolUsuario::getValue)
                .collect(Collectors.toList());
        return  enumValues;
    }

    @Override
    public List<String> getAllEstadoMateriaPrima() {
        List<String> enumValues = Arrays.stream(EstadoMateriaPrimaEnum.values())
                .map(EstadoMateriaPrimaEnum::getValue)
                .collect(Collectors.toList());
        return  enumValues;
    }

    @Override
    public List<String> getAllEstadoElaboracion() {
        List<String> enumValues = Arrays.stream(EstadoElaboracionEnum.values())
                .map(EstadoElaboracionEnum::getValue)
                .collect(Collectors.toList());
        return  enumValues;
    }
}
