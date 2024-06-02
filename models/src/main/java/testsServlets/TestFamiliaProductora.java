package testsServlets;

import dao.FactoryDAO;
import dao.interfaces.IFamiliaProductoraDao;
import grupo17.FamiliaProductora;

import java.io.PrintWriter;
import java.util.List;

public class TestFamiliaProductora extends BaseTest {


    public static void test(PrintWriter writer) {

        IFamiliaProductoraDao familiaProductoraDao = FactoryDAO.createFamiliaProductoraDao();

        // ============================== ENTIDAD: FAMILIA PRODUCTORA =======================================
        h1(writer, "Familia Productora");

        FamiliaProductora fp = new FamiliaProductora("familia 1", "Descripcion familia 1");
        List<FamiliaProductora> fps;

        // CREATE
        h2(writer, "↳ Se creara una nueva familia: ");
        familiaProductoraDao.save(fp);

        item(writer, fp);

        // LIST
        h2(writer, "Listado de Familias Productoras: ");
        fps = familiaProductoraDao.getAll();
        list(writer, fps);

        h2(writer, "↳ Se modificará la Familia Productora con id " + fp.getId());
        // UPDATE
        fp.setNombre("Familia 1 (modificada)");
        fp.setDescripcion("Descripcion familia 1 (modificada)");
        familiaProductoraDao.save(fp);

        // LIST
        h2(writer, "Obtener Familia Productora con id " + fp.getId() + ":");
        FamiliaProductora fp2 = familiaProductoraDao.getById(fp.getId());
        item(writer, fp2);
    }

}
