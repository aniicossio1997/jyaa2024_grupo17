package com.app.viewModels;

import com.app.models.enums.RolUsuario;
import com.app.viewModels.base.NameableViewModel;

public class AuthViewModel {

    UsuarioViewModel usuario;
    String token;

    public AuthViewModel(String token, UsuarioViewModel usuario) {
        this.token = token;
        this.usuario = usuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UsuarioViewModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioViewModel usuario) {
        this.usuario = usuario;
    }
}
