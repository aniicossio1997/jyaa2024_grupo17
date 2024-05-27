package grupo17;

import java.util.List;

public class ConsumoMateriaPrima extends ConsumoInsumo {
    public IngresoMateriaPrima ingreso;
    public MateriaPrima insumo;

    public ConsumoMateriaPrima(Double cantidad, MateriaPrima insumo, IngresoMateriaPrima ingreso) {
        super(cantidad, insumo);
        this.ingreso = ingreso;
    }

}
