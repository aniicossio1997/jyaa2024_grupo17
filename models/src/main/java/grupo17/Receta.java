package grupo17;

import grupo17.baseEntity.IdentifiableBaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "receta")
public class Receta extends IdentifiableBaseEntity {
    public String nombre;
    public String descripcion;

    @OneToMany(mappedBy = "ingrediente", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<IngredienteReceta> ingredientes = new ArrayList<IngredienteReceta>();

    @Transient
    public List<LoteProductoElaborado> elaboraciones = new ArrayList<LoteProductoElaborado>();

    public Receta() {
        super();
    }

    public Receta(String nombre, List<IngredienteReceta> ingredientes, String descripcion) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<LoteProductoElaborado> getElaboraciones() {
        return elaboraciones;
    }

    public void setElaboraciones(List<LoteProductoElaborado> elaboraciones) {
        this.elaboraciones = elaboraciones;
    }

    public List<IngredienteReceta> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngredienteReceta> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
