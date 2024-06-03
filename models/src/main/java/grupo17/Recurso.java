package grupo17;

import grupo17.baseEntity.NameableBaseEntity;
import grupo17.enums.UnidadMedidaEnum;

import javax.persistence.MappedSuperclass;
import java.util.ArrayList;
import java.util.List;

@MappedSuperclass
public class Recurso extends NameableBaseEntity {

    String descripcion;
    UnidadMedidaEnum unidadMedida;
    Double cantidadDisponible;

    public Recurso() {
        super();
    }

    public Recurso(Double cantidadDisponible, String descripcion, String nombre, UnidadMedidaEnum unidadMedida) {
        super(nombre);
        this.cantidadDisponible = cantidadDisponible;
        this.descripcion = descripcion;
        this.unidadMedida = unidadMedida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public UnidadMedidaEnum getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedidaEnum unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Double getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(Double cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cantidadDisponible='" + cantidadDisponible + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", unidadMedida=" + unidadMedida +

                '}';
    }
}
