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
        Date today = new Date();
        IIngredienteRecetaDao ingredienteRecetaDao = FactoryDAO.createIngredienteRecetaDao();
        IRecetaDao recetaDao = FactoryDAO.createRecetaDao();
        IInsumoDao insummoDao = FactoryDAO.createInsumoDao();
        IUsuarioDao usuarioDao = FactoryDAO.createUsuarioDao();

        EncargadoDeSala encargadoDeSala = new EncargadoDeSala("Encar", "Gado", "encargado12", "asddasd123", "encargado12@test.com");
        usuarioDao.save(encargadoDeSala);

        h1(writer, "Receta (e ingredientes)");


        // Setup de ingredientes
        Insumo azucar = new Insumo("Azucar", 100D, "", UnidadMedidaEnum.KG);
        Insumo frascos = new Insumo("Frascos", 1000D, "", UnidadMedidaEnum.UNIDAD);
        Insumo gelificante = new Insumo("Gelificante", 1000D, "", UnidadMedidaEnum.KG);

        insummoDao.save(azucar);
        insummoDao.save(frascos);
        insummoDao.save(gelificante);

        h2(writer, "Se crearon los insumos necesarios para la receta");

        h2(writer, "Se creará la receta");

        List<IngredienteReceta> ingredientes = new ArrayList<>();

        // CREATE
        Receta receta = new Receta("Mermelada de Frutilla", "Deliciosa mermelada", ingredientes);

        ingredientes.add(new IngredienteReceta(0.3, azucar, receta));
        ingredientes.add(new IngredienteReceta(1.0, frascos, receta));
        recetaDao.save(receta);
        item(writer, receta);

        // LIST
        h2(writer, "Listado de Recetas: ");
        List<Receta> recetas = recetaDao.getAll();
        list(writer, recetas);

        h2(writer, "Se modificará la Receta con id (titulo y se agrega ingrediente) " + receta.getId());
        // UPDATE
        receta.setNombre(receta.getNombre() + "(modificado)");
        receta.getIngredientes().add(new IngredienteReceta(.1, gelificante, receta));

        recetaDao.save(receta);

        // Detail
        h2(writer, "Obtener Receta con id " + receta.getId() + ":");
        Receta receta2 = recetaDao.getById(receta.getId());
        item(writer, receta2);

        h1(writer, "Ingredientes");
        // Detail
        h2(writer, "Obtener solo Ingredientes para receta con id " + receta.getId() + ":");
        List<IngredienteReceta> ingredientesRecetas = ingredienteRecetaDao.getByRecetaId(receta.getId());
        list(writer, ingredientesRecetas);

        h2(writer, "Agregar ingrediente a la receta con id " + receta.getId() + ":");
        IngredienteReceta ingredienteReceta = new IngredienteReceta(.1, gelificante, receta);


        ingredientesRecetas = ingredienteRecetaDao.getByRecetaId(receta.getId());
        list(writer, ingredientesRecetas);
        // ==============================LOTE PRODUCTO ELABORADO ============================

        ILoteProductoElaboradoDao loteProductoElaboradoDao = FactoryDAO.createLoteProductoElaboradoDao();

        h1(writer, "Elaboraciones");

        h2(writer, "Se creará una nueva elaboracion para la receta:");

        LoteProductoElaborado lote = new LoteProductoElaborado(5, "pe-05052023/1", new Date(), receta);
        EstadoLote estadoLote = new EstadoLote(encargadoDeSala, new Date(), EstadoLoteEnum.EN_PROCESO, lote);
        ConsumoInsumo consumoInsumo = new ConsumoInsumo(10d, azucar, lote);

        lote.getConsumoInsumos().add(consumoInsumo);
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
        h2(writer, "Se agregaran dos una nota a la elaboración con id " + lote.getId());

        Nota nota = new Nota(encargadoDeSala, "Acidez levemente superior a la habitual", lote);
        Nota nota2 = new Nota(encargadoDeSala, "Revisar cantidades de azucar", lote);
        notaDao.save(nota);
        notaDao.save(nota2);

        h2(writer, "Listado de notas para lote con id " + lote.getId());
        List<Nota> notas = notaDao.getByLote(lote.getId());
        list(writer, notas);

        h2(writer, "Se modificara la nota con id " + nota.getId());
        nota.setDescripcion(nota.getDescripcion() + "(modificada)");
        notaDao.save(nota);
        h2(writer, "Obtener detalle de la nota con id " + nota.getId());
        Nota nota3 = notaDao.getById(nota.getId());
        item(writer, nota3);
        h2(writer, "Baja logica de la nota con id " + nota2.getId());
        nota2.setFechaBaja(new Date());
        notaDao.save(nota2);

        h2(writer, "Listado de notas para lote con id " + lote.getId());
        notas = notaDao.getByLote(lote.getId());
        list(writer, notas);

        h1(writer, "Entregas");

        IPuntoVentaDao puntoVentaDao = FactoryDAO.createPuntoVentaDao();

        PuntoVenta puntoVenta = new PuntoVenta("La justa", "Ubicacion: facultad");
        PuntoVenta puntoVenta2 = new PuntoVenta("Calle Centro", "Ubicacion: plaza italia");
        puntoVentaDao.save(puntoVenta);
        puntoVentaDao.save(puntoVenta2);

        h2(writer, "Se crearan dos entregas a distintos puntos para la elaboración con id " + lote.getId());

        EntregaProducto entrega1 = new EntregaProducto(10.0, lote, puntoVenta);
        EntregaProducto entrega2 = new EntregaProducto(5.0, lote, puntoVenta2);

        IEntregaProductoDao entregaProductoDao = FactoryDAO.createEntregaProductoDao();

        entregaProductoDao.save(entrega1);
        entregaProductoDao.save(entrega2);

        h2(writer, "Listado de todas las entregas");
        list(writer, entregaProductoDao.getAll());

        h2(writer, "Se modificará la entrega con id " + entrega1.getId() + "(cantidad 10 > 40)");
        entrega1.setCantidad(40D);
        entregaProductoDao.save(entrega1);

        h2(writer, "Listado de todas las entregas del lote con id " + lote.getId());
        list(writer, entregaProductoDao.getByLote(lote.getId()));
        h2(writer, "Listado de todas las entregas al punto de venta con id " + puntoVenta.getId());
        list(writer, entregaProductoDao.getByPuntoVenta(puntoVenta.getId()));

        h2(writer, "Baja logica de la entrega con id " + entrega1.getId());

        entrega1.setFechaBaja(new Date());
        entregaProductoDao.save(entrega1);

        h2(writer, "Listado de todas las entregas");
        list(writer, entregaProductoDao.getAll());

    }

}
