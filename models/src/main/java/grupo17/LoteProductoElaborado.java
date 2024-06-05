package grupo17;

import grupo17.baseEntity.IdentifiableBaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "lote_producto_elaborado")
public class LoteProductoElaborado extends IdentifiableBaseEntity {
    private Date fecha;
    private String codigo;
    private int cantidad;

    @OneToMany(mappedBy = "lote", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EstadoLote> estados = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receta_id")
    private Receta receta;

    @OneToMany(mappedBy = "lote", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ConsumoInsumo> consumoInsumos = new ArrayList<>();

    @OneToMany(mappedBy = "lote", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ConsumoMateriaPrima> consumoMateriasPrimas = new ArrayList<>();

    @OneToMany(mappedBy = "lote", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Nota> notas = new ArrayList<>();

    @OneToMany(mappedBy = "lote", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EntregaProducto> entregas = new ArrayList<>();

    public LoteProductoElaborado() {
        super();
    }

    public LoteProductoElaborado(int cantidad, String codigo, Date fecha, Receta receta) {
        this.cantidad = cantidad;
        this.codigo = codigo;
        this.fecha = fecha;
        this.receta = receta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<ConsumoInsumo> getConsumoInsumos() {
        return consumoInsumos;
    }

    public void setConsumoInsumos(List<ConsumoInsumo> consumos) {
        this.consumoInsumos = consumos;
    }

    public List<EntregaProducto> getEntregas() {
        return entregas;
    }

    public void setEntregas(List<EntregaProducto> entregas) {
        this.entregas = entregas;
    }

    public List<EstadoLote> getEstados() {
        return estados;
    }

    public void updateEstado(EstadoLote estado) {
        this.estados.add(estado);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    @Override
    public String toString() {
        return "{"
                + "\"id\":\"" + id + "\""
                + ", \"cantidad\":\"" + cantidad + "\""
                + ", \"fecha\":" + fecha
                + ", \"codigo\":\"" + codigo + "\""
                + ", \"estados\":" + estados
                + ", \"recetaId\":" + receta.getId()
                + ", \"consumosInsumos\":" + consumoInsumos
                + ", \"notas\":" + notas
                + ", \"entregas\":" + entregas
                + "}";
    }
}
