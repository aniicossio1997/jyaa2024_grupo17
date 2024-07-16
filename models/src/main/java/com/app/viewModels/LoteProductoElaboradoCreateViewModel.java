package com.app.viewModels;


import com.app.models.EstadoLote;
import com.app.viewModels.base.IdentifiableViewModel;

import java.util.Date;
import java.util.List;

public class LoteProductoElaboradoCreateViewModel extends IdentifiableViewModel {
    public Date fecha;
    public Long cantidad;
    public EstadoLote estado;
    public Long recetaId;
    public List<ConsumoCreateViewModel> consumoInsumos;
    public List<ConsumoCreateViewModel> consumoMateriasPrimas;

}

