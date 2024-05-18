package grupo17;

import grupo17.enums.EstadoMateriaPrimaEnum;

import java.time.LocalDateTime;
import java.util.Date;

public class EstadoMateriaPrima  extends EstadoBase{
    public  EstadoMateriaPrimaEnum estado;

    public EstadoMateriaPrima(Usuario autor, Date fecha, EstadoMateriaPrimaEnum estado) {
        super(autor, fecha);
        this.estado = estado;
    }

}
