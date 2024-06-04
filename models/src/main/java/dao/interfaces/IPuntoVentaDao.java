package dao.interfaces;

import grupo17.PuntoVenta;
import grupo17.Usuario;

import java.util.List;

public interface IPuntoVentaDao {

    void save(PuntoVenta puntoVenta);

    PuntoVenta getById(Long id);

    List<PuntoVenta> getAll();

    /* void delete(Long id); */

}
