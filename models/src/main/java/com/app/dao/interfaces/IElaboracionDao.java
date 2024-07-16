package com.app.dao.interfaces;

import com.app.models.Elaboracion;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;
@Contract
public interface IElaboracionDao extends IBasicDao<Elaboracion> {

    List<Elaboracion> getByRecetaId(Long recetaId);
}
