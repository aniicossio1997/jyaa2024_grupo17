package com.app.dao.interfaces;

import com.app.models.EstadoElaboracion;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;
@Contract
public interface IEstadoElaboracionDao extends IBasicDao<EstadoElaboracion> {

    List<EstadoElaboracion> getByElaboracion(Long elaboracionId);
}
