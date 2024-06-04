package testsServlets;

import dao.FactoryDAO;
import dao.implementations.InsumoDao;
import dao.interfaces.IInsumoDao;
import grupo17.Insumo;
import grupo17.enums.UnidadMedidaEnum;

import java.io.PrintWriter;
import java.util.List;

public class TestInsumo extends BaseTest{
    public static void test(PrintWriter writer) {

        IInsumoDao insumoDao = FactoryDAO.createInsumoDao();

        // ============================== ENTIDAD: FAMILIA PRODUCTORA =======================================
        h1(writer, "Insumo");

        Insumo insumo = new Insumo("Nombre insumo",20.0,"limpiador", UnidadMedidaEnum.LITRO);
        List<Insumo> fps;

        // CREATE
        h2(writer, "↳ Se creara un insumo: ");
        insumoDao.save(insumo);

        item(writer, insumo);

        // LIST
        h2(writer, "Listado de Insumos: ");
        fps = insumoDao.getAll();
        list(writer, fps);

        h2(writer, "↳ Se modificará el insumo con id " + insumo.getId());
        // UPDATE
        insumo.setNombre("insumo (modificada)");
        insumo.setDescripcion("Descripcion insumo (modificada)");
        insumoDao.save(insumo);

        // LIST
        h2(writer, "Obtener el insumo con el id " + insumo.getId() + ":");
        Insumo fp2 = insumoDao.getById(insumo.getId());
        item(writer, fp2);
    }

}
