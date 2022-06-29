package controlador;

import dao.clienteDao;
import dao.clienteDaoImplementacion;
import dao.domicilioDao;
import dao.domicilioDaoImplementacion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.cliente;
import modelo.domicilio;

@WebServlet(name = "domicilioControlador", urlPatterns = {"/domicilioControlador"})
public class domicilioControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            domicilioDao daoDom = new domicilioDaoImplementacion();
            clienteDao daoCli = new clienteDaoImplementacion();

            List<cliente> listaCli = null;

            domicilio dom = new domicilio();
            cliente cli = new cliente();

            int id;
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "insert":
                    listaCli = daoCli.getAll();
                    request.setAttribute("listaCli", listaCli);
                    request.setAttribute("domicilio", dom);
                    request.getRequestDispatcher("formDomicilios.jsp").forward(request, response);
                    break;
                case "update":
                    listaCli = daoCli.getAll();
                    request.setAttribute("listaCli", listaCli);
                    id = Integer.parseInt(request.getParameter("id"));
                    dom = daoDom.getById(id);
                    request.setAttribute("domicilio", dom);
                    request.getRequestDispatcher("formDomicilios.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    daoDom.delete(id);
                    response.sendRedirect("domicilioControlador");
                    break;
                case "view":
                    List<domicilio> listaDom = daoDom.getAll();
                    request.setAttribute("domicilios", listaDom);
                    request.getRequestDispatcher("domicilios.jsp").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
        } catch (Exception e) {
            System.out.println("Error en el metodo GET" + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String user = (request.getParameter("user") != null) ? request.getParameter("user") : "view";
            domicilio dom = new domicilio();
            domicilioDao dao = new domicilioDaoImplementacion();

            int id = Integer.parseInt(request.getParameter("id"));
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));
            String nroPuerta = request.getParameter("nroPuerta");
            String calle = request.getParameter("calle");
            String ciudad = request.getParameter("ciudad");
            String departamento = request.getParameter("departamento");

            dom.setId(id);
            dom.setIdCliente(idCliente);
            dom.setNroPuerta(nroPuerta);
            dom.setCalle(calle);
            dom.setCiudad(ciudad);
            dom.setDepartamento(departamento);

            if (id == 0) {
                dao.insert(dom);
            } else {
                dao.update(dom);
            }
            if (user.equals("domicilio")) {
                response.sendRedirect("compra.jsp");
            } else {
                response.sendRedirect("domicilioControlador");
            }

        } catch (Exception e) {
            System.out.println("Error en el metodo POST" + e.getMessage());
        }
    }

}
