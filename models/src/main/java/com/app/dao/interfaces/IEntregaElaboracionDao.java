package com.app.dao.interfaces;

import com.app.models.EntregaElaboracion;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;
@Contract
public interface IEntregaElaboracionDao extends IBasicDao<EntregaElaboracion> {
    List<EntregaElaboracion> getByElaboracion(Long elaboracionId);

    List<EntregaElaboracion> getByPuntoVenta(Long puntoVentaId);
}
