package testsServlets;

import dao.FactoryDAO;
import dao.interfaces.*;
import grupo17.*;
import grupo17.enums.EstadoMateriaPrimaEnum;
import grupo17.enums.UnidadMedidaEnum;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestIngresoMateriaPrima extends BaseTest {

    public static void test(PrintWriter writer) {
        //Arrange
        IUsuarioDao usuarioDao=FactoryDAO.createUsuarioDao();
        IIngresoMateriaPrimaDao ingresoMateriaPrimaDao = FactoryDAO.createIngresoMateriaPrimaDao();

        IMateriaPrimaDao materiaPrimaDao = FactoryDAO.createMateriaPrimaDao();
        IFamiliaProductoraDao familiaProductoraDao = FactoryDAO.createFamiliaProductoraDao();


        Usuario es = new EncargadoDeSala("Encargado", "Sala", "encargadosala", "asdasd123", "encargado@test.com");
        usuarioDao.save(es);
        MateriaPrima materiaPrima = new MateriaPrima("Tomate",  "Tomates para elaboración de salsas", UnidadMedidaEnum.KG,60.0);
        materiaPrimaDao.save(materiaPrima);

        FamiliaProductora fp = new FamiliaProductora("familia 1 ingreso", "Descripcion familia 1");
        List<FamiliaProductora> fps;

        familiaProductoraDao.save(fp);

        item(writer, fp);

        h1(writer, "Ingreso de Materia Prima");
        item(writer, "Con los siguientes Datos");
        item(writer, "Usuario:"+ es.toString());
        item(writer, "Materia Prima:"+ materiaPrima.toString());
        item(writer, "Familia Productora:"+ fp.toString().toString());

        h1(writer, "Listado Previo al guardado:");
        // LIST
        h2(writer, "Listado de Ingresos de Insumos: ");

        list(writer, ingresoMateriaPrimaDao.getAll());

        List<IngresoMateriaPrima> ingresos;

        // CREATE
        h2(writer, "↳ Se creará un nuevo Ingreso de Materia Prima: ");
        //

        IngresoMateriaPrima ingreso = new IngresoMateriaPrima(
                20.0,"1100","", new Date(),25000,materiaPrima,fp
        );
        ingreso.updateEstado(new EstadoMateriaPrima(es,new Date(),EstadoMateriaPrimaEnum.ESTANTE,ingreso));
        ingresoMateriaPrimaDao.save(ingreso);

        h2(writer, "Despues de agregar el ingreso:: ");

        list(writer, ingresoMateriaPrimaDao.getAll());
        //


/*



        ingresoMateriaPrimaDao.save(ingreso);

        item(writer, ingreso);

        // LIST
        h2(writer, "Listado de Ingresos de Materia Primas: ");
        ingresos = ingresoMateriaPrimaDao.getAll();
        list(writer, ingresos);

        h2(writer, "↳ Se modificará el Ingreso de Materia Prima con id " + ingreso.getId());
        // UPDATE
        ingreso.setCodigo("i-06052023");
        ingreso.setCantidad(7);
        ingreso.setValorCompra(22000);
        ingreso.setDescripcion(ingreso.getDescripcion() + "(modificado)");

        ingresoMateriaPrimaDao.save(ingreso);

        // Detail
        h2(writer, "Obtener Ingreso de Materia Prima con id " + ingreso.getId() + ":");
        IngresoInsumo ingreso2 = ingresoMateriaPrimaDao.getById(ingreso.getId());
        item(writer, ingreso2);

 */
    }

}
