package grupo17;


import javax.persistence.*;

@Entity
@Table(name = "ingrediente_receta")
public class IngredienteReceta {

    public Double cantidad;
    @ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn(name = "insumo_id")
    public Insumo insumo;
    @JoinColumn(name = "materia_prima_id")
    public MateriaPrima materiaPrima;

    public IngredienteReceta(Double cantidad, Insumo insumo, MateriaPrima materiaPrima) {
        this.cantidad = cantidad;
        this.insumo = insumo;
        this.materiaPrima = materiaPrima;
    }
}
