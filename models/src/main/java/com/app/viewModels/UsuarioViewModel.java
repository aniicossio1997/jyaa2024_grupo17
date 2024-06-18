package com.app.viewModels;

import com.app.models.enums.RolUsuario;
import com.app.viewModels.base.NameableViewModel;

public class UsuarioViewModel extends NameableViewModel {

    String apellido;
    String username;
    String email;
    RolUsuario rol;

    public UsuarioViewModel(Long id, String nombre, String apellido, RolUsuario rol, String username, String email) {
        super(id, nombre);
        this.apellido = apellido;
        this.rol = rol;
        this.username = username;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public RolUsuario getRol() {
        return rol;
    }

    public void setRol(RolUsuario rol) {
        this.rol = rol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
