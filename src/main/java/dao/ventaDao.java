
package dao;
import java.util.List;
import modelo.venta;

public interface ventaDao {
    public void insert(venta venta) throws Exception;
    public void update(venta venta) throws Exception;
    public void delete(int id) throws Exception;
    public venta getById(int id) throws Exception;
    public List<venta> getAll() throws Exception;
}
