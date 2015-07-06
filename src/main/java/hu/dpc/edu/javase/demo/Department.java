package hu.dpc.edu.javase.demo;

import java.util.Iterator;

/**
 *
 * @author IQJB
 */
public class Department implements Iterable<Employee> {

    private String name;
    private int numOfEmployees;
    private Employee[] employees = new Employee[8];
    private EmployeeCreator creator;
    private long version;

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
        return numOfEmployees;
    }
    
    private void stateChanged() {
        version++;
    }

    public void addEmployee(Employee emp) {
        if (numOfEmployees == employees.length) {
            Employee[] newEmployeeArray = new Employee[numOfEmployees * 2];
            System.arraycopy(employees, 0, newEmployeeArray, 0, numOfEmployees);
            employees = newEmployeeArray;
        }
        employees[numOfEmployees++] = emp;
        stateChanged();
    }
    

    public Employee getEmployee(int index) {
        checkIndex(index);
        return employees[index];
    }

    /**
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException d
     */
    public void removeEmployee(int index) throws IndexOutOfBoundsException {
        checkIndex(index);
        if (index < numOfEmployees - 1) {
            final int itemsToCopy = numOfEmployees - index - 1;
            System.arraycopy(employees, index + 1, employees, index, itemsToCopy);
        }
        numOfEmployees--;
        stateChanged();
    }

    private void checkIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index is negative");
        }
        if (index >= numOfEmployees) {
            throw new IndexOutOfBoundsException("Index is too big");
        }
    }
    
    public void addUsingCreator(long id) {
        addEmployee(creator.create(id));
    }

    @Override
    public String toString() {
        return "Department{" + "name=" + name + ", numOfEmployees=" + numOfEmployees + '}';
    }
    
    @Override
    public Iterator<Employee> iterator() {
        final long iteratorVersion = version;
        return new Iterator() {
            private int index;
            
            @Override
            public boolean hasNext() {
                checkDepartmentState();
                return index < numOfEmployees;
            }

            private void checkDepartmentState() throws IllegalStateException {
                if (iteratorVersion != version) {
                    throw new IllegalStateException("Department has been modified since the creation of the iterator");
                }
            }

            @Override
            public Employee next() {
                checkDepartmentState();
                if (index >= numOfEmployees) {
                    throw new IllegalStateException("No more elements");
                }
                return employees[index++];
            }
        };
    }

}
