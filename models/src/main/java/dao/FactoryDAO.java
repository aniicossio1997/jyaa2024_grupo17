package dao;

import dao.implementations.FamiliaProductoraDao;
import dao.implementations.IngresoInsumoDao;
import dao.implementations.PuntoVentaDao;
import dao.implementations.UsuarioDao;
import dao.interfaces.IFamiliaProductoraDao;
import dao.interfaces.IIngresoInsumoDao;
import dao.interfaces.IPuntoVentaDao;
import dao.implementations.InsumoDao;
import dao.interfaces.IInsumoDao;
import dao.interfaces.IUsuarioDao;

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
}
