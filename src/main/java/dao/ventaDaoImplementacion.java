package dao;

import conexion.conexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.venta;

public class ventaDaoImplementacion extends conexionDB implements ventaDao {

    public void insert(venta venta) throws Exception {
        try {
            this.conectar();
            String sql = "insert into ventas (producto_id,cliente_id,fecha) values(?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, venta.getProducto_id());
            ps.setInt(2, venta.getCliente_id());
            ps.setDate(3, venta.getFecha());
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    public void update(venta venta) throws Exception {
        try {
            this.conectar();
            String sql = "update ventas set producto_id = ?,cliente_id = ?,fecha = ? where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, venta.getProducto_id());
            ps.setInt(2, venta.getCliente_id());
            ps.setDate(3, venta.getFecha());
            ps.setInt(4, venta.getId());
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
            String sql = "delete from ventas where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    public venta getById(int id) throws Exception {
        try {
            this.conectar();
            String sql = "select * from ventas where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            venta ven = new venta();
            if (rs.next()) {
                ven.setId(rs.getInt("id"));
                ven.setProducto_id(rs.getInt("producto_id"));
                ven.setCliente_id(rs.getInt("cliente_id"));
                ven.setFecha(rs.getDate("fecha"));
            }
            return ven;
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    public List<venta> getAll() throws Exception {
        try {
            this.conectar();
            String sql = "select v.*, p.nombre as producto, c.nombre as cliente ";
            sql += "from productos p, clientes c, ventas v ";
            sql += "where p.id = v.producto_id and c.id = v.cliente_id;";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<venta> lista = null;
            lista = new ArrayList<venta>();
            while (rs.next()) {
                venta ven = new venta();
                ven.setId(rs.getInt("id"));
                ven.setProducto_id(rs.getInt("producto_id"));
                ven.setCliente_id(rs.getInt("cliente_id"));
                ven.setFecha(rs.getDate("fecha"));
                ven.setProducto(rs.getString("producto"));
                ven.setCliente(rs.getString("cliente"));
                lista.add(ven);
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
