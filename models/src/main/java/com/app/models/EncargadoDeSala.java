package com.app.models;

import com.app.models.enums.RolUsuario;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("ENCARGADO_SALA")
@Entity
public class EncargadoDeSala extends Usuario {


    public EncargadoDeSala() {
    }

    public EncargadoDeSala(String nombre, String apellido, String username, String password, String email) {
        super(nombre, apellido, username, password, email);
    }

    @Override
    public RolUsuario getRol() {
        return RolUsuario.ENCARGADO_SALA;
    }
}
