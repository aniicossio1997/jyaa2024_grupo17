package grupo17;

import java.util.Date;

public class Nota {
    public Date fecha;
    public EncargadoDeSala autor;
    public String descripcion;

    public Nota(EncargadoDeSala autor, String descripcion) {
        this.autor = autor;
        this.fecha = new Date();
        this.descripcion = descripcion;
    }
}
