package grupo17;

public class ConsumoMateriaPrima extends ConsumoRecurso {
    public IngresoMateriaPrima ingreso;
    public MateriaPrima materiaPrima;

    public ConsumoMateriaPrima() {
        super();
    }

    public ConsumoMateriaPrima(Double cantidad, MateriaPrima insumo, IngresoMateriaPrima ingreso) {
        super(cantidad);
        this.ingreso = ingreso;
    }

    public IngresoMateriaPrima getIngreso() {
        return ingreso;
    }

    public void setIngreso(IngresoMateriaPrima ingreso) {
        this.ingreso = ingreso;
    }

    public MateriaPrima getMateriaPrima() {
        return materiaPrima;
    }

    public void setMateriaPrima(MateriaPrima materiaPrima) {
        this.materiaPrima = materiaPrima;
    }
}
