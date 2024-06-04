import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import testsServlets.TestIngresoInsumo;
import testsServlets.TestInsumo;
import testsServlets.TestMateriaPrima;
import testsServlets.TestReceta;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class TestingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public TestingServlet() {
        super();
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

        //TestUsuario.test(writer);
        //TestFamiliaProductora.test(writer);
        //TestPuntoVenta.test(writer);
        //TestInsumo.test(writer);
        //TestIngresoInsumo.test(writer);
        //
        // TestMateriaPrima.test(writer);
        TestReceta.test(writer);
    }

    protected void addBootstrap(PrintWriter writer, PrintWriterConsumer action) {

        writer.println("<!DOCTYPE html>");
        writer.println("<html lang='en' data-bs-theme=\"light\" style='font-size: 12px;'>");
        writer.println("<head>");
        writer.println("<meta charset='UTF-8'>");
        writer.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        writer.println("<title>Sala de Elaboracion</title>");

        // Enlace al CSS de Bootstrap
        writer.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">\n");
        writer.println("</head>");
        writer.println("<body class=\"p-4 d-flex flex-column gap-2 \" style='gap:10px;'>");

        try {
            action.accept(writer);
        } catch (Exception e) {
            writer.println("<h1>Se ha producido un error</h1>");
            e.printStackTrace();
            writer.println(Arrays.toString(e.getStackTrace()));

        }

        // Configurar script de bootstrap
        writer.println(" <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz\" crossorigin=\"anonymous\"></script>");
        writer.println("</body>");
        writer.println("</html>");
        writer.close();

    }

}
