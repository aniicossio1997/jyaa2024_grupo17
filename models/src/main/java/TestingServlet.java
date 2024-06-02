import dao.FactoryDAO;
import dao.IFamiliaProductoraDao;
import grupo17.FamiliaProductora;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class TestingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final IFamiliaProductoraDao familiaProductoraDao;

    public TestingServlet() {
        super();
        this.familiaProductoraDao = FactoryDAO.createFamiliaProductoraDao();
    }

    @FunctionalInterface
    interface PrintWriterConsumer {
        void accept(PrintWriter writer) throws IOException;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        addBootstrap(writer, this::testEntities);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

    protected void testEntities(PrintWriter writer) {
        // ============================== ENTIDAD: FAMILIA PRODUCTORA =======================================
        this.h1(writer, "Familia Productora");

        FamiliaProductora fp = new FamiliaProductora("familia 1", "Descripcion familia 1");
        List<FamiliaProductora> fps;

        // CREATE
        this.h2(writer, "↳ Se creara una nueva familia: ");
        this.familiaProductoraDao.save(fp);

        this.item(writer, fp);

        // LIST
        this.h2(writer, "Listado de Familias Productoras: ");
        fps = this.familiaProductoraDao.getAll();
        this.list(writer, fps);

        this.h2(writer, "↳ Se modificará la Familia Productora con id " + fp.getId());
        // UPDATE
        fp.setNombre("Familia 1 (modificada)");
        fp.setDescripcion("Descripcion familia 1 (modificada)");
        this.familiaProductoraDao.save(fp);

        // LIST
        this.h2(writer, "Obtener Familia Productora con id " + fp.getId() + ":");
        FamiliaProductora fp2 = this.familiaProductoraDao.getById(fp.getId());
        this.item(writer, fp2);
    }

    // ============================== METODOS UTILITARIOS =======================================

    protected void h1(PrintWriter writer, Object content) {
        writer.append("<h1 class='p-3 bg-primary text-white'>").append(content.toString()).append("</h1>");
    }

    protected void h2(PrintWriter writer, Object content) {
        writer.append("<h2>").append(content.toString()).append("</h2>");
    }

    protected void item(PrintWriter writer, Object content) {
        writer.append("<span  class=\"list-group-item\">").append(content.toString()).append("</span>");

    }

    protected void list(PrintWriter writer, List<?> content) {
        writer.append("<ul class=\"list-group\">");
        for (Object item : content) {
            writer.append("<li  class=\"list-group-item\">").append(item.toString()).append("</li>");
        }
        writer.append("</ul>");
    }


    protected void addBootstrap(PrintWriter writer, PrintWriterConsumer action) {

        writer.println("<!DOCTYPE html>");
        writer.println("<html lang='en' data-bs-theme=\"light\">");
        writer.println("<head>");
        writer.println("<meta charset='UTF-8'>");
        writer.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        writer.println("<title>Sala de Elaboracion</title>");

        // Enlace al CSS de Bootstrap
        writer.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">\n");
        writer.println("</head>");
        writer.println("<body class=\"p-4 d-flex flex-column gap-2 \" style='gap:10px'>");

        try {
            action.accept(writer);
        } catch (Exception e) {
            writer.println("<h1>Se ha producido un error</h1>");
            writer.println(Arrays.toString(e.getStackTrace()));

        }

        // Configurar script de bootstrap
        writer.println(" <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz\" crossorigin=\"anonymous\"></script>");
        writer.println("</body>");
        writer.println("</html>");
        writer.close();

    }

}
