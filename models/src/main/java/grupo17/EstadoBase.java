package grupo17;

import grupo17.baseEntity.IdentifiableBaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@MappedSuperclass
public abstract class EstadoBase extends IdentifiableBaseEntity {
    protected Date fecha;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    protected Usuario autor;


    protected EstadoBase() {
        super();
    }

    public EstadoBase(Usuario autor, Date fecha) {
        this.autor = autor;
        this.fecha = fecha;
    }

    public EstadoBase(Usuario autor) {
        this.autor = autor;
        this.fecha = new Date();
    }
}
