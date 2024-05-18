package grupo17;

import java.time.LocalDateTime;

public class IngresoInsumo {
    protected LocalDateTime fecha;
    protected String descripcion;
    protected double cantidad;
    protected String codigo;
    protected double valorCompra;

    // Constructor
    public IngresoInsumo(LocalDateTime fecha, String descripcion, double cantidad, String codigo, double valorCompra) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.codigo = codigo;
        this.valorCompra = valorCompra;
    }
}
