/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo.generics;

import hu.dpc.edu.javase.demo.Employee;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author IQJB
 */
public class EmployeeDAOTest {
    
    public EmployeeDAOTest() {
    }

    @Test
    public void testSomeMethod() {
        
        EmployeeDAO dao = new EmployeeDAO();
        Employee emp = dao.create();
        emp.setName("Peter");
        dao.persist(emp);
        
        Employee emp2 = dao.findById(1L);
        
        
        assertSame(emp2, emp);
        
    }
    
}
