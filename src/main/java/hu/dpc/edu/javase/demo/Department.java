package hu.dpc.edu.javase.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author IQJB
 */
public class Department implements Iterable<Employee> {

    private String name;
    private EmployeeCreator creator;
    private List<Employee>employees = new ArrayList<>();

    public Department(EmployeeCreator creator) {
        this.creator = creator;
    }
    
    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfEmployees() {
        return employees.size();
    }
    

    public void addEmployee(Employee emp) {
        employees.add(emp);
    }
    

    public Employee getEmployee(int index) {
        return employees.get(index);
    }

    /**
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException d
     */
    public void removeEmployee(int index) throws IndexOutOfBoundsException {
        employees.remove(index);
    }

    
    public void addUsingCreator(long id) {
        addEmployee(creator.create(id));
    }

    @Override
    public String toString() {
        return "Department{" + "name=" + name + ", numOfEmployees=" + getNumOfEmployees() + '}';
    }
    
    @Override
    public Iterator<Employee> iterator() {
        return employees.iterator();
    }
}
