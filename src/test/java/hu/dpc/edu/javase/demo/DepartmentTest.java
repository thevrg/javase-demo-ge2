package hu.dpc.edu.javase.demo;

import java.util.Iterator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author IQJB
 */
public class DepartmentTest {

    public DepartmentTest() {
    }

    private Employee emp1;
    private Employee emp2;
    private Employee emp3;

    private Department createHRDepartmentWithThreeEmployees() {
        emp1 = new Employee(101, "Bela", 33);
        emp2 = new Employee(102, "Feri", 44);
        emp3 = new Employee(103, "Jozsi", 56);
        Department dep = new Department();
        dep.setName("HR");
        dep.addEmployee(emp1);
        dep.addEmployee(emp2);
        dep.addEmployee(emp3);
        return dep;
    }

    @Test
    public void testGetName() {
        //given
        Department dep = createHRDepartmentWithThreeEmployees();
        //when
        String departmentName = dep.getName();
        //then
        assertEquals("HR", departmentName);
    }

    @Test
    public void testSetName() {
        //given
        Department dep = createHRDepartmentWithThreeEmployees();
        dep.setName("XXXX");
        //when
        String departmentName = dep.getName();
        //then
        assertEquals("XXXX", departmentName);
    }

    @Test
    public void testGetNumOfEmployeesShouldReturn3IfThreeEmployeesWereAdded() {
        //given
        Department dep = createHRDepartmentWithThreeEmployees();
        //when
        int numOfEmployees = dep.getNumOfEmployees();
        //then
        assertEquals(3, numOfEmployees);
    }

    @Test
    public void testAddEmployeeIncreasesNumOfEmployees() {
        //given
        Department dep = createHRDepartmentWithThreeEmployees();
        Employee emp4 = new Employee(106, "Another", 999);
        //when
        dep.addEmployee(emp4);
        //then
        assertEquals(4, dep.getNumOfEmployees());
    }

    @Test
    public void testAddEmployeeReallyAdsEmployeeAndCanBeRetrievedWithGetEmployee() {
        //given
        Department dep = createHRDepartmentWithThreeEmployees();
        Employee emp4 = new Employee(106, "Another", 999);
        //when
        dep.addEmployee(emp4);
        //then
        assertSame(emp4, dep.getEmployee(3));
    }

    @Test
    public void testGetEmployeeShouldReturnFirstAddedEmployeeWhenIndexIsZero() {
        //given 
        Department dep = createHRDepartmentWithThreeEmployees();
        //when  
        Employee employeeAtZeroIndex = dep.getEmployee(0);
        //then   
        assertSame(emp1, employeeAtZeroIndex);
    }

    @Test()
    public void testGetEmployeeThrowIndexOutOfBoundsExceptionForNegativeIndex() {
        //given
        Department dep = createHRDepartmentWithThreeEmployees();
        //when
        try {
            Employee employeeAtNegativeIndex = dep.getEmployee(-1);
            fail("IndexOutOfBoundsException is expected");
        } catch (IndexOutOfBoundsException ex) {
            assertTrue("IndexOutOfBoundsException should have the string 'negative' in its message", ex.getMessage().contains("negative"));
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetEmployeeShouldThrowIndexOutOfBoundsExceptionForNonExistingIndex() {
        //given
        Department dep = createHRDepartmentWithThreeEmployees();
        //when
        dep.getEmployee(3);
        //then IndexOutOfBoundsException is expected
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveEmployeeShouldThrowIndexOutOfBoundsExceptionForNegativeIndex() {
        //given
        Department dep = createHRDepartmentWithThreeEmployees();
        //when
        dep.removeEmployee(-1);
        //then IndexOutOfBoundsException is expected
    }

    @Test
    public void testRemoveEmployeeShouldNotChangeNumOfEmployeesForNegativeIndex() {
        //given
        Department dep = createHRDepartmentWithThreeEmployees();
        boolean wasException = false;
        //when
        try {
            dep.removeEmployee(-1);
            fail("IndexOutOfBoundsException is expected");
        } catch (IndexOutOfBoundsException ex) {
            wasException = true;
        }
        //then
        assertTrue("IndexOutOfBoundsException is expected", wasException);
        assertEquals(3, dep.getNumOfEmployees());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveEmployeeShouldThrowIndexOutOfBoundsExceptionForNonExistingIndex() {
        //given
        Department dep = createHRDepartmentWithThreeEmployees();
        //when
        dep.removeEmployee(3);
        //then IndexOutOfBoundsException is expected
    }

    @Test
    public void testRemoveEmployeeShouldRemoveOnlyTheLastEmployeeIfIndexEqualsToSizeMinusOne() {
        //given
        Department dep = createHRDepartmentWithThreeEmployees();
        //when
        dep.removeEmployee(2);
        //then
        assertEquals(2, dep.getNumOfEmployees());

        assertSame(emp1, dep.getEmployee(0));
        assertSame(emp2, dep.getEmployee(1));
    }

    @Test
    public void testRemoveEmployeeShouldShiftEmployeesIfIndexIsLessThanSizeMinusOne() {
        //given
        Department dep = createHRDepartmentWithThreeEmployees();
        //when
        dep.removeEmployee(1);
        //then

        assertEquals(2, dep.getNumOfEmployees());

        assertSame(emp1, dep.getEmployee(0));
        assertSame(emp3, dep.getEmployee(1));
    }

    @Test
    public void testRemoveEmployeeShouldShiftEmployeesIfIndexIsZero() {
        //given
        Department dep = createHRDepartmentWithThreeEmployees();
        //when
        dep.removeEmployee(0);
        //then
        assertEquals(2, dep.getNumOfEmployees());

        assertSame(emp2, dep.getEmployee(0));
        assertSame(emp3, dep.getEmployee(1));
    }

    @Test
    public void testEmployeeIterator() {
        //given
        Department dep = createHRDepartmentWithThreeEmployees();
        //when
        Iterator<Employee> it = dep.iterator();
        boolean hasNext1 = it.hasNext();
        Employee next1 = it.next();
        boolean hasNext2 = it.hasNext();
        Employee next2 = it.next();
        boolean hasNext3 = it.hasNext();
        Employee next3 = it.next();
        boolean hasNext4 = it.hasNext();
        try {
            Employee next4 = it.next();
            fail("IllegalStateException is expected");
        } catch (IllegalStateException ex) {

        }
        //then
        assertTrue(hasNext1);
        assertSame(emp1, next1);
        assertTrue(hasNext2);
        assertSame(emp2, next2);
        assertTrue(hasNext3);
        assertSame(emp3, next3);
        assertFalse(hasNext4);

    }

    @Test
    public void testEmployeeIteratorShouldThrowIllegalStateExceptionIfDepartmentChanges() {
        //given
        boolean wasException = false;
        Department dep = createHRDepartmentWithThreeEmployees();
        //when
        Iterator<Employee> it = dep.iterator();
        it.hasNext();
        it.next();
        it.hasNext();
        it.next();
        dep.removeEmployee(0);
        try {
            it.hasNext();
        } catch (IllegalStateException ex) {
            wasException = true;
        }
        //then
        assertTrue("IllegalStateException is expected after removeEmployee is called on Department", wasException);
    }

}
