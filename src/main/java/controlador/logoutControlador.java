/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import com.mysql.cj.jdbc.interceptors.SessionAssociationInterceptor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author luis
 */
@WebServlet(name = "logoutControlador", urlPatterns = {"/logoutControlador"})
public class logoutControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String salirSesion = (request.getParameter("action") == null) ? "view" : request.getParameter("action");
        if (salirSesion.equals("logout")) {
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect("login.jsp");
        }

    }

}
