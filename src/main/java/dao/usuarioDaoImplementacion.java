
package dao;

import conexion.conexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.usuario;

public class usuarioDaoImplementacion extends conexionDB implements usuarioDao {

    @Override
    public void insert(usuario usuario) throws Exception {
        try {
            this.conectar();
            String sql = "insert into usuarios (nombres, apellidos,correo,password,idRol) values (?,?,?,sha1(?),?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, usuario.getNombres());
            ps.setString(2, usuario.getApellidos());
            ps.setString(3, usuario.getCorreo());
            ps.setString(4, usuario.getPassword());
            ps.setInt(5, usuario.getIdRol());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(usuario usuario) throws Exception {
        try {
            this.conectar();
            String sql = "update usuarios set nombres = ?,apellidos =?, correo = ?, password = sha1(?), idRol = ? where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, usuario.getNombres());
            ps.setString(2, usuario.getApellidos());
            ps.setString(3, usuario.getCorreo());
            ps.setString(4, usuario.getPassword());
            ps.setInt(5, usuario.getIdRol());
            ps.setInt(6, usuario.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "delete from usuarios where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<usuario> getAll() throws Exception {
        try {
            this.conectar();
            String sql = "select * from usuarios";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<usuario> lista = null;
            lista = new ArrayList<usuario>();
            while (rs.next()) {
                usuario usu = new usuario();
                usu.setId(rs.getInt("id"));
                usu.setNombres(rs.getString("nombres"));
                usu.setApellidos(rs.getString("apellidos"));
                usu.setCorreo(rs.getString("correo"));
                usu.setIdRol(rs.getInt("idRol"));
                lista.add(usu);
            }
            rs.close();
            ps.close();
            return lista;
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }

    }

    @Override
    public usuario getById(int id) throws Exception {
        try {
            this.conectar();
            String sql = "select * from usuarios where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            usuario usu = new usuario();
            if (rs.next()) {
                usu.setId(rs.getInt("id"));
                usu.setNombres(rs.getString("nombres"));
                usu.setApellidos(rs.getString("apellidos"));
                usu.setCorreo(rs.getString("correo"));
                usu.setIdRol(rs.getInt("idRol"));
            }
            rs.close();
            ps.close();
            return usu;
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }
}
