
package dao;
import conexion.conexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.producto;

public class productoDaoImplementacion extends conexionDB implements productoDao{
    
    @Override
    public void insert(producto producto) throws Exception {
        try {
            this.conectar();
            String sql = "insert into productos (nombre,descripcion,precio) values (?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setFloat(3, producto.getPrecio());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(producto producto) throws Exception {
        try {
            this.conectar();
            String sql = "update productos set nombre = ?, descripcion = ?, precio = ? where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setFloat(3, producto.getPrecio());
            ps.setInt(4, producto.getId());
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
            String sql = "delete from productos where id = ?";
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
    public List<producto> getAll() throws Exception {
        try {
            this.conectar();
            String sql = "select * from productos";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<producto> lista = null;
            lista = new ArrayList<producto>();
            while (rs.next()) {
                producto pro = new producto();
                pro.setId(rs.getInt("id"));
                pro.setNombre(rs.getString("nombre"));
                pro.setDescripcion(rs.getString("descripcion"));
                pro.setPrecio(rs.getFloat("precio"));
                lista.add(pro);
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
    public producto getById(int id) throws Exception {
        try {
            this.conectar();
            String sql = "select * from productos where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            producto pro = new producto();
            if (rs.next()) {
                pro.setId(rs.getInt("id"));
                pro.setNombre(rs.getString("nombre"));
                pro.setDescripcion(rs.getString("descripcion"));
                pro.setPrecio(rs.getFloat("precio"));
            }
            rs.close();
            ps.close();
            return pro;
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }
}
