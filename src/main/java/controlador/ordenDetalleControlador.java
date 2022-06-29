package controlador;

import dao.ordenDao;
import dao.ordenDaoDetalle;
import dao.ordenDaoDetalleImplementacion;
import dao.ordenDaoImplementacion;
import dao.productoDao;
import dao.productoDaoImplementacion;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.orden;
import modelo.ordenDetalle;
import modelo.producto;

/**
 *
 * @author luis
 */
@WebServlet(name = "ordenDetalleControlador", urlPatterns = {"/ordenDetalleControlador"})
public class ordenDetalleControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            productoDao daoPro = new productoDaoImplementacion();
            ordenDao daoOrd = new ordenDaoImplementacion();
            ordenDaoDetalle daoOrdd = new ordenDaoDetalleImplementacion();

            List<orden> listaOrd = null;
            List<producto> listaPro = null;

            orden ord = new orden();
            producto pro = new producto();
            ordenDetalle ordd = new ordenDetalle();

            int id;
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "insert":
                    listaPro = daoPro.getAll();
                    listaOrd = daoOrd.getAll();
                    request.setAttribute("listaPro", listaPro);
                    request.setAttribute("listaOrd", listaOrd);
                    request.setAttribute("ordenDetalle", ordd);
                    request.getRequestDispatcher("formOrdenesDetalle.jsp").forward(request, response);
                    break;
                case "update":
                    listaPro = daoPro.getAll();
                    listaOrd = daoOrd.getAll();
                    request.setAttribute("listaPro", listaPro);
                    request.setAttribute("listaOrd", listaOrd);
                    id = Integer.parseInt(request.getParameter("id"));
                    ordd = daoOrdd.getById(id);
                    request.setAttribute("ordenDetalle", ordd);
                    request.getRequestDispatcher("formOrdenesDetalle.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    daoOrdd.delete(id);
                    response.sendRedirect("ordenDetalleControlador");
                    break;
                case "view":
                    List<ordenDetalle> listaOrdd = daoOrdd.getAll();
                    request.setAttribute("ordenDetalle", listaOrdd);
                    request.getRequestDispatcher("ordenesDetalle.jsp").forward(request, response);
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
            
            ordenDetalle ordd = new ordenDetalle();
            ordenDaoDetalle dao = new ordenDaoDetalleImplementacion();

            int id = Integer.parseInt(request.getParameter("id"));
            int idOrden = Integer.parseInt(request.getParameter("idOrden"));
            int idProducto = Integer.parseInt(request.getParameter("idProducto"));
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            Float precio = Float.parseFloat(request.getParameter("precio"));
            String fecha = request.getParameter("fecha");

            ordd.setId(id);
            ordd.setIdOrden(idOrden);
            ordd.setIdProducto(idProducto);
            ordd.setCantidad(cantidad);
            ordd.setPrecio(precio);
            ordd.setFecha(convierteFecha(fecha));

            if (id == 0) {
                dao.insert(ordd);
            } else {
                dao.update(ordd);
            }
            
                response.sendRedirect("ordenDetalleControlador");
 
            
        } catch (Exception e) {
            System.out.println("Error en el metodo POST" + e.getMessage());
        }
    }

    public Date convierteFecha(String fecha) {
        Date fechaBD = null;
        try {

            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date FechaTemporal;
            FechaTemporal = formato.parse(fecha);
            fechaBD = new Date(FechaTemporal.getTime());

        } catch (Exception e) {
            System.out.println("Error en la conversion de la fecha" + e.getMessage());
        }
        return fechaBD;
    }

}
