package grupo17;

import grupo17.enums.UnidadMedidaEnum;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "insumo")
public class Insumo extends Recurso {
    @Transient
    public List<IngresoInsumo> ingresos = new ArrayList<>();

    public Insumo() {
        super();
    }

    public Insumo(String nombre,Double cantidadDisponible, String descripcion,  UnidadMedidaEnum unidadMedida) {
        super(cantidadDisponible, descripcion, nombre, unidadMedida);
    }

    public List<IngresoInsumo> getIngresos() {
        return ingresos;
    }

    public void setIngresos(List<IngresoInsumo> ingresos) {
        this.ingresos = ingresos;
    }

    @Override
    public String toString() {
        return "Insumo" + super.toString();
    }
}
