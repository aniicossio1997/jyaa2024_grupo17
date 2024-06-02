package grupo17;

import grupo17.enums.RolUsuario;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("ADMIN")
@Entity
public class Administrador extends Usuario {

    public Administrador( String nombre, String apellido, String username, String password, String email) {
        super( nombre, apellido, username, password, email);
    }

    @Override
    public RolUsuario getRol() {
        return RolUsuario.ADMIN;
    }
}
