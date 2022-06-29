/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.productoDao;
import dao.productoDaoImplementacion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.producto;

/**
 *
 * @author luis
 */
@WebServlet(name = "productoControlador", urlPatterns = {"/productoControlador"})
public class productoControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            productoDao dao = new productoDaoImplementacion();
            producto producto = new producto();
            int id;
            String action = (request.getParameter("action") == null) ? "view" : request.getParameter("action");
            switch (action) {
                case "insert":
                    request.setAttribute("producto", producto);
                    request.getRequestDispatcher("formProductos.jsp").forward(request, response);
                    break;
                case "update":
                    id = Integer.parseInt(request.getParameter("id"));
                    producto = dao.getById(id);
                    request.setAttribute("producto", producto);
                    request.getRequestDispatcher("formProductos.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("productoControlador");
                    break;
                case "view":
                    List<producto> listaPro = dao.getAll();
                    request.setAttribute("listaPro", listaPro);
                    request.getRequestDispatcher("productos.jsp").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
        } catch (Exception e) {
            System.out.println("error en el metodo get " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            producto producto = new producto();
            productoDao dao = new productoDaoImplementacion();

            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            Float precio = Float.parseFloat(request.getParameter("precio"));
            producto.setId(id);
            producto.setNombre(nombre);
            producto.setDescripcion(descripcion);
            producto.setPrecio(precio);
            if (id == 0) {
                //nuevo registro => objeto vacio id = 0
                dao.insert(producto);
            } else {
                //modificar registro => objeto con datos  id = 1,2,3,4...
                dao.update(producto);
            }
            response.sendRedirect("productoControlador");
        } catch (Exception e) {
            System.out.println("Error en el metodo POST" + e.getMessage());
        }
    }
}
