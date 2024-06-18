package com.app.dao.interfaces;

import com.app.models.PuntoVenta;
import com.app.models.Usuario;

import java.util.List;

public interface IPuntoVentaDao {

    void save(PuntoVenta puntoVenta);

    PuntoVenta getById(Long id);

    List<PuntoVenta> getAll();

    /* void delete(Long id); */

}
