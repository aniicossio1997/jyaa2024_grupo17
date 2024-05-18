package grupo17;

import java.time.LocalDateTime;
import java.util.Date;

public class EstadoBase {
    public Date fecha;
    public Usuario autor;

    public EstadoBase(Usuario autor, Date fecha) {
        this.autor = autor;
        this.fecha = fecha;
    }
    public EstadoBase(Usuario autor) {
        this.autor = autor;
        this.fecha = new Date();
    }
}
