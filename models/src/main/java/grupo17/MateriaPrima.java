package grupo17;

import grupo17.enums.UnidadMedidaEnum;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "materia_prima")
public class MateriaPrima extends Recurso {
    @Transient
    public List<IngresoMateriaPrima> ingresos = new ArrayList<>();

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
