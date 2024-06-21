package com.app.dao.implementations;

import com.app.dao.BaseDao;
import com.app.dao.interfaces.IInsumoDao;
import com.app.models.Insumo;
import org.jvnet.hk2.annotations.Service;

@Service
public class InsumoDao  extends BaseDao<Insumo> implements IInsumoDao {

}
