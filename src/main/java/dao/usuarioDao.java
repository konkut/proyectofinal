
package dao;

import java.util.List;
import modelo.usuario;

public interface usuarioDao {
    public void insert(usuario usuario) throws Exception;
    public void update(usuario usuario) throws Exception;
    public void delete(int id) throws Exception;
    public usuario getById(int id) throws Exception;
    public List<usuario> getAll() throws Exception;
}
