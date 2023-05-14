/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;

/**
 *
 * @author AnataArisa
 * @param <T>
 */
public interface IDAO<T> {
    public List<T> getAll();
    public void create(T data);
    public void update(T data);
    public void delete(String UID);
    public T read(String UID);
}
