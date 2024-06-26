package com.app.services.interfaces;

import org.jvnet.hk2.annotations.Contract;

import java.util.List;

@Contract
public interface IEstadoIngresoMateriaPrimaTypesService {
    List<String> getAll();
}
