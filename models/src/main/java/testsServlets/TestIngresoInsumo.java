package testsServlets;

import dao.FactoryDAO;
import dao.interfaces.IIngresoInsumoDao;
import dao.interfaces.IInsumoDao;
import grupo17.IngresoInsumo;
import grupo17.Insumo;
import grupo17.enums.UnidadMedidaEnum;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

public class TestIngresoInsumo extends BaseTest {

    public static void test(PrintWriter writer) {

        IIngresoInsumoDao dao = FactoryDAO.createIngresoInsumoDao();

        IInsumoDao insumoDao = FactoryDAO.createInsumoDao();


        h1(writer, "Ingreso de Insumo");

        List<IngresoInsumo> ingresos;

        // CREATE
        h2(writer, "↳ Se creará un nuevo Ingreso de Insumo: ");

        Insumo insumo = new Insumo("Frascos", 0D, "Frascos para guardar mermeladas", UnidadMedidaEnum.KG);
        insumoDao.save(insumo);

        IngresoInsumo ingreso = new IngresoInsumo(insumo, new Date(), "Ingreso de fracos", 5, "i-04052023", 20000);
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
