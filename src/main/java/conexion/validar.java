package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class validar extends conexionDB {

    Connection conn = this.conectar();

    public boolean revisarUsuario(String email, String password) {
        boolean res = false;
        try {
            String sql = "select * from usuarios where email = ? and password = sha1(?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            res = rs.next();
        } catch (Exception e) {
            System.out.println("error en validar " + e.getMessage());
        }
        return res;
    }
}
