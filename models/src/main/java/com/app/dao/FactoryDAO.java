package com.app.dao;

import com.app.dao.implementations.*;
import com.app.dao.interfaces.*;

public class FactoryDAO {

    public static IFamiliaProductoraDao createFamiliaProductoraDao() {
        return new FamiliaProductoraDao();
    }

    public static IUsuarioDao createUsuarioDao() {
        return new UsuarioDao();
    }

    public static IPuntoVentaDao createPuntoVentaDao() {
        return new PuntoVentaDao();
    }

    public static IIngresoInsumoDao createIngresoInsumoDao() {
        return new IngresoInsumoDao();
    }

    public static IInsumoDao createInsumoDao() {
        return new InsumoDao();
    }

    public static IMateriaPrimaDao createMateriaPrimaDao() {
        return new MateriaPrimaDao();
    }

    public static IIngredienteRecetaDao createIngredienteRecetaDao() {
        return new IngredienteRecetaDao();
    }

    public static IRecetaDao createRecetaDao() {
        return new RecetaDao();
    }

    public static IElaboracionDao createElaboracionDao() {
        return new ElaboracionDao();
    }

    public static INotaDao createNotaDao() {
        return new NotaDao();
    }

    public static IIngresoMateriaPrimaDao createIngresoMateriaPrimaDao() {
        return new IngresoMateriaPrimaDao();
    }

    public static IEntregaElaboracionDao createEntregaProductoDao() {
        return new EntregaElaboracionDao();
    }

    public static IEstadoMateriaPrimaDao createEstadoMateriaPrimaDao() {
        return new EstadoMateriaPrimaDao();
    }

    public static IConsumoInsumoDao createConsumoInsumoDao() {
        return new ConsumoInsumoDao();
    }

    public static IEstadoElaboracionDao createEstadoElaboracionDao() {
        return new EstadoElaboracionDao();
    }

    public static IConsumoMateriaPrimaDao createConsumoMateriaPrimaDao() {
        return new ConsumoMateriaPrimaDao();
    }
}
