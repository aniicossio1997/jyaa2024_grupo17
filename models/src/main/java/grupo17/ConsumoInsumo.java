package grupo17;

import javax.persistence.*;

@Entity
@Table(name = "consumo_insumo")
public class ConsumoInsumo extends ConsumoRecurso {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "insumo_id")
    private Insumo insumo;

    public ConsumoInsumo() {
        super();
    }

    public ConsumoInsumo(Double cantidad, Insumo insumo, LoteProductoElaborado lote) {
        super(cantidad);
        this.insumo = insumo;
        this.lote = lote;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public LoteProductoElaborado getLote() {
        return lote;
    }

    public void setLote(LoteProductoElaborado lote) {
        this.lote = lote;
    }

    @Override
    public String toString() {
        return "{"
                + " \"id\":\"" + id + "\""
                + ", \"insumoId\":" + insumo.getId()
                + ", \"loteId\":" + lote.getId()
                + ", \"cantidad\":\"" + cantidad + "\""
                + "}";
    }
}
