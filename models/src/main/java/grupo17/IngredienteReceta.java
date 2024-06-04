package grupo17;


import grupo17.baseEntity.IdentifiableBaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "ingrediente_receta")
public class IngredienteReceta extends IdentifiableBaseEntity {

    public Double cantidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "insumo_id")
    public Insumo insumo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "materia_prima_id")
    public MateriaPrima materiaPrima;

    @ManyToOne()
    @JoinColumn(name = "receta_id")
    private Receta receta;

    public IngredienteReceta() {
        super();
    }

    public IngredienteReceta(Double cantidad, Insumo insumo) {
        this.cantidad = cantidad;
        this.insumo = insumo;
    }

    public IngredienteReceta(Double cantidad, MateriaPrima materiaPrima) {
        this.cantidad = cantidad;
        this.materiaPrima = materiaPrima;
    }

    @Override
    public String toString() {
        return "{"
                + "\"id\":\"" + id + "\""
                + ", \"cantidad\":\"" + cantidad + "\""
                + ", \"insumo\":" + insumo
                + ", \"materiaPrima\":" + materiaPrima
                + ", \"receta\":" + receta
                + "}";
    }
}
