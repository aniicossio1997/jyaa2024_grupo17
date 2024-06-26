package com.app.services.interfaces;

import org.jvnet.hk2.annotations.Contract;

import java.util.List;

@Contract
public interface IInfoTypesService {
    List<String> getAllUnidadMedida();
    List<String> getAllRoles();
    List<String> getAllEstadoMateriaPrima();
    List<String> getAllEstadoLote();

}
