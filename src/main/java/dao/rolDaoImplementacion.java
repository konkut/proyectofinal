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
import modelo.rol;

/**
 *
 * @author luis
 */
public class rolDaoImplementacion extends conexionDB implements rolDao {

    @Override
    public void insert(rol rol) throws Exception {
        try {
            this.conectar();
            String sql = "insert into roles (nombre) values (?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, rol.getNombre());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(rol rol) throws Exception {
        try {
            this.conectar();
            String sql = "update roles set nombre = ? where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, rol.getNombre());
            ps.setInt(2, rol.getId());
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
            String sql = "delete from roles where id = ?";
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
    public List<rol> getAll() throws Exception {
        try {
            this.conectar();
            String sql = "select * from roles";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<rol> lista = null;
            lista = new ArrayList<rol>();
            while (rs.next()) {
                rol rl = new rol();
                rl.setId(rs.getInt("id"));
                rl.setNombre(rs.getString("nombre"));
                lista.add(rl);
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
    public rol getById(int id) throws Exception {
        try {
            this.conectar();
            String sql = "select * from roles where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            rol rl = new rol();
            if (rs.next()) {
                rl.setId(rs.getInt("id"));
                rl.setNombre(rs.getString("nombre"));
            }
            rs.close();
            ps.close();
            return rl;
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }
}
