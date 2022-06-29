/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.clienteDao;
import dao.clienteDaoImplementacion;
import dao.domicilioDao;
import dao.domicilioDaoImplementacion;
import dao.ordenDao;
import dao.ordenDaoImplementacion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.cliente;
import modelo.domicilio;
import modelo.orden;

/**
 *
 * @author luis
 */
@WebServlet(name = "ordenControlador", urlPatterns = {"/ordenControlador"})
public class ordenControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            domicilioDao daoDom = new domicilioDaoImplementacion();
            clienteDao daoCli = new clienteDaoImplementacion();
            ordenDao daoOrd = new ordenDaoImplementacion();

            List<domicilio> listaDom = null;
            List<cliente> listaCli = null;

            domicilio dom = new domicilio();
            cliente cli = new cliente();
            orden ord = new orden();

            int id;
            String action = (request.getParameter("action") == null) ? "view" : request.getParameter("action");
            switch (action) {
                case "insert":
                    listaDom = daoDom.getAll();
                    listaCli = daoCli.getAll();
                    request.setAttribute("listaDom", listaDom);
                    request.setAttribute("listaCli", listaCli);
                    request.setAttribute("orden", ord);
                    request.getRequestDispatcher("formOrdenes.jsp").forward(request, response);
                    break;
                case "update":
                    listaDom = daoDom.getAll();
                    listaCli = daoCli.getAll();
                    request.setAttribute("listaDom", listaDom);
                    request.setAttribute("listaCli", listaCli);
                    id = Integer.parseInt(request.getParameter("id"));
                    ord = daoOrd.getById(id);
                    request.setAttribute("orden", ord);
                    request.getRequestDispatcher("formOrdenes.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    daoOrd.delete(id);
                    response.sendRedirect("ordenControlador");
                    break;
                case "view":
                    List<orden> listaOrd = new ArrayList<orden>();
                    listaOrd = daoOrd.getAll();
                    request.setAttribute("orden", listaOrd);
                    request.getRequestDispatcher("ordenes.jsp").forward(request, response);
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

            orden ord = new orden();
            ordenDao dao = new ordenDaoImplementacion();

            int id = Integer.parseInt(request.getParameter("id"));
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));
            int idDomicilio = Integer.parseInt(request.getParameter("idDomicilio"));
            String metodoPago = request.getParameter("metodoPago");
            Float total = Float.parseFloat(request.getParameter("total"));

            ord.setId(id);
            ord.setIdCliente(idCliente);
            ord.setIdDomicilio(idDomicilio);
            ord.setMetodoPago(metodoPago);
            ord.setTotal(total);
            if (id == 0) {
                dao.insert(ord);
            } else {
                dao.update(ord);
            }

                response.sendRedirect("ordenControlador");
           

        } catch (Exception e) {
            System.out.println("Error en el metodo POST" + e.getMessage());
        }

    }

}
