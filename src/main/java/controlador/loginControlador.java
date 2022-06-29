/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import conexion.conexionDB;
import conexion.validar;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.usuario;

/**
 *
 * @author luis
 */
@WebServlet(name = "loginControlador", urlPatterns = {"/loginControlador"})
public class loginControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");
        try {
            Connection cn;
            PreparedStatement ps;
            ResultSet rs;
            conexionDB canal = new conexionDB();    //validar validar = new validar();
            cn = canal.conectar();
            ps = cn.prepareStatement("select * from usuarios where correo = ? and password = sha1(?)");
            ps.setString(1, correo);
            ps.setString(2, password);
            rs = ps.executeQuery();
            usuario usu = new usuario();

            if (rs.next()) {   //if (validar.revisarUsuario(correo, password))
                //System.out.println("todo ok");
                HttpSession session = request.getSession(false);
                
                int numeroRol = rs.getInt("idRol");
                String nombres = rs.getString("nombres")+" "+rs.getString("apellidos");

                session.setAttribute("rol", numeroRol);
                session.setAttribute("nombres", nombres);
                session.setAttribute("logueado", "ok");
                
                request.getRequestDispatcher("index.jsp").forward(request, response);

            } else {
                //System.out.println("incorrecto");
                response.sendRedirect("login.jsp");
            }
        } catch (Exception e) {
            System.out.println("error en la conexion a la base de datos " + e.getMessage());
        }

    }
}
