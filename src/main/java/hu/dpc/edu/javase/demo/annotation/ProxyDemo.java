/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo.annotation;

import hu.dpc.edu.javase.demo.Manager;
import hu.dpc.edu.javase.demo.generics.DAO;
import hu.dpc.edu.javase.demo.generics.EmployeeDAO;

/**
 *
 * @author IQJB
 */
public class ProxyDemo {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        
        EmployeeDAO dao = new EmployeeDAO();
        
        DAO proxy = proxyFactory.createProxy(dao, DAO.class);
        
        proxy.persist(new Manager(121L, "Bela", null));
//        proxy.persist(new Manager(121L, "Bela", null));
        
        
                
    }
}
