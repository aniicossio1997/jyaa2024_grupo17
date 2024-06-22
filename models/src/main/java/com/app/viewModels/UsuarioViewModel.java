package com.app.viewModels;

import com.app.models.enums.RolUsuario;
import com.app.viewModels.base.NameableViewModel;

public class UsuarioViewModel extends NameableViewModel {

    String apellido;
    String username;
    String email;
    RolUsuario rol;
    Boolean blocked;

    public UsuarioViewModel(Long id, String nombre, String apellido, RolUsuario rol, String username, String email, boolean blocked) {
        super(id, nombre);
        this.apellido = apellido;
        this.rol = rol;
        this.username = username;
        this.email = email;
        this.blocked = blocked;
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

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
