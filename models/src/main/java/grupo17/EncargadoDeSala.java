package grupo17;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("ENCARGADO_SALA")
public class EncargadoDeSala  extends Usuario{

    public EncargadoDeSala( String nombre, String apellido, String username, String password, String email) {
        super( nombre, apellido, username, password, email);
    }
}
