package grupo17;

import grupo17.baseEntity.NameableBaseEntity;

public class Usuario  {
    public String nombre;
    public String apellido;
    public String email;
    public String username;
    public String password;

    public Usuario(String apellido, String email, Long id, String nombre, String password, String username) {
        this.apellido = apellido;
        this.email = email;
        this.nombre = nombre;
        this.password = password;
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public String getApellido() {
        return apellido;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }


}
