
package dao;

import java.util.List;
import modelo.producto;

public interface productoDao {
    public void insert(producto producto) throws Exception;
    public void update(producto producto) throws Exception;
    public void delete(int id) throws Exception;
    public producto getById(int id) throws Exception;
    public List<producto> getAll() throws Exception;
}
