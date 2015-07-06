package hu.dpc.edu.javase.demo;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author IQJB
 */
public class EmployeeTest {
    
    public EmployeeTest() {
    }
    
    private Employee emp; 
    
    @Before
    public void createEmployee() {
        emp = new Employee(101, "Bela", 100000);
    }

    @Test
    public void testGetCounter() {
    }

    @Test
    public void testGetIdReturnsWithTheIdPassedInConstructor() {
        //given employee defined in createEmployee method
        
        //when
        long id = emp.getId();
        
        //then
        assertEquals(101, id);
    }

    @Test
    public void testGetName() {
        //given employee defined in createEmployee method
        
        //when
        String name = emp.getName();
        
        //then
        assertEquals("Bela", name);
    }

    @Test
    public void testSetName() {
        //given employee defined in createEmployee method
        
        //when
        emp.setName("Jozsi");
        
        //then
        assertEquals("Jozsi", emp.getName());
    }

    @Test
    public void testEqualsReturnsTrueWhenIdEquals() {
        Employee emp2 = new Employee(101, "XXX", 111);
        assertTrue(emp.equals(emp2));
    }
    
    @Test
    public void testEqualsReturnsFalseWhenIdIsDifferent() {
        Employee emp2 = new Employee(102, "Bela", 100000);
        assertFalse(emp.equals(emp2));
    }
    
}
