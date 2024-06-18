package com.app.models;

import com.app.models.baseEntity.NameableBaseEntity;
import com.app.models.enums.RolUsuario;

import javax.persistence.*;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // o @Inheritance
@DiscriminatorColumn(name = "rol", discriminatorType = DiscriminatorType.STRING)
@Entity
@Table(name = "usuario")
public abstract class Usuario extends NameableBaseEntity {
    protected String apellido;
    @Column(unique = true)
    protected String email;
    @Column(unique = true)
    protected String username;
    protected String password;

    public Usuario() {
        super();
    }

    public Usuario(String nombre, String apellido, String username, String password, String email) {
        super(nombre);
        this.apellido = apellido;
        this.username = username;
        this.password = password;
        this.email = email;
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

    public abstract RolUsuario getRol();


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
