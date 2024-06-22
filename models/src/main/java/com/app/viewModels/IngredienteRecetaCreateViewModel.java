package com.app.viewModels;

import com.app.viewModels.base.IdentifiableViewModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngredienteRecetaCreateViewModel extends IdentifiableViewModel {
    Double cantidad;
    Long insumoId;
    Long materiaPrimaId;
    Long recetaId;

    public IngredienteRecetaCreateViewModel() {
        super();
    }

    public IngredienteRecetaCreateViewModel(Long id) {
        super(id);
    }
}
