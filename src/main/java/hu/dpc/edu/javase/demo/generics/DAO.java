/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo.generics;

/**
 *
 * @author IQJB
 */
public interface DAO<E extends Entity<ID>, ID> {

    E create();

    E findById(ID id);

    void persist(E entity);

    void update(E entity);
    
}
