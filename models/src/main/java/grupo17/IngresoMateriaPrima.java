package grupo17;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class IngresoMateriaPrima  extends IngresoInsumo {
    public FamiliaProductora productor;
    public List<EstadoMateriaPrima> estados=new ArrayList<>();

    public IngresoMateriaPrima(LocalDateTime fecha, String descripcion, double cantidad, String codigo, double valorCompra, FamiliaProductora productor) {
        super(fecha, descripcion, cantidad, codigo, valorCompra);
        this.productor = productor;

    }

    public void updateEstado(EstadoMateriaPrima estado){
        this.estados.add(estado);
    }

}
