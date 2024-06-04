package testsServlets;

import dao.FactoryDAO;
import dao.implementations.NotaDao;
import dao.interfaces.*;
import grupo17.*;
import grupo17.enums.EstadoLoteEnum;
import grupo17.enums.UnidadMedidaEnum;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestReceta extends BaseTest {

    public static void test(PrintWriter writer) {
        IIngredienteRecetaDao ingredienteRecetaDao = FactoryDAO.createIngredienteRecetaDao();
        IRecetaDao recetaDao = FactoryDAO.createRecetaDao();
        IInsumoDao insummoDao = FactoryDAO.createInsumoDao();
        IUsuarioDao usuarioDao = FactoryDAO.createUsuarioDao();

        EncargadoDeSala encargadoDeSala = new EncargadoDeSala("Encar", "Gado", "encargado12", "asddasd123", "encargado12@test.com");
        usuarioDao.save(encargadoDeSala);

        h1(writer, "Receta (e ingredientes)");


        // Setup de ingredientes
        Insumo insumo1 = new Insumo("Azucar", 100D, "", UnidadMedidaEnum.KG);
        Insumo insumo2 = new Insumo("Frascos", 1000D, "", UnidadMedidaEnum.UNIDAD);
        Insumo insumo3 = new Insumo("Gelificante", 1000D, "", UnidadMedidaEnum.KG);

        insummoDao.save(insumo1);
        insummoDao.save(insumo2);
        insummoDao.save(insumo3);

        h2(writer, "Se crearon los insumos necesarios para la receta ✅");

        h2(writer, "Se creará la receta junto con sus ingredientes asociados:");

        List<IngredienteReceta> ingredientes = new ArrayList<>();


        // CREATE
        Receta receta = new Receta("Mermelada de Frutilla", "Deliciosa mermelada", ingredientes);

        ingredientes.add(new IngredienteReceta(0.3, insumo1, receta));
        ingredientes.add(new IngredienteReceta(1.0, insumo2, receta));
        recetaDao.save(receta);
        item(writer, receta);

        // LIST
        h2(writer, "Listado de Recetas: ");
        List<Receta> recetas = recetaDao.getAll();
        list(writer, recetas);

        h2(writer, "Se modificará la Receta con id (titulo y se agrega ingrediente) " + receta.getId());
        // UPDATE
        receta.setNombre(receta.getNombre() + "(modificado)");
        receta.getIngredientes().add(new IngredienteReceta(.1, insumo3, receta));

        recetaDao.save(receta);

        // Detail
        h2(writer, "Obtener Receta con id " + receta.getId() + ":");
        Receta receta2 = recetaDao.getById(receta.getId());
        item(writer, receta2);

        // Detail
        h2(writer, "Obtener solo Ingredientes para receta con id " + receta.getId() + ":");
        List<IngredienteReceta> ingredientesRecetas = ingredienteRecetaDao.getByRecetaId(receta.getId());
        list(writer, ingredientesRecetas);

        // ==============================LOTE PRODUCTO ELABORADO ============================

        ILoteProductoElaboradoDao loteProductoElaboradoDao = FactoryDAO.createLoteProductoElaboradoDao();

        h1(writer, "Elaboraciones");

        h2(writer, "Se creará una nueva elaboracion para la receta:");

        LoteProductoElaborado lote = new LoteProductoElaborado(5, "pe-05052023/1", new Date(), receta);
        EstadoLote estadoLote = new EstadoLote(encargadoDeSala, new Date(), EstadoLoteEnum.EN_PROCESO, lote);
        lote.getEstados().add(estadoLote);

        loteProductoElaboradoDao.save(lote);
        item(writer, lote);


        h2(writer, "Se modificara la elaboracion:");
        lote.getEstados().add(new EstadoLote(encargadoDeSala, new Date(), EstadoLoteEnum.EN_DEPOSITO, lote));
        lote.setCantidad(10);
        lote.setCodigo("pe-07052023/1");

        loteProductoElaboradoDao.save(lote);
        item(writer, lote);

        h1(writer, "Notas");

        INotaDao notaDao = FactoryDAO.createNotaDao();
        h2(writer, "Se agregará una nota a la elaboración con id " + lote.getId());

        Nota nota = new Nota(encargadoDeSala, "Acidez levemente superior a la habitual", lote);
        notaDao.save(nota);

        h2(writer, "Listado de notas para lote con id " + lote.getId());
        List<Nota> notas = notaDao.getByLote(lote.getId());
        list(writer, notas);

    }

}
