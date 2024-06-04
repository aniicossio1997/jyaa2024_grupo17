package testsServlets;

import dao.FactoryDAO;
import dao.interfaces.IMateriaPrimaDao;
import grupo17.Insumo;
import grupo17.MateriaPrima;
import grupo17.enums.UnidadMedidaEnum;

import java.io.PrintWriter;
import java.util.List;

public class TestMateriaPrima extends BaseTest{
    public static void test(PrintWriter writer) {

        IMateriaPrimaDao materiaPrimaDao = FactoryDAO.createMateriaPrimaDao();

        // ============================== ENTIDAD: FAMILIA PRODUCTORA =======================================
        h1(writer, "Materia Prima");

        MateriaPrima materiaPrima = new MateriaPrima("Nombre Materia Prima","",UnidadMedidaEnum.KG,20.0);
        List<MateriaPrima> fps;

        // CREATE
        h2(writer, "↳ Se creara una Materia Prima: ");
        materiaPrimaDao.save(materiaPrima);

        item(writer, materiaPrima);

        // LIST
        h2(writer, "Listado de MateriaPrimas: ");
        fps = materiaPrimaDao.getAll();
        list(writer, fps);

        h2(writer, "↳ Se modificará la Materia Prima con id " + materiaPrima.getId());
        // UPDATE
        materiaPrima.setNombre("MATERIA PRIMA (modificada)");
        materiaPrima.setDescripcion("Descripcion MATERIA PRIMA (modificada)");
        materiaPrimaDao.save(materiaPrima);

        // LIST
        h2(writer, "Obtener el  Materia Prima con el id " + materiaPrima.getId() + ":");
        MateriaPrima fp2 = materiaPrimaDao.getById(materiaPrima.getId());
        item(writer, fp2);
    }

}
