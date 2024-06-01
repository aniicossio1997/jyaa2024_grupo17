import dao.FactoryDAO;
import dao.IFamiliaProductoraDao;
import grupo17.FamiliaProductora;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class HelloWorld
 */
public class HelloWorldServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final IFamiliaProductoraDao familiaProductoraDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorldServlet() {
        super();
        this.familiaProductoraDao = FactoryDAO.createFamiliaProductoraDao();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        List<FamiliaProductora> fps = this.familiaProductoraDao.getAll();

        response.getWriter().append("Listado de Familias Productoras: ");

        for (FamiliaProductora fa : fps) {
            response.getWriter().append(fa.toString());
        }

        response.getWriter().append("Se creara una nueva familia");

        FamiliaProductora fp = new FamiliaProductora("familia 1", "gran familia");
        this.familiaProductoraDao.save(fp);

        response.getWriter().append(fp.toString());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
