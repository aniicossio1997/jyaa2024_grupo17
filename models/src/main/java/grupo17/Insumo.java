package grupo17;

import grupo17.enums.UnidadMedidaEnum;

import java.util.ArrayList;
import java.util.List;

public class Insumo {
    String nombre;
    String descripcion;
    UnidadMedidaEnum unidadMedida;
    Double cantidadDisponible;

    public List<IngresoInsumo> ingresos = new ArrayList<>();

    public Insumo(Double cantidadDisponible, String descripcion, String nombre, UnidadMedidaEnum unidadMedida) {
        this.cantidadDisponible = cantidadDisponible;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
    }

    public void addIngreso(IngresoInsumo ingreso){
        this.ingresos.add(ingreso);
    }

}
