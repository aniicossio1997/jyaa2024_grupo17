package dao;

import grupo17.FamiliaProductora;

public class FamiliaProductoraDao extends BaseDao<FamiliaProductora> implements IFamiliaProductoraDao{

	@Override
	protected Class<FamiliaProductora> getClassType() {
		 return FamiliaProductora.class;
	}

}
