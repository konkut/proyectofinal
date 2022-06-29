/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.clienteDao;
import dao.clienteDaoImplementacion;
import dao.productoDao;
import dao.productoDaoImplementacion;
import dao.ventaDao;
import dao.ventaDaoImplementacion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.cliente;
import modelo.producto;
import modelo.venta;

/**
 *
 * @author luis
 */
@WebServlet(name = "ventaControlador", urlPatterns = {"/ventaControlador"})
public class ventaControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            productoDao daoPro = new productoDaoImplementacion();
            clienteDao daoCli = new clienteDaoImplementacion();
            ventaDao daoVen = new ventaDaoImplementacion();

            List<producto> listaPro = null;
            List<cliente> listaCli = null;

            producto pro = new producto();
            cliente cli = new cliente();
            venta ven = new venta();

            int id;
            String action = (request.getParameter("action") == null) ? "view" : request.getParameter("action");
            switch (action) {
                case "insert":
                    listaPro = daoPro.getAll();
                    listaCli = daoCli.getAll();
                    request.setAttribute("listaPro", listaPro);
                    request.setAttribute("listaCli", listaCli);
                    request.setAttribute("venta", ven);
                    request.getRequestDispatcher("formVentas.jsp").forward(request, response);
                    break;
                case "update":
                    listaPro = daoPro.getAll();
                    listaCli = daoCli.getAll();
                    request.setAttribute("listaPro", listaPro);
                    request.setAttribute("listaCli", listaCli);
                    id = Integer.parseInt(request.getParameter("id"));
                    ven = daoVen.getById(id);
                    request.setAttribute("venta", ven);
                    request.getRequestDispatcher("formVentas.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    daoVen.delete(id);
                    response.sendRedirect("ventaControlador");
                    break;
                case "view":
                    List<venta> listaVen = new ArrayList<venta>();
                    listaVen = daoVen.getAll();
                    request.setAttribute("ventas", listaVen);
                    request.getRequestDispatcher("ventas.jsp").forward(request, response);
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
            venta ven = new venta();
            ventaDao dao = new ventaDaoImplementacion();

            int id = Integer.parseInt(request.getParameter("id"));
            int cliente_id = Integer.parseInt(request.getParameter("cliente_id"));
            int producto_id = Integer.parseInt(request.getParameter("producto_id"));
            String fecha = request.getParameter("fecha");
            ven.setId(id);
            ven.setCliente_id(cliente_id);
            ven.setProducto_id(producto_id);
            ven.setFecha(convierteFecha(fecha));
            if (id == 0) {
                //nuevo registro => objeto vacio id = 0
                dao.insert(ven);
            } else {
                //modificar registro => objeto con datos  id = 1,2,3,4...
                dao.update(ven);
            }
            response.sendRedirect("ventaControlador");
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
