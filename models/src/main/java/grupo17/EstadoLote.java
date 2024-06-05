package grupo17;

import grupo17.enums.EstadoLoteEnum;
import grupo17.enums.EstadoMateriaPrimaEnum;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "estado_lote")
public class EstadoLote extends EstadoBase {
    private EstadoLoteEnum estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lote_producto_elaborado_id")
    private LoteProductoElaborado lote;


    public EstadoLote() {
        super();
    }

    public EstadoLote(Usuario autor, Date fecha, EstadoLoteEnum estado, LoteProductoElaborado lote) {
        super(autor, fecha);
        this.estado = estado;
        this.lote = lote;
    }

    public EstadoLoteEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoLoteEnum estado) {
        this.estado = estado;
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
                + ", \"id\":\"" + id + "\""
                + "\"estado\":\"" + estado.getValue() + "\""
                + ", \"autorId\":" + autor.getId()
                + ", \"loteId\":" + lote.getId()
                + ", \"fecha\":" + fecha
                + "}";
    }
}
