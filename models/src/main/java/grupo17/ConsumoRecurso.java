package grupo17;

import grupo17.baseEntity.IdentifiableBaseEntity;

public class ConsumoRecurso extends IdentifiableBaseEntity {
    protected Double cantidad;

    public ConsumoRecurso() {
        super();
    }

    public ConsumoRecurso(Double cantidad) {
        this.cantidad = cantidad;
    }
}
