package grupo17;

import java.util.ArrayList;
import java.util.List;

public class PuntoVenta {
    public String descripcion;
    public String nombre;
    public List<EntregaProducto> recepciones=new ArrayList<>();

    public PuntoVenta(String descripcion, String nombre) {
        this.descripcion = descripcion;
        this.nombre = nombre;
    }
    public void  addRecepcion(EntregaProducto entrega){
        this.recepciones.add(entrega);
    }

}
