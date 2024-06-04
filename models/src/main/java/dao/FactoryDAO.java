package dao;

import dao.implementations.*;
import dao.interfaces.*;

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
	public static IInsumoDao createInsumoDao(){return  new InsumoDao();}

	public  static IMateriaPrimaDao createMateriaPrimaDao(){return new MateriaPrimaDao();}
}
