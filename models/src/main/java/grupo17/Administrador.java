package grupo17;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("ADMIN")
public class Administrador extends Usuario {

    public Administrador( String nombre, String apellido, String username, String password, String email) {
        super( nombre, apellido, username, password, email);
    }
}
