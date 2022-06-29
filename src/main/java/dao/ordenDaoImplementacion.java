/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.conexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.orden;

public class ordenDaoImplementacion extends conexionDB implements ordenDao{
    

    public void insert(orden orden) throws Exception {
        try {
            this.conectar();
            String sql = "insert into ordenes (idCliente,idDomicilio,metodoPago,total) values(?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, orden.getIdCliente());
            ps.setInt(2, orden.getIdDomicilio());
            ps.setString(3, orden.getMetodoPago());
            ps.setFloat(4, orden.getTotal());
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    public void update(orden orden) throws Exception {
        try {
            this.conectar();
            String sql = "update ordenes set idCliente = ?,idDomicilio = ?,metodoPago = ? ,total = ? where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, orden.getIdCliente());
            ps.setInt(2, orden.getIdDomicilio());
            ps.setString(3, orden.getMetodoPago());
            ps.setFloat(4, orden.getTotal());
            ps.setInt(5, orden.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "delete from ordenes where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    public orden getById(int id) throws Exception {
        try {
            this.conectar();
            String sql = "select * from ordenes where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            orden ord = new orden();
            if (rs.next()) {
                ord.setId(rs.getInt("id"));
                ord.setIdCliente(rs.getInt("idCliente"));
                ord.setIdDomicilio(rs.getInt("idDomicilio"));
                ord.setMetodoPago(rs.getString("metodoPago"));
                ord.setTotal(rs.getFloat("total"));
            }
            return ord;
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    public List<orden> getAll() throws Exception {
        try {
            this.conectar();
            String sql = "select o.*,c.nombre as cliente, (concat(ciudad,', ', calle,', ', nroPuerta)) as domicilio ";
            sql += "from clientes c,ordenes o,domicilios d ";
            sql += "where c.id = o.idCliente and d.id = o.idDomicilio;";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<orden> lista = null;
            lista = new ArrayList<orden>();
            while (rs.next()) {
                orden ord = new orden();
                ord.setId(rs.getInt("id"));
                ord.setIdCliente(rs.getInt("idCliente"));
                ord.setIdDomicilio(rs.getInt("idDomicilio"));
                ord.setMetodoPago(rs.getString("metodoPago"));
                ord.setTotal(rs.getFloat("total"));
                ord.setCliente(rs.getString("cliente"));
                ord.setDomicilio(rs.getString("domicilio"));
                lista.add(ord);
            }
            ps.close();
            rs.close();
            return lista;
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

}
