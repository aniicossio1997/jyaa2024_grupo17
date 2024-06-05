package grupo17.baseEntity;

import org.hibernate.annotations.*;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass

public class DeletableBaseEntity extends IdentifiableBaseEntity {

    protected Date fechaBaja;

    public DeletableBaseEntity(Date fechaBaja) {
        super();
        this.fechaBaja = fechaBaja;
    }

    public DeletableBaseEntity() {
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }
}
