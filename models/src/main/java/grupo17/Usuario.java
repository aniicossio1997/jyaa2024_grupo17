package grupo17;

import grupo17.baseEntity.NameableBaseEntity;
import grupo17.enums.RolUsuario;

import javax.persistence.*;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // o @Inheritance
@DiscriminatorColumn(name = "rol", discriminatorType = DiscriminatorType.STRING)
@Entity
@Table(name = "usuario")
public abstract class Usuario extends NameableBaseEntity {
    public String apellido;
    public String email;
    public String username;
    public String password;

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
        return "Usuario{" +
                " nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", rol='" + getRol().getValue() + '\'' +
                ", id=" + id +
                '}';
    }
}
