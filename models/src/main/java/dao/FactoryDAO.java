package dao;

public class FactoryDAO {
	
	
	 public static IFamiliaProductoraDao createFamiliaProductoraDao() {
	        return new FamiliaProductoraDao();
	 }

}
