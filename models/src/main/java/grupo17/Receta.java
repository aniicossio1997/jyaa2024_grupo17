package grupo17;

import java.util.ArrayList;
import java.util.List;

public class Receta {
    public String nombre;
    public  String descripcion;
    public List<IngredienteReceta> ingredientes=new ArrayList<IngredienteReceta>();
    public List<LoteProductoElaborado> elaboraciones=new ArrayList<LoteProductoElaborado>();

    public Receta(String nombre, List<IngredienteReceta> ingredientes, String descripcion) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.descripcion = descripcion;
    }

    public void addIngrediente(IngredienteReceta ingrediente ){
        this.ingredientes.add(ingrediente);
    }
    public void addElaboracion(LoteProductoElaborado elaborado ){
        this.elaboraciones.add(elaborado);
    }

    public void removeIngrediente(IngredienteReceta ingrediente ){
        this.ingredientes.remove(ingrediente);
    }
}
