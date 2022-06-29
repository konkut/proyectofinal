/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import modelo.rol;


public interface rolDao {
    public void insert(rol rol) throws Exception;
    public void update(rol rol) throws Exception;
    public void delete(int id) throws Exception;
    public rol getById(int id) throws Exception;
    public List<rol> getAll() throws Exception;
}
