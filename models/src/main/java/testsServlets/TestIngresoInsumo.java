package testsServlets;

import dao.FactoryDAO;
import dao.interfaces.IIngresoInsumoDao;
import dao.interfaces.IPuntoVentaDao;
import grupo17.IngresoInsumo;
import grupo17.Insumo;
import grupo17.PuntoVenta;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestIngresoInsumo extends BaseTest {

    public static void test(PrintWriter writer) {

        IIngresoInsumoDao dao = FactoryDAO.createIngresoInsumoDao();

        h1(writer, "Ingreso de Insumo");

        IngresoInsumo ingreso = new IngresoInsumo(new Insumo(), new Date(), "Ingreso de tomates", 5.5, "i-04052023", 20000);
        List<IngresoInsumo> ingresos;

        // CREATE
        h2(writer, "↳ Se creara un nuevo Ingreso de Insumo: ");
        dao.save(ingreso);

        item(writer, ingreso);

        // LIST
        h2(writer, "Listado de Ingresos de Insumos: ");
        ingresos = dao.getAll();
        list(writer, ingresos);

        h2(writer, "↳ Se modificará el Ingreso de Insumo con id " + ingreso.getId());
        // UPDATE
        ingreso.setCodigo("i-06052023");
        ingreso.setCantidad(7);
        ingreso.setValorCompra(22000);
        ingreso.setDescripcion(ingreso.getDescripcion() + "(modificado)");

        dao.save(ingreso);

        // Detail
        h2(writer, "Obtener Ingreso de Insumo con id " + ingreso.getId() + ":");
        IngresoInsumo ingreso2 = dao.getById(ingreso.getId());
        item(writer, ingreso2);
    }

}
