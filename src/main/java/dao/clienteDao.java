
package dao;

import java.util.List;
import modelo.cliente;

public interface clienteDao {
    public void insert(cliente cliente) throws Exception;
    public void update(cliente cliente) throws Exception;
    public void delete(int id) throws Exception;
    public cliente getById(int id) throws Exception;
    public List<cliente> getAll() throws Exception;
}
