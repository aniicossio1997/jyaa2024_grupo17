package com.app.tests;

import com.app.dao.FactoryDAO;
import com.app.dao.interfaces.*;
import com.app.models.*;
import com.app.models.enums.EstadoElaboracionEnum;
import com.app.models.enums.EstadoMateriaPrimaEnum;
import com.app.models.enums.RolUsuario;
import com.app.models.enums.UnidadMedidaEnum;

import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TestGlobal extends BaseTest {

    public static void test(PrintWriter w) {

        ResponseWriter writer = new ResponseWriter(w);

        // DAOS
        IInsumoDao insumoDao = FactoryDAO.createInsumoDao();
        IIngredienteRecetaDao ingredienteRecetaDao = FactoryDAO.createIngredienteRecetaDao();
        IRecetaDao recetaDao = FactoryDAO.createRecetaDao();
        IUsuarioDao usuarioDao = FactoryDAO.createUsuarioDao();
        IIngresoInsumoDao ingresoInsumoDao = FactoryDAO.createIngresoInsumoDao();
        IFamiliaProductoraDao familiaProductoraDao = FactoryDAO.createFamiliaProductoraDao();
        IMateriaPrimaDao materiaPrimaDao = FactoryDAO.createMateriaPrimaDao();
        IPuntoVentaDao puntoVentaDao = FactoryDAO.createPuntoVentaDao();
        IConsumoInsumoDao consumoInsumoDao = FactoryDAO.createConsumoInsumoDao();
        IEstadoElaboracionDao estadoElaboracionDao = FactoryDAO.createEstadoElaboracionDao();
        IConsumoMateriaPrimaDao consumoMateriaPrimaDao = FactoryDAO.createConsumoMateriaPrimaDao();
        IIngresoMateriaPrimaDao ingresoMateriaPrimaDao = FactoryDAO.createIngresoMateriaPrimaDao();
        IEstadoMateriaPrimaDao estadoMateriaPrimaDao = FactoryDAO.createEstadoMateriaPrimaDao();

        // ============================== USUARIO =======================================

        writer.h1("Usuarios");

        Usuario administrador = new Usuario("Ad", "Min", "admin", "asdasd123", "admin@test.com", RolUsuario.ADMIN);
        List<Usuario> usuarios;

        // CREATE
        writer.h2("Se creara un nuevo usuario Administrador: ");
        usuarioDao.save(administrador);

        writer.item(administrador);

        // CREATE
        writer.h2("↳ Se creara un nuevo usuario Encargado de Sala: ");
        Usuario encargadoDeSala = new Usuario("Encargado", "Sala", "encargadosala", "asdasd123", "encargado@test.com", RolUsuario.ENCARGADO_SALA);
        usuarioDao.save(encargadoDeSala);

        writer.item(encargadoDeSala);

        // LIST
        writer.h2("Listado de Usuarios: ");
        usuarios = usuarioDao.getAll(false);
        writer.list(usuarios);

        writer.h2("Se modificará el usuario con id: " + administrador.getId());
        // UPDATE
        administrador.setNombre("Ad (modificado)");
        administrador.setApellido("Min (modificado)");
        usuarioDao.save(administrador);

        // LIST
        writer.h2("Obtener Usuario con id " + administrador.getId() + ":");
        Usuario u2 = usuarioDao.getById(administrador.getId());
        writer.item(u2);

        writer.h2("Listado de Usuarios: ");
        usuarios = usuarioDao.getAll(false);
        writer.list(usuarios);

        // ============================== FAMILIA PRODUCTORA =======================================

        writer.h1("Familia Productora");

        FamiliaProductora familiaProductoraTomates = new FamiliaProductora("Quinta de tomates", "Gran quinta");
        List<FamiliaProductora> fps;

        // CREATE
        writer.h2("Se creará una nueva familia: ");
        familiaProductoraDao.save(familiaProductoraTomates);

        writer.item(familiaProductoraTomates);

        writer.h2("Se creará otra nueva familia: ");
        FamiliaProductora familiaProductoraMiel = new FamiliaProductora("Panales del sur", "Rica miel");
        familiaProductoraDao.save(familiaProductoraMiel);

        writer.item(familiaProductoraMiel);

        // LIST
        writer.h2("Listado de Familias Productoras: ");
        fps = familiaProductoraDao.getAll();
        writer.list(fps);

        writer.h2("Se modificará la Familia Productora con id " + familiaProductoraTomates.getId());
        // UPDATE
        familiaProductoraTomates.setNombre("Quinta de tomates ARANA");
        familiaProductoraTomates.setDescripcion("Proucen tomate libre de agroquimicos");
        familiaProductoraDao.save(familiaProductoraTomates);

        // LIST
        writer.h2("Obtener Familia Productora con id " + familiaProductoraTomates.getId() + ":");
        FamiliaProductora detalleFamiliaProductora = familiaProductoraDao.getById(familiaProductoraTomates.getId());
        writer.item(detalleFamiliaProductora);

        // ============================== PUNTO DE VENTA =======================================
        writer.h1("Punto de Venta");

        PuntoVenta pv = new PuntoVenta("Punto 1", "Descripcion Punto 1");
        List<PuntoVenta> pvs;

        // CREATE
        writer.h2("Se creara un nuevo Punto de Venta: ");
        puntoVentaDao.save(pv);

        writer.item(pv);

        // LIST
        writer.h2("Listado de Puntos de Venta: ");
        pvs = puntoVentaDao.getAll();
        writer.list(pvs);

        writer.h2("Se modificará el Punto de Venta con id " + pv.getId());
        // UPDATE
        pv.setNombre("Punto 1 (modificado)");
        pv.setDescripcion("Descripcion Punto 1 (modificado)");
        puntoVentaDao.save(pv);

        // LIST
        writer.h2("Obtener Punto de Venta con id " + pv.getId() + ":");
        PuntoVenta pv2 = puntoVentaDao.getById(pv.getId());
        writer.item(pv2);


        // ============================== INSUMO =======================================
        writer.h1("Insumo");

        // CREATE
        writer.h2("Se crearán varios insumos: ");

        Insumo azucar = new Insumo("Azucar Rubia ZZZZ", 120.0, "Azucar Rubia ZZZZ", UnidadMedidaEnum.KG);
        Insumo frascos = new Insumo("Frascos", 1000D, "", UnidadMedidaEnum.UNIDAD);
        Insumo gelificante = new Insumo("Gelificante", 1000D, "", UnidadMedidaEnum.KG);

        insumoDao.save(azucar);
        insumoDao.save(frascos);
        insumoDao.save(gelificante);

        writer.list(Arrays.asList(azucar, frascos, gelificante));

        // LIST
        writer.h2("Listado de Insumos: ");
        List<Insumo> insumos = insumoDao.getAll();
        writer.list(insumos);

        writer.h2("Se modificará el insumo con id " + azucar.getId());
        // UPDATE
        azucar.setNombre("Azucar");
        azucar.setDescripcion("Azucar Rubia");
        insumoDao.save(azucar);
        writer.item(azucar);

        // LIST
        writer.h2("Obtener el insumo con el id " + azucar.getId() + ":");
        Insumo detalleInsumo = insumoDao.getById(azucar.getId());
        writer.item(detalleInsumo);

        // ============================== INGRESO INSUMO =======================================

        writer.h1("Ingreso de Insumo");

        List<IngresoInsumo> ingresoInsumos;

        // CREATE
        writer.h2(MessageFormat.format("Se creará un nuevo Ingreso de Insumo ({0}):", azucar.getNombre()));

        IngresoInsumo ingreso = new IngresoInsumo(azucar, new Date(), "Ingreso de Azucar", 5.5, "i-04052023", 20000);
        ingresoInsumoDao.save(ingreso);

        writer.item(ingreso);

        // LIST
        writer.h2("Listado de Ingresos de Insumos: ");
        ingresoInsumos = ingresoInsumoDao.getAll();
        writer.list(ingresoInsumos);

        writer.h2("Se modificará el Ingreso de Insumo con id " + ingreso.getId());
        // UPDATE
        ingreso.setCodigo("i-06052023");
        ingreso.setCantidad(7);
        ingreso.setValorCompra(22000);
        ingreso.setDescripcion(ingreso.getDescripcion() + "(modificado)");

        ingresoInsumoDao.save(ingreso);

        // Detail
        writer.h2("Obtener Ingreso de Insumo con id " + ingreso.getId());
        IngresoInsumo detalleIngresoInsumo = ingresoInsumoDao.getById(ingreso.getId());
        writer.item(detalleIngresoInsumo);


        // ============================== MATERIA PRIMA =======================================
        writer.h1("Materia Prima");

        writer.h2("↳ Se crearan dos Materias Primas: ");
        MateriaPrima tomate = new MateriaPrima("Tomattte", "Tomates para elssssssaboración de salsas", UnidadMedidaEnum.KG, 60.0);
        MateriaPrima miel = new MateriaPrima("Miel de abeja", "Miel fresca de abejas locales", UnidadMedidaEnum.KG, 100.0);

        materiaPrimaDao.save(tomate);
        materiaPrimaDao.save(miel);

        writer.list(Arrays.asList(tomate, miel));

        // LIST
        writer.h2("Listado de MateriaPrimas: ");
        List<MateriaPrima> materiasPrimas = materiaPrimaDao.getAll();
        writer.list(materiasPrimas);

        writer.h2("↳ Se modificará la Materia Prima con id " + tomate.getId());
        // UPDATE
        tomate.setNombre("Tomate");
        tomate.setDescripcion("Tomates para elaboración de salsas");
        materiaPrimaDao.save(tomate);

        // LIST
        writer.h2("Obtener el detalle de Materia Prima con el id " + tomate.getId() + ":");
        MateriaPrima materiaPrimas2 = materiaPrimaDao.getById(tomate.getId());
        writer.item(materiaPrimas2);

        // ============================== INGRESO MATERIA PRIMA =======================================
        writer.h1("Ingreso de Materia Prima");

        writer.h2("Listado de todos Ingresos de Materia Prima: ");

        writer.list(ingresoMateriaPrimaDao.getAll());

        writer.h2(MessageFormat.format("Se crerá un ingreso de Materia Prima para el usuario {0} - materia prima: {1} - familia: {2}", encargadoDeSala.getUsername(), tomate.getNombre(), familiaProductoraTomates.getNombre()));

        IngresoMateriaPrima ingresoTomates = new IngresoMateriaPrima(
                20.0, "1100", "", new Date(), 25000, tomate, familiaProductoraTomates
        );

        ingresoTomates.updateEstado(new EstadoMateriaPrima(encargadoDeSala, new Date(), EstadoMateriaPrimaEnum.ESTANTE, ingresoTomates));
        ingresoMateriaPrimaDao.save(ingresoTomates);
        writer.item(ingresoTomates);

        writer.h2(MessageFormat.format("Se crerá otro ingreso de Materia Prima para el usuario {0} - materia prima: {1} - familia: {2}", administrador.getUsername(), miel.getNombre(), familiaProductoraMiel.getNombre()));

        IngresoMateriaPrima ingresoMiel = new IngresoMateriaPrima(
                50.0, "imp-20052023/1", "", new Date(), 40000, miel, familiaProductoraMiel
        );

        ingresoMiel.updateEstado(new EstadoMateriaPrima(administrador, new Date(), EstadoMateriaPrimaEnum.ESTANTE, ingresoMiel));

        ingresoMateriaPrimaDao.save(ingresoMiel);
        writer.item(ingresoMiel);

        writer.h2("Se modificará el ingreso de Miel (cantidad 50 => 60 | valor 40000 => 45000)");
        ingresoMiel.setCantidad(60);
        ingresoMiel.setValorCompra(45000);
        ingresoMateriaPrimaDao.save(ingresoMiel);
        writer.item(ingresoMiel);

        writer.h2("Listado de todos Ingresos de Materia Prima: ");

        writer.list(ingresoMateriaPrimaDao.getAll());

        // ============================== ESTADO MATERIA PRIMA =========================

        writer.h1("Estados de Materia Prima (ingresos)");

        writer.h2("Listado de todos los estados");
        List<EstadoMateriaPrima> estadoMateriaPrimaList = estadoMateriaPrimaDao.getAll();
        writer.list(estadoMateriaPrimaList);

        writer.h2("Se agregará un estado al ingreso con id " + ingresoTomates.getId() + " (Tomates)");
        EstadoMateriaPrima estadoMateriaPrima = new EstadoMateriaPrima(encargadoDeSala, new Date(), EstadoMateriaPrimaEnum.FREEZER, ingresoTomates);
        estadoMateriaPrimaDao.save(estadoMateriaPrima);
        writer.item(estadoMateriaPrima);

        writer.h2("Listado de todos los estados");
        writer.list(estadoMateriaPrimaDao.getAll());

        writer.h2("Listado de todos los estados del ingreso con id " + ingresoTomates.getId());
        List<EstadoMateriaPrima> estadosIngresoTomate = estadoMateriaPrimaDao.getByIngresoMateriaPrima(ingresoTomates.getId());
        writer.list(estadosIngresoTomate);

        writer.h2("Se modificará el estado con id " + estadoMateriaPrima.getId() + "(FREEZER -> CAMARA_FRIO)");
        estadoMateriaPrima.setEstado(EstadoMateriaPrimaEnum.CAMARA_FRIO);
        estadoMateriaPrimaDao.save(estadoMateriaPrima);
        writer.item(estadoMateriaPrima);

        writer.h2("Listado de todos los estados de la materia prima " + tomate.getNombre());
        List<EstadoMateriaPrima> estadosTomate = estadoMateriaPrimaDao.getByMateriaPrima(tomate.getId());
        writer.list(estadosTomate);

        // ============================== RECETA =======================================

        writer.h1("Receta (e ingredientes)");

        writer.h2("Se creará la receta (azucar, frasco, frutilla)");

        List<IngredienteReceta> ingredientes = new ArrayList<>();

        // CREATE
        Receta receta = new Receta("Mermelada de Frutilla", "Deliciosa mermelada", ingredientes, encargadoDeSala);

        ingredientes.add(new IngredienteReceta(0.3, azucar, receta));
        ingredientes.add(new IngredienteReceta(1.0, frascos, receta));
        recetaDao.save(receta);
        writer.item(receta);

        // LIST
        writer.h2("Listado de Recetas: ");
        List<Receta> recetas = recetaDao.getAll();
        writer.list(recetas);

        writer.h2("Se modificará la Receta con id " + receta.getId() + " (titulo y se agrega ingrediente gelificante) ");

        // UPDATE
        receta.setNombre(receta.getNombre() + "(modificado)");
        receta.getIngredientes().add(new IngredienteReceta(.1, gelificante, receta));

        recetaDao.save(receta);

        // Detail
        writer.h2("Obtener Receta con id " + receta.getId() + ":");
        Receta receta2 = recetaDao.getById(receta.getId());
        writer.item(receta2);

        writer.h1("Ingredientes");

        // ============================== INGREDIENTE =======================================

        writer.h2("Listado de todos los ingredientes");
        List<IngredienteReceta> ingredientesList = ingredienteRecetaDao.getAll();
        writer.list(ingredientesList);

        // Detail
        writer.h2("Obtener solo Ingredientes para receta con id " + receta.getId() + ":");
        List<IngredienteReceta> ingredientesRecetas = ingredienteRecetaDao.getByRecetaId(receta.getId());
        writer.list(ingredientesRecetas);

        writer.h2("Agregar ingrediente a la receta con id " + receta.getId() + ":");
        IngredienteReceta ingredienteReceta = new IngredienteReceta(.1, gelificante, receta);
        ingredienteRecetaDao.save(ingredienteReceta);
        writer.item(ingredienteReceta);

        writer.h2(MessageFormat.format("Obtener ingrediente con id {0}", ingredientesList.get(0).getId()));
        IngredienteReceta ingredienteDetalle = ingredienteRecetaDao.getById(ingredientesList.get(0).getId());
        writer.item(ingredienteDetalle);

        writer.h2("Se modificará la cantidad del ingrediente con id " + ingredienteDetalle.getId());
        ingredienteDetalle.setCantidad(3D);
        ingredienteRecetaDao.save(ingredienteDetalle);
        writer.item(ingredienteDetalle);

        writer.h2("Listado de todos los ingredientes");
        ingredientesList = ingredienteRecetaDao.getAll();
        writer.list(ingredientesList);

        // ============================== ELABORACIONES ============================

        IElaboracionDao elaboracionDao = FactoryDAO.createElaboracionDao();

        writer.h1("Elaboraciones");

        writer.h2("Se crearán dos elaboraciones para la receta con id " + receta.getId());

        Elaboracion elaboracion = new Elaboracion(5, "pe-05052023/1", new Date(), receta);
        elaboracion.getConsumoInsumos().add(new ConsumoInsumo(10d, azucar, elaboracion));
        elaboracion.updateEstado(new EstadoElaboracion(encargadoDeSala, new Date(), EstadoElaboracionEnum.EN_PROCESO, elaboracion));

        Elaboracion elaboracion2 = new Elaboracion(5, "pe-05052023/1", new Date(), receta);
        elaboracion2.getConsumoInsumos().add(new ConsumoInsumo(1d, frascos, elaboracion));
        elaboracion2.updateEstado(new EstadoElaboracion(encargadoDeSala, new Date(), EstadoElaboracionEnum.EN_PROCESO, elaboracion));

        elaboracionDao.save(elaboracion);
        elaboracionDao.save(elaboracion2);

        writer.h2("Listado de todas las elaboraciones");
        List<Elaboracion> elaboracionesList = elaboracionDao.getAll();
        writer.list(elaboracionesList);

        writer.h2("Se modificara la elaboracion con id " + elaboracion.getId() + " (cantidad 5 > 10)");
        elaboracion.getEstados().add(new EstadoElaboracion(encargadoDeSala, new Date(), EstadoElaboracionEnum.EN_DEPOSITO, elaboracion));
        elaboracion.setCantidad(10);
        elaboracion.setCodigo("pe-07052023/1");

        elaboracionDao.save(elaboracion);
        writer.item(elaboracion);

        writer.h2("Listado de las elaboraciones asociadas a la receta con id " + receta.getId());
        List<Elaboracion> elaboracionesReceta = elaboracionDao.getByRecetaId(receta.getId());
        writer.list(elaboracionesReceta);

        // ============================== NOTAS ============================
        writer.h1("Notas");

        INotaDao notaDao = FactoryDAO.createNotaDao();
        writer.h2("Se agregaran dos notas a la elaboración con id " + elaboracion.getId());

        Nota nota = new Nota(encargadoDeSala, "Acidez levemente superior a la habitual", elaboracion);
        Nota nota2 = new Nota(encargadoDeSala, "Revisar cantidades de azucar", elaboracion);
        notaDao.save(nota);
        notaDao.save(nota2);

        writer.h2("Listado de notas para elaboracion con id " + elaboracion.getId());
        List<Nota> notas = notaDao.getByElaboracion(elaboracion.getId());
        writer.list(notas);

        writer.h2("Se modificara la nota con id " + nota.getId());
        nota.setDescripcion(nota.getDescripcion() + "(modificada)");
        notaDao.save(nota);
        writer.h2("Obtener detalle de la nota con id " + nota.getId());
        Nota nota3 = notaDao.getById(nota.getId());
        writer.item(nota3);
        writer.h2("Baja logica de la nota con id " + nota2.getId());
        nota2.setFechaBaja(new Date());
        notaDao.save(nota2);

        writer.h2("Listado de notas para elaboracion con id " + elaboracion.getId());
        notas = notaDao.getByElaboracion(elaboracion.getId());
        writer.list(notas);

        writer.h1("Entregas");

        PuntoVenta puntoVenta = new PuntoVenta("La justa", "Ubicacion: facultad");
        PuntoVenta puntoVenta2 = new PuntoVenta("Calle Centro", "Ubicacion: plaza italia");
        puntoVentaDao.save(puntoVenta);
        puntoVentaDao.save(puntoVenta2);

        writer.h2("Se crearan dos entregas a distintos puntos para la elaboración con id " + elaboracion.getId());

        EntregaElaboracion entrega1 = new EntregaElaboracion(10L, elaboracion, puntoVenta, new Date(), encargadoDeSala);
        EntregaElaboracion entrega2 = new EntregaElaboracion(5L, elaboracion, puntoVenta2, new Date(), encargadoDeSala);

        IEntregaElaboracionDao entregaProductoDao = FactoryDAO.createEntregaProductoDao();

        entregaProductoDao.save(entrega1);
        entregaProductoDao.save(entrega2);

        writer.h2("Listado de todas las entregas");
        writer.list(entregaProductoDao.getAll());

        writer.h2("Se modificará la entrega con id " + entrega1.getId() + "(cantidad 10 > 40)");
        entrega1.setCantidad(40L);
        entregaProductoDao.save(entrega1);

        writer.h2("Listado de todas las entregas de elaboracion con id " + elaboracion.getId());
        writer.list(entregaProductoDao.getByElaboracion(elaboracion.getId()));
        writer.h2("Listado de todas las entregas al punto de venta con id " + puntoVenta.getId());
        writer.list(entregaProductoDao.getByPuntoVenta(puntoVenta.getId()));

        writer.h2("Baja logica de la entrega con id " + entrega1.getId());

        entrega1.setFechaBaja(new Date());
        entregaProductoDao.save(entrega1);

        writer.h2("Listado de todas las entregas");
        writer.list(entregaProductoDao.getAll());

        // ============================== CONSUMOS DE INSUMOS ============================
        writer.h1("Consumos de insumos");

        writer.h2("Listado de todos los consumos");
        List<ConsumoInsumo> consumoInsumoList = consumoInsumoDao.getAll();
        writer.list(consumoInsumoList);

        writer.h2("Se agregarán dos consumos al elaboracion con id " + elaboracion2.getId() + "(Gelificante 1kg y Azucar 2kg)");
        ConsumoInsumo consumoGelificante = new ConsumoInsumo(1D, gelificante, elaboracion2);
        consumoInsumoDao.save(consumoGelificante);
        ConsumoInsumo consumoAzucar = new ConsumoInsumo(2D, azucar, elaboracion2);
        consumoInsumoDao.save(consumoAzucar);
        writer.list(Arrays.asList(consumoGelificante, consumoAzucar));

        writer.h2("Listado de todos los consumos del elaboracion con id " + elaboracion2.getId());
        List<ConsumoInsumo> consumosElaboracion = consumoInsumoDao.getByElaboracion(elaboracion2.getId());
        writer.list(consumosElaboracion);

        writer.h2(MessageFormat.format("Listado de todos los consumos del insumo con id {0} ({1})", azucar.getId(), azucar.getNombre()));
        List<ConsumoInsumo> consumosAzucar = consumoInsumoDao.getByInsumo(azucar.getId());
        writer.list(consumosAzucar);

        // ============================== CONSUMOS DE MATERIA PRIMA ============================
        writer.h1("Consumos de Materia Prima");

        writer.h2("Se agregará un consumo al elaboracion con id " + elaboracion2.getId() + "(Tomate 1kg) ");
        ConsumoMateriaPrima consumoTomate = new ConsumoMateriaPrima(1D, ingresoTomates, elaboracion2);
        consumoMateriaPrimaDao.save(consumoTomate);
        writer.item(consumoTomate);

        writer.h2("Se agregará un consumo al elaboracion con id " + elaboracion.getId() + "(Miel 5kg) ");
        ConsumoMateriaPrima consumoMiel = new ConsumoMateriaPrima(1D, ingresoMiel, elaboracion);
        consumoMateriaPrimaDao.save(consumoMiel);
        writer.item(consumoMiel);

        writer.h2("Se agregará un nuevo consumo al elaboracion con id " + elaboracion.getId() + "(Tomate 1kg) ");
        ConsumoMateriaPrima consumoTomate2 = new ConsumoMateriaPrima(1D, ingresoTomates, elaboracion);
        consumoMateriaPrimaDao.save(consumoTomate2);
        writer.item(consumoTomate2);

        writer.h2("Listado de todos los consumos");
        List<ConsumoMateriaPrima> consumosMateriaPrima = consumoMateriaPrimaDao.getAll();
        writer.list(consumosMateriaPrima);

        writer.h2("Se modificará el consumo de miel (cantidad 5kg => 6kg)");
        consumoMiel.setCantidad(6D);
        consumoMateriaPrimaDao.save(consumoMiel);
        writer.item(consumoMiel);

        writer.h2("Listado de todos los consumos del elaboracion con id " + elaboracion2.getId());
        writer.list(consumoMateriaPrimaDao.getByElaboracion(elaboracion2.getId()));

        writer.h2("Listado de todos los consumos de la materia prima " + tomate.getNombre());
        writer.list(consumoMateriaPrimaDao.getByMateriaPrima(tomate.getId()));

        writer.h2("Listado de todos los consumos del ingreso de materia prima con id " + ingresoTomates.getId());
        writer.list(consumoMateriaPrimaDao.getByIngresoMateriaPrima(ingresoTomates.getId()));

        // ============================== ESTADOS DE ELABORACION ============================
        writer.h1("Estados de Elaboraciones");

        writer.h2("Listado de todos los estados");
        List<EstadoElaboracion> estadoElaboracionList = estadoElaboracionDao.getAll();
        writer.list(estadoElaboracionList);

        writer.h2("Se agregarán dos estados a elaboracion con id " + elaboracion2.getId() + " (en deposito y luego entregado)");
        EstadoElaboracion estadoEnDeposito = new EstadoElaboracion(encargadoDeSala, new Date(), EstadoElaboracionEnum.EN_DEPOSITO, elaboracion2);
        estadoElaboracionDao.save(estadoEnDeposito);
        EstadoElaboracion estadoEntregado = new EstadoElaboracion(encargadoDeSala, new Date(), EstadoElaboracionEnum.ENTREGADO_COMPLETO, elaboracion2);
        estadoElaboracionDao.save(estadoEntregado);
        writer.list(Arrays.asList(estadoEnDeposito, estadoEntregado));

        writer.h2("Listado de todos los estados de elaboracion con id " + elaboracion2.getId());
        List<EstadoElaboracion> estadoElaboracion2 = estadoElaboracionDao.getByElaboracion(elaboracion2.getId());
        writer.list(estadoElaboracion2);
    }

}
