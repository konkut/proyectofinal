/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import modelo.ordenDetalle;

public interface ordenDaoDetalle {
    public void insert(ordenDetalle ordenDetalle) throws Exception;
    public void update(ordenDetalle ordenDetalle) throws Exception;
    public void delete(int id) throws Exception;
    public ordenDetalle getById(int id) throws Exception;
    public List<ordenDetalle> getAll() throws Exception;
}
