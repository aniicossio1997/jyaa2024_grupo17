package grupo17;

import grupo17.baseEntity.DeletableBaseEntity;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "nota")
@SQLDelete(sql = "UPDATE nota SET fechaBaja = CURRENT_TIMESTAMP WHERE id = ?")
@Where(clause = "fechaBaja IS NULL")
public class Nota extends DeletableBaseEntity {
    private Date fecha;

    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "insumo_id")
    private EncargadoDeSala autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lote_producto_elaborado_id")
    private LoteProductoElaborado lote;

    public Nota() {
        super();
    }

    public Nota(EncargadoDeSala autor, String descripcion, LoteProductoElaborado lote) {
        this.autor = autor;
        this.fecha = new Date();
        this.lote = lote;
        this.descripcion = descripcion;
    }

    public EncargadoDeSala getAutor() {
        return autor;
    }

    public void setAutor(EncargadoDeSala autor) {
        this.autor = autor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
                + ", \"autorId\":" + autor.getId()
                + ", \"fecha\":" + fecha
                + ", \"descripcion\":\"" + descripcion + "\""
                + ", \"loteId\":" + lote.getId()
                + "}";
    }
}
