package com.app.dao.interfaces;

import com.app.models.PuntoVenta;
import com.app.models.Usuario;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;
@Contract
public interface IPuntoVentaDao {

    void save(PuntoVenta puntoVenta);

    PuntoVenta getById(Long id);

    List<PuntoVenta> getAll();

    /* void delete(Long id); */

}
