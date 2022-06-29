/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.clienteDao;
import dao.clienteDaoImplementacion;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.cliente;

@WebServlet(name = "clienteControlador", urlPatterns = {"/clienteControlador"})
public class clienteControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            clienteDao dao = new clienteDaoImplementacion();
            cliente cli = new cliente();
            int id;
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
           
            switch (action) {
                case "insert":
                        request.setAttribute("cliente", cli);
                        request.getRequestDispatcher("formClientes.jsp").forward(request, response);
                    break;
                case "update":
                    id = Integer.parseInt(request.getParameter("id"));
                    cli = dao.getById(id);
                    request.setAttribute("cliente", cli);
                    request.getRequestDispatcher("formClientes.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("clienteControlador");
                    break;
                case "view":
         
                        List<cliente> listaClientes = new ArrayList<cliente>();
                        listaClientes = dao.getAll();
                        request.setAttribute("clientes", listaClientes);
                        request.getRequestDispatcher("clientes.jsp").forward(request, response);
             

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
            cliente cli = new cliente();
            clienteDao dao = new clienteDaoImplementacion();

            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String correo = request.getParameter("correo");
            String celular = request.getParameter("celular");
            cli.setId(id);
            cli.setNombre(nombre);
            cli.setCorreo(correo);
            cli.setCelular(celular);
            if (id == 0) {
                //nuevo registro => objeto vacio id = 0
                dao.insert(cli);
            } else {
                //modificar registro => objeto con datos  id = 1,2,3,4...
                dao.update(cli);
            }
            if(user.equals("nuevo")){
            response.sendRedirect("domicilioControlador?action=insert");  
            }else{
            response.sendRedirect("clienteControlador");
            }

        } catch (Exception e) {
            System.out.println("Error en el metodo POST" + e.getMessage());
        }
    }

}
