package grupo17;

public class ConsumoInsumo extends ConsumoRecurso {
    public Insumo insumo;

    public ConsumoInsumo() {
        super();
    }

    public ConsumoInsumo(Double cantidad, Insumo insumo) {
        super(cantidad);
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }
}
