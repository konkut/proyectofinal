/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import modelo.domicilio;

public interface domicilioDao {
     public void insert(domicilio domicilio) throws Exception;
    public void update(domicilio domicilio) throws Exception;
    public void delete(int id) throws Exception;
    public domicilio getById(int id) throws Exception;
    public List<domicilio> getAll() throws Exception;
}
