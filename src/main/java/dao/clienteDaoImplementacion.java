package dao;

import conexion.conexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.cliente;

public class clienteDaoImplementacion extends conexionDB implements clienteDao {

    @Override
    public void insert(cliente cliente) throws Exception {
        try {
            this.conectar();
            String sql = "insert into clientes (nombre,correo,celular) values (?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getCorreo());
            ps.setString(3, cliente.getCelular());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(cliente cliente) throws Exception {
        try {
            this.conectar();
            String sql = "update clientes set nombre = ?, correo = ?, celular = ? where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getCorreo());
            ps.setString(3, cliente.getCelular());
            ps.setInt(4, cliente.getId());
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
            String sql = "delete from clientes where id = ?";
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
    public List<cliente> getAll() throws Exception {
        try {
            this.conectar();
            String sql = "select * from clientes";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            //instanciamos el objeto
            List<cliente> lista = null;
            //inicializamos la coleccion
            lista = new ArrayList<cliente>();
            while (rs.next()) {
                cliente cli = new cliente();
                cli.setId(rs.getInt("id"));
                cli.setNombre(rs.getString("nombre"));
                cli.setCorreo(rs.getString("correo"));
                cli.setCelular(rs.getString("celular"));
                lista.add(cli);
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
    public cliente getById(int id) throws Exception {
        try {
            this.conectar();
            String sql = "select * from clientes where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            cliente cli = new cliente();
            while (rs.next()) {
                cli.setId(rs.getInt("id"));
                cli.setNombre(rs.getString("nombre"));
                cli.setCorreo(rs.getString("correo"));
                cli.setCelular(rs.getString("celular"));
            }
            rs.close();
            ps.close();
            return cli;
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }
}
