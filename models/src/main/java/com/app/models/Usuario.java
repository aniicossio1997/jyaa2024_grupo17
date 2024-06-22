package com.app.models;

import com.app.models.baseEntity.NameableBaseEntity;
import com.app.models.enums.RolUsuario;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario extends NameableBaseEntity {
    protected String apellido;
    @Column(unique = true)
    protected String email;
    @Column(unique = true)
    protected String username;
    protected String password;
    protected RolUsuario rol;
    protected boolean blocked = false;

    public Usuario() {
        super();
    }

    public Usuario(String nombre, String apellido, String username, String password, String email, RolUsuario rol) {
        super(nombre);
        this.apellido = apellido;
        this.username = username;
        this.password = password;
        this.email = email;
        this.rol = rol;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RolUsuario getRol() {
        return rol;
    }

    public void setRol(RolUsuario rol) {
        this.rol = rol;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    @Override
    public String toString() {
        return "{"
                + "\"id\":\"" + id + "\""
                + ", \"apellido\":\"" + apellido + "\""
                + ", \"email\":\"" + email + "\""
                + ", \"password\":\"" + password + "\""
                + ", \"username\":\"" + username + "\""
                + ", \"nombre\":\"" + nombre + "\""
                + "}";
    }
}
