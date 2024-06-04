package testsServlets;

import dao.FactoryDAO;
import dao.interfaces.IInsumoDao;
import dao.interfaces.IRecetaDao;
import grupo17.IngredienteReceta;
import grupo17.Insumo;
import grupo17.Receta;
import grupo17.enums.UnidadMedidaEnum;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TestReceta extends BaseTest {

    public static void test(PrintWriter writer) {

        IRecetaDao recetaDao = FactoryDAO.createRecetaDao();
        IInsumoDao insummoDao = FactoryDAO.createInsumoDao();

        h1(writer, "Receta (e ingredientes)");

        h2(writer, "↳ Se crearán los insumos necesarios para la receta");

        // Setup de ingredientes
        Insumo insumo1 = new Insumo("Azucar", 100D, "", UnidadMedidaEnum.KG);
        Insumo insumo2 = new Insumo("Frascos", 1000D, "", UnidadMedidaEnum.UNIDAD);
        Insumo insumo3 = new Insumo("Gelificante", 1000D, "", UnidadMedidaEnum.KG);

        insummoDao.save(insumo1);
        insummoDao.save(insumo2);
        insummoDao.save(insumo3);

        h2(writer, "↳ Se creará la receta junto con sus ingredientes asociados:");

        List<IngredienteReceta> ingredientes = new ArrayList<>();
        ingredientes.add(new IngredienteReceta(0.3, insumo1));
        ingredientes.add(new IngredienteReceta(1.0, insumo2));

        // CREATE
        Receta receta = new Receta("Mermelada de Frutilla", "Deliciosa mermelada", ingredientes);

        recetaDao.save(receta);
        item(writer, receta);

        // LIST
        h2(writer, "Listado de Recetas: ");
        List<Receta> recetas = recetaDao.getAll();
        list(writer, recetas);

        h2(writer, "↳ Se modificará la Receta con id (titulo y se agrega ingrediente) " + receta.getId());
        // UPDATE
        receta.setNombre(receta.getNombre() + "(modificado)");
        receta.getIngredientes().add(new IngredienteReceta(.1, insumo3));

        recetaDao.save(receta);

        // Detail
        h2(writer, "Obtener Ingreso de Receta con id " + receta.getId() + ":");
        Receta receta2 = recetaDao.getById(receta.getId());
        item(writer, receta2);
    }

}
