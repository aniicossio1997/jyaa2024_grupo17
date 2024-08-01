package com.app.viewModels;

import jakarta.validation.constraints.NotBlank;
import org.jvnet.hk2.annotations.Optional;

public class PuntoVentaCreateViewModel {
    @Optional
    public String descripcion;

    @NotBlank(message = "El nombre no puede estar en blanco")
    public String nombre;
}
