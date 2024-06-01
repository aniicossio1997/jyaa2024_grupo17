package grupo17.baseEntity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class NameableBaseEntity extends IdentifiableBaseEntity {
    protected String nombre;

    public NameableBaseEntity(String nombre) {
        super();
        this.nombre = nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
