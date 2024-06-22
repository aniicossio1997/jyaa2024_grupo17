package com.app.models;


import com.app.models.baseEntity.DeletableBaseEntity;
import com.app.models.baseEntity.IdentifiableBaseEntity;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "ingrediente_receta")
@SQLDelete(sql = "UPDATE nota SET fechaBaja = CURRENT_TIMESTAMP WHERE id = ?")
@Where(clause = "fechaBaja IS NULL")
public class IngredienteReceta extends DeletableBaseEntity {

    private Double cantidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "insumo_id")
    private Insumo insumo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "materia_prima_id")
    private MateriaPrima materiaPrima;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receta_id")
    private Receta receta;

    public IngredienteReceta() {
        super();
    }


    public IngredienteReceta(Double cantidad, Insumo insumo, Receta receta) {
        this.cantidad = cantidad;
        this.insumo = insumo;
        this.receta = receta;
    }

    public IngredienteReceta(Double cantidad, MateriaPrima materiaPrima, Receta receta) {
        this.cantidad = cantidad;
        this.materiaPrima = materiaPrima;
        this.receta = receta;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public MateriaPrima getMateriaPrima() {
        return materiaPrima;
    }

    public void setMateriaPrima(MateriaPrima materiaPrima) {
        this.materiaPrima = materiaPrima;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    @Override
    public String toString() {
        return "{"
                + "\"id\":\"" + id + "\""
                + ", \"cantidad\":\"" + cantidad + "\""
                + ", \"insumoId\":" + (insumo != null ? insumo.getId() : null)
                + ", \"materiaPrimaId\":" + (materiaPrima != null ? materiaPrima.getId() : null)
                + "}";
    }
}
