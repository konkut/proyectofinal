
package controlador;

import dao.usuarioDao;
import dao.usuarioDaoImplementacion;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.usuario;

@WebServlet(name = "usuarioControlador", urlPatterns = {"/usuarioControlador"})
public class usuarioControlador extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            usuarioDao dao = new usuarioDaoImplementacion();
            usuario usuario = new usuario();
            int id;
            String action = (request.getParameter("action") == null) ? "view" : request.getParameter("action");
            switch (action) {
                case "insert":
                    request.setAttribute("usuario", usuario);
                    request.getRequestDispatcher("formUsuarios.jsp").forward(request, response);
                    break;
                case "update":
                    id = Integer.parseInt(request.getParameter("id"));
                    usuario = dao.getById(id);
                    request.setAttribute("usuario", usuario);
                    request.getRequestDispatcher("formUsuarios.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("usuarioControlador");
                    break;
                case "view":
                    List<usuario> usuarios = dao.getAll();
                    request.setAttribute("usuarios", usuarios);
                    request.getRequestDispatcher("usuarios.jsp").forward(request, response);
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
            usuario usuario = new usuario();
            usuarioDao dao = new usuarioDaoImplementacion();
            
            int id = Integer.parseInt(request.getParameter("id"));
            String nombres = request.getParameter("nombres");
            String apellidos = request.getParameter("apellidos");
            String correo = request.getParameter("correo");
            String password = request.getParameter("password");
            int idRol = Integer.parseInt(request.getParameter("idRol"));
            usuario.setId(id);
            usuario.setNombres(nombres);
            usuario.setApellidos(apellidos);
            usuario.setCorreo(correo);
            usuario.setPassword(password);
            usuario.setIdRol(idRol);
            
            if (id == 0) {
                //nuevo registro => objeto vacio id = 0
                dao.insert(usuario);
            } else {
                //modificar registro => objeto con datos  id = 1,2,3,4...
                dao.update(usuario);
            }
            response.sendRedirect("usuarioControlador");
        } catch (Exception e) {
            System.out.println("Error en el metodo POST" + e.getMessage());
        }
    }
    
}
