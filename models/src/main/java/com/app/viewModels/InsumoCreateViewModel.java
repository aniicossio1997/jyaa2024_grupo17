package com.app.viewModels;

import com.app.models.enums.UnidadMedidaEnum;

public class InsumoCreateViewModel  extends  RecursoPostViewModel{
    public InsumoCreateViewModel(Double cantidadDisponible, String descripcion, String nombre, UnidadMedidaEnum unidadMedida) {
        super(cantidadDisponible, descripcion, nombre, unidadMedida);
    }

    public InsumoCreateViewModel() {
        super();
    }
}
