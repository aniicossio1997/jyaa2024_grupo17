package grupo17;

import grupo17.baseEntity.NameableBaseEntity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // o @Inheritance
@DiscriminatorColumn(name="rol")
public class Usuario extends  NameableBaseEntity {
    public String apellido;
    public String email;
    public String username;
    public String password;

    public Usuario( String nombre, String apellido, String username, String password, String email) {
        super( nombre);
        this.apellido = apellido;
        this.username = username;
        this.password = password;
        this.email = email;
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
