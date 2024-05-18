package grupo17.baseEntity;

public class NameableBaseEntity  extends IdentifiableBaseEntity {
    protected String nombre;

    public String getNombre() {
        return nombre;
    }

    public NameableBaseEntity(Long id, String nombre) {
        super(id);
        this.nombre = nombre;
    }
}
