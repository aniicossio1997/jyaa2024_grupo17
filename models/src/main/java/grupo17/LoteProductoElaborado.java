package grupo17;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoteProductoElaborado {
    public Date fecha;
    public String codigo;
    public int cantidad;
    public List<EstadoLote>estados=new ArrayList<>();
    public Receta receta;
    public  List<ConsumoRecurso> consumos=new ArrayList<ConsumoRecurso>();
    public  List<Nota> notas=new ArrayList<Nota>();
    public  List<EntregaProducto> entregas=new ArrayList<EntregaProducto>();

}
