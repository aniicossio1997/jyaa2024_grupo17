package testsServlets;

import dao.FactoryDAO;
import dao.interfaces.IPuntoVentaDao;
import grupo17.PuntoVenta;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TestPuntoVenta extends BaseTest {

    public static void test(PrintWriter writer) {

        IPuntoVentaDao puntoVentaDao = FactoryDAO.createPuntoVentaDao();

        h1(writer, "Punto de Venta");

        PuntoVenta pv = new PuntoVenta("Punto 1", "Descripcion Punto 1", new ArrayList<>());
        List<PuntoVenta> pvs;

        // CREATE
        h2(writer, "↳ Se creara un nuevo Punto de Venta: ");
        puntoVentaDao.save(pv);

        item(writer, pv);

        // LIST
        h2(writer, "Listado de Puntos de Venta: ");
        pvs = puntoVentaDao.getAll();
        list(writer, pvs);

        h2(writer, "↳ Se modificará el Punto de Venta con id " + pv.getId());
        // UPDATE
        pv.setNombre("Punto 1 (modificado)");
        pv.setDescripcion("Descripcion Punto 1 (modificado)");
        puntoVentaDao.save(pv);

        // LIST
        h2(writer, "Obtener Punto de Venta con id " + pv.getId() + ":");
        PuntoVenta pv2 = puntoVentaDao.getById(pv.getId());
        item(writer, pv2);
    }

}
