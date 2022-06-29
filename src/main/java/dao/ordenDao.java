/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import modelo.orden;


public interface ordenDao {
    public void insert(orden orden) throws Exception;
    public void update(orden orden) throws Exception;
    public void delete(int id) throws Exception;
    public orden getById(int id) throws Exception;
    public List<orden> getAll() throws Exception;
}
