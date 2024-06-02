package testsServlets;

import dao.FactoryDAO;
import dao.interfaces.IUsuarioDao;
import grupo17.Administrador;
import grupo17.EncargadoDeSala;
import grupo17.Usuario;

import java.io.PrintWriter;
import java.util.List;

public class TestUsuario extends BaseTest{

    public static void test(PrintWriter writer) {
        IUsuarioDao usuarioDao = FactoryDAO.createUsuarioDao();
        // ============================== ENTIDAD: FAMILIA PRODUCTORA =======================================
        h1(writer, "Usuarios");

        Usuario u = new Administrador("Ad", "Min", "admin", "asdasd123", "admin@test.com");
        List<Usuario> us;

        // CREATE
        h2(writer, "↳ Se creara un nuevo usuario Administrador: ");
        usuarioDao.save(u);

        item(writer, u);

        // CREATE
        h2(writer, "↳ Se creara un nuevo usuario Encargado de Sala: ");
        Usuario es = new EncargadoDeSala("Encargado", "Sala", "encargadosala", "asdasd123", "encargado@test.com");
        usuarioDao.save(es);

        item(writer, es);

        // LIST
        h2(writer, "Listado de Usuarios: ");
        us = usuarioDao.getAll();
        list(writer, us);

        h2(writer, "↳ Se modificará el usuario con id: " + u.getId());
        // UPDATE
        u.setNombre("Ad (modificado)");
        u.setApellido("Min (modificado)");
        usuarioDao.save(u);

        // LIST
        h2(writer, "Obtener Usuario con id " + u.getId() + ":");
        Usuario u2 = usuarioDao.getById(u.getId());
        item(writer, u2);
    }
}
