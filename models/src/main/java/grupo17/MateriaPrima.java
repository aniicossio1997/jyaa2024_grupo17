package grupo17;

import grupo17.enums.UnidadMedidaEnum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "materia_prima")
public class MateriaPrima extends Recurso {
    @OneToMany(mappedBy = "materiaPrima", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<IngresoMateriaPrima> ingresos = new ArrayList<>();


    public MateriaPrima(String nombre, UnidadMedidaEnum unidadMedida,
                        Double cantidadDisponible, String descripcion,
                        List<IngresoMateriaPrima> ingresos) {
        super(cantidadDisponible, descripcion, nombre, unidadMedida);
        this.ingresos = ingresos;
    }

    public  MateriaPrima(){
        super();
    }
    public MateriaPrima(
             String nombre, String descripcion,UnidadMedidaEnum unidadMedida,
            Double cantidadDisponible) {
        super(cantidadDisponible, descripcion, nombre, unidadMedida);
    }

    public void addIngreso(IngresoMateriaPrima ingresoMateriaPrima) {
        this.ingresos.add(ingresoMateriaPrima);
    }

    @Override
    public String toString() {
        return "Materia Prima" + super.toString();
    }
}
