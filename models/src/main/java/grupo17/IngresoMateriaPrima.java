package grupo17;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ingreso_materia_prima")
public class IngresoMateriaPrima extends IngresoBase {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "familia_productora_id")
    private FamiliaProductora familiaProductora;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "materia_prima_id")
    private MateriaPrima materiaPrima;

    @OneToMany(mappedBy = "ingresoMateriaPrima", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    public List<EstadoMateriaPrima> estados=new ArrayList<>();

    @Column(name = "is_deleted")
    private boolean isDeleted;

    public  IngresoMateriaPrima(){
        super();
    }
    public IngresoMateriaPrima(double cantidad, String codigo, String descripcion, Date fecha, double valorCompra, List<EstadoMateriaPrima> estados, MateriaPrima materiaPrima, FamiliaProductora productor) {
        super(cantidad, codigo, descripcion, fecha, valorCompra);
        this.estados = estados;
        this.materiaPrima = materiaPrima;
        this.familiaProductora = productor;
        this.isDeleted=false;
    }

    public IngresoMateriaPrima(double cantidad, String codigo, String descripcion, Date fecha, double valorCompra,
                                MateriaPrima materiaPrima, FamiliaProductora productor) {
        super(cantidad, codigo, descripcion, fecha, valorCompra);
        this.materiaPrima = materiaPrima;
        this.familiaProductora = productor;
        this.isDeleted=false;
    }


    public void updateEstado(EstadoMateriaPrima estado){
        this.estados.add(estado);
    }

    public IngresoMateriaPrima(MateriaPrima materiaPrima, List<EstadoMateriaPrima> estados, FamiliaProductora productor) {
        super();
        this.materiaPrima = materiaPrima;
        this.estados = estados;
        this.familiaProductora = productor;
    }

    public List<EstadoMateriaPrima> getEstados() {
        return estados;
    }

    public void setEstados(List<EstadoMateriaPrima> estados) {
        this.estados = estados;
    }

    public FamiliaProductora getProductor() {
        return this.familiaProductora;
    }

    public void setProductor(FamiliaProductora productor) {
        this.familiaProductora = productor;
    }

    public MateriaPrima getMateriaPrima() {
        return materiaPrima;
    }

    public void setMateriaPrima(MateriaPrima materiaPrima) {
        this.materiaPrima = materiaPrima;
    }
    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "IngresoMateriaPrima{" +
                "estados=" + estados.toString() +
                ", familiaProductora=" + familiaProductora.getId() +
                ", materiaPrima=" + materiaPrima.getId() +
                ", isDeleted=" + isDeleted +
                ", cantidad=" + cantidad +
                ", codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fecha=" + fecha +
                ", valorCompra=" + valorCompra +

                '}';
    }
}
