package dao;

import conexion.conexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.ordenDetalle;

public class ordenDaoDetalleImplementacion extends conexionDB implements ordenDaoDetalle {

    public void insert(ordenDetalle ordenDetalle) throws Exception {
        try {
            this.conectar();
            String sql = "insert into ordenesDetalle (idOrden,idProducto,cantidad,precio,fecha) values(?,?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, ordenDetalle.getIdOrden());
            ps.setInt(2, ordenDetalle.getIdProducto());
            ps.setInt(3, ordenDetalle.getCantidad());
            ps.setFloat(4, ordenDetalle.getPrecio());
            ps.setDate(5, ordenDetalle.getFecha());
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    public void update(ordenDetalle ordenDetalle) throws Exception {
        try {
            this.conectar();
            String sql = "update ordenesDetalle set idOrden = ?,idProducto = ?,cantidad = ?,precio = ?,fecha= ? where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, ordenDetalle.getIdOrden());
            ps.setInt(2, ordenDetalle.getIdProducto());
            ps.setInt(3, ordenDetalle.getCantidad());
            ps.setFloat(4, ordenDetalle.getPrecio());
            ps.setDate(5, ordenDetalle.getFecha());
            ps.setInt(6, ordenDetalle.getId());
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
            String sql = "delete from ordenesDetalle where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    public ordenDetalle getById(int id) throws Exception {
        try {
            this.conectar();
            String sql = "select * from ordenesDetalle where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            ordenDetalle ordd = new ordenDetalle();
            if (rs.next()) {
                ordd.setId(rs.getInt("id"));
                ordd.setIdOrden(rs.getInt("idOrden"));
                ordd.setIdProducto(rs.getInt("idProducto"));
                ordd.setCantidad(rs.getInt("cantidad"));
                ordd.setPrecio(rs.getInt("precio"));
                ordd.setFecha(rs.getDate("fecha"));
            }
            return ordd;
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    public List<ordenDetalle> getAll() throws Exception {
        try {
            this.conectar();
            String sql = "select od.*, nombre as producto ";
            sql += "from ordenesDetalle od, ordenes o, productos p ";
            sql += "where od.idOrden = o.id and od.idProducto = p.id;";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<ordenDetalle> lista = null;
            lista = new ArrayList<ordenDetalle>();
            while (rs.next()) {
                ordenDetalle ordd = new ordenDetalle();
                ordd.setId(rs.getInt("id"));
                ordd.setIdOrden(rs.getInt("idOrden"));
                ordd.setIdProducto(rs.getInt("idProducto"));
                ordd.setCantidad(rs.getInt("cantidad"));
                ordd.setPrecio(rs.getInt("precio"));
                ordd.setFecha(rs.getDate("fecha"));
                ordd.setProducto(rs.getString("producto"));
                lista.add(ordd);
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
