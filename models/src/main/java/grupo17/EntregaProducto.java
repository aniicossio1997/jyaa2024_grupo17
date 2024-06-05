package grupo17;

import grupo17.baseEntity.DeletableBaseEntity;
import grupo17.baseEntity.IdentifiableBaseEntity;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "entrega_producto")
@SQLDelete(sql = "UPDATE nota SET fechaBaja = CURRENT_TIMESTAMP WHERE id = ?")
@Where(clause = "fechaBaja IS NULL")
public class EntregaProducto extends DeletableBaseEntity {
    private Double cantidad;
    private Date fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lote_producto_elaborado_id")
    private LoteProductoElaborado lote;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "punto_venta_id")
    private PuntoVenta puntoVenta;

    public EntregaProducto() {
    }

    public EntregaProducto(Double cantidad, LoteProductoElaborado lote, PuntoVenta puntoVenta) {
        this.cantidad = cantidad;
        this.lote = lote;
        this.fecha = new Date();
        this.puntoVenta = puntoVenta;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public LoteProductoElaborado getLote() {
        return lote;
    }

    public void setLote(LoteProductoElaborado lote) {
        this.lote = lote;
    }

    public PuntoVenta getPuntoVenta() {
        return puntoVenta;
    }

    public void setPuntoVenta(PuntoVenta puntoVenta) {
        this.puntoVenta = puntoVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "{"
                + "\"id\":\"" + id + "\""
                + ", \"cantidad\":\"" + cantidad + "\""
                + ", \"loteId\":" + lote.getId()
                + ", \"puntoVentaId\":" + puntoVenta.getId()
                + "}";
    }
}
