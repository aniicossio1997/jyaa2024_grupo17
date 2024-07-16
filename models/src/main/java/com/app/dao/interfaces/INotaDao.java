package com.app.dao.interfaces;


import com.app.models.Nota;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;
@Contract
public interface INotaDao extends IBasicDao<Nota> {

    List<Nota> getByElaboracion(Long elaboracionId);
}
