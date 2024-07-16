package com.app.viewModels;


import com.app.models.EstadoElaboracion;
import com.app.viewModels.base.IdentifiableViewModel;

import java.util.Date;
import java.util.List;

public class ElaboracionCreateViewModel extends IdentifiableViewModel {
    public Date fecha;
    public Long cantidad;
    public EstadoElaboracion estado;
    public Long recetaId;
    public List<ConsumoCreateViewModel> consumoInsumos;
    public List<ConsumoCreateViewModel> consumoMateriasPrimas;

}

