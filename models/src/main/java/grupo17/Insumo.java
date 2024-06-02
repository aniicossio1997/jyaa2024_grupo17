package grupo17;

import grupo17.enums.UnidadMedidaEnum;

import java.util.ArrayList;
import java.util.List;

public class Insumo extends Recurso {
    public List<IngresoInsumo> ingresos = new ArrayList<>();

    public Insumo() {
        super();
    }

    public Insumo(Double cantidadDisponible, String descripcion, String nombre, UnidadMedidaEnum unidadMedida) {
        super(cantidadDisponible, descripcion, nombre, unidadMedida);
    }

    public List<IngresoInsumo> getIngresos() {
        return ingresos;
    }

    public void setIngresos(List<IngresoInsumo> ingresos) {
        this.ingresos = ingresos;
    }
}
