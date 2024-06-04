package grupo17;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IngresoMateriaPrima  {
    public FamiliaProductora productor;
    public List<EstadoMateriaPrima> estados=new ArrayList<>();

    public IngresoMateriaPrima(Date fecha, String descripcion, double cantidad, String codigo, double valorCompra, FamiliaProductora productor) {
        this.productor = productor;

    }

    public void updateEstado(EstadoMateriaPrima estado){
        this.estados.add(estado);
    }

}
