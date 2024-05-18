package grupo17;

import grupo17.enums.UnidadMedidaEnum;

import java.util.ArrayList;
import java.util.List;

public class MateriaPrima extends Insumo {
    public List<IngresoMateriaPrima> ingresos = new ArrayList<>();

    public MateriaPrima(Double cantidadDisponible, String descripcion, String nombre, UnidadMedidaEnum unidadMedida) {
        super(cantidadDisponible, descripcion, nombre, unidadMedida);
    }

    public void addIngreso(IngresoMateriaPrima ingresoMateriaPrima) {
        this.ingresos.add(ingresoMateriaPrima);
    }

}
