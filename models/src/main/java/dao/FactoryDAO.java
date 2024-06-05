package dao;

import dao.implementations.*;
import dao.interfaces.*;
import grupo17.EstadoMateriaPrima;

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

    public static ILoteProductoElaboradoDao createLoteProductoElaboradoDao() {
        return new LoteProductoElaboradoDao();
    }

    public static INotaDao createNotaDao() {
        return new NotaDao();
    }

	public static  IIngresoMateriaPrimaDao createIngresoMateriaPrimaDao(){ return  new IngresoMateriaPrimaDao();}




}
