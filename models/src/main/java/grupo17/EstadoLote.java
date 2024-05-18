package grupo17;

import grupo17.enums.EstadoLoteEnum;
import grupo17.enums.EstadoMateriaPrimaEnum;

import java.time.LocalDateTime;
import java.util.Date;

public class EstadoLote  extends EstadoBase{
    public EstadoLoteEnum estado;

    public EstadoLote(Usuario autor, Date fecha, EstadoLoteEnum estado) {
        super(autor, fecha);
        this.estado = estado;
    }
}
