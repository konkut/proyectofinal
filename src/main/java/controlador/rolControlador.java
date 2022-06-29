/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.rolDao;
import dao.rolDaoImplementacion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.rol;

@WebServlet(name = "rolControlador", urlPatterns = {"/rolControlador"})
public class rolControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            rolDao dao = new rolDaoImplementacion();
            rol rol = new rol();
            int id;
            String action = (request.getParameter("action") == null) ? "view" : request.getParameter("action");
            switch (action) {
                case "insert":
                    request.setAttribute("rol", rol);
                    request.getRequestDispatcher("formRoles.jsp").forward(request, response);
                    break;
                case "update":
                    id = Integer.parseInt(request.getParameter("id"));
                    rol = dao.getById(id);
                    request.setAttribute("rol", rol);
                    request.getRequestDispatcher("formRoles.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("rolControlador");
                    break;
                case "view":
                    List<rol> roles = dao.getAll();
                    request.setAttribute("roles", roles);
                    request.getRequestDispatcher("roles.jsp").forward(request, response);
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
            rolDao dao = new rolDaoImplementacion();
            rol rol = new rol();
            
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            rol.setId(id);
            rol.setNombre(nombre);
            
            if (id == 0) {
                //nuevo registro => objeto vacio id = 0
                dao.insert(rol);
            } else {
                //modificar registro => objeto con datos  id = 1,2,3,4...
                dao.update(rol);
            }
            response.sendRedirect("rolControlador");
        } catch (Exception e) {
            System.out.println("Error en el metodo POST" + e.getMessage());
        }
    }

   

}
