package com.app.viewModels;


import com.app.models.enums.EstadoElaboracionEnum;
import com.app.viewModels.base.IdentifiableViewModel;

import java.util.Date;
import java.util.List;

public class ElaboracionCreateViewModel extends IdentifiableViewModel {
    public Date fecha;
    public Long cantidad;
    public EstadoElaboracionEnum estado;
    public Long recetaId;
    public String nota;
    public List<ConsumoCreateViewModel> consumoMateriasPrimas;

}

