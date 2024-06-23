package com.app.models.baseEntity;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public class DeletableWithNameBaseEntity  extends  NameableBaseEntity {
    protected Date fechaBaja;

    public DeletableWithNameBaseEntity() {
        super();
    }

    public DeletableWithNameBaseEntity(String nombre) {
        super(nombre);
    }

    public DeletableWithNameBaseEntity(String nombre, Date fechaBaja) {
        super(nombre);
        this.fechaBaja = fechaBaja;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }
}
