package dao;

import dao.implementations.FamiliaProductoraDao;
import dao.implementations.UsuarioDao;
import dao.interfaces.IFamiliaProductoraDao;
import dao.interfaces.IUsuarioDao;

public class FactoryDAO {
	
	
	 public static IFamiliaProductoraDao createFamiliaProductoraDao() {
	        return new FamiliaProductoraDao();
	 }

	public static IUsuarioDao createUsuarioDao() {
		return new UsuarioDao();
	}

}
