package dao;

import conexion.conexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.domicilio;

public class domicilioDaoImplementacion extends conexionDB implements domicilioDao {

    public void insert(domicilio domicilio) throws Exception {
        try {
            this.conectar();
            String sql = "insert into domicilios (idCliente,nroPuerta,calle,ciudad,departamento) values (?,?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, domicilio.getIdCliente());
            ps.setString(2, domicilio.getNroPuerta());
            ps.setString(3, domicilio.getCalle());
            ps.setString(4, domicilio.getCiudad());
            ps.setString(5, domicilio.getDepartamento());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
        }
    }

    public void update(domicilio domicilio) throws Exception {
        try {
            this.conectar();
            String sql = "update domicilios set idCliente = ?, nroPuerta = ?, calle = ?, ciudad = ?, departamento = ? where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, domicilio.getIdCliente());
            ps.setString(2, domicilio.getNroPuerta());
            ps.setString(3, domicilio.getCalle());
            ps.setString(4, domicilio.getCiudad());
            ps.setString(5, domicilio.getDepartamento());
            ps.setInt(6, domicilio.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
        }
    }

    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "delete from domicilios where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
        }
    }

    public domicilio getById(int id) throws Exception {
        try {
            this.conectar();
            String sql = "select * from domicilios where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            domicilio dom = new domicilio();
            while (rs.next()) {
                dom.setId(rs.getInt("id"));
                dom.setIdCliente(rs.getInt("idCliente"));
                dom.setNroPuerta(rs.getString("nroPuerta"));
                dom.setCalle(rs.getString("calle"));
                dom.setCiudad(rs.getString("ciudad"));
                dom.setDepartamento(rs.getString("departamento"));
            }
            rs.close();
            ps.close();
            return dom;
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
        }
    }

    public List<domicilio> getAll() throws Exception {
        try {
            this.conectar();
            String sql = "select d.*, c.nombre as cliente ";
            sql += "from domicilios d, clientes c ";
            sql += "where d.idCliente = c.id;";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<domicilio> lista = null;
            lista = new ArrayList<domicilio>();
            while (rs.next()) {
                domicilio dom = new domicilio();
                dom.setId(rs.getInt("id"));
                dom.setIdCliente(rs.getInt("idCliente"));
                dom.setNroPuerta(rs.getString("nroPuerta"));
                dom.setCalle(rs.getString("calle"));
                dom.setCiudad(rs.getString("ciudad"));
                dom.setDepartamento(rs.getString("departamento"));
                dom.setCliente(rs.getString("cliente"));
                lista.add(dom);
            }
            rs.close();
            ps.close();
            return lista;
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
        }

    }
}
