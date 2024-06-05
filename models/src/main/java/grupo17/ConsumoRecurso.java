package grupo17;

import grupo17.baseEntity.IdentifiableBaseEntity;

import javax.persistence.*;

@MappedSuperclass
public abstract class ConsumoRecurso extends IdentifiableBaseEntity {
    protected Double cantidad;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lote_producto_elaborado_id")
    protected LoteProductoElaborado lote;

    public ConsumoRecurso() {
        super();
    }

    public ConsumoRecurso(Double cantidad) {
        this.cantidad = cantidad;
    }
}
