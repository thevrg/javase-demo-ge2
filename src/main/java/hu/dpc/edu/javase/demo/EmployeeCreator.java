package hu.dpc.edu.javase.demo;

import hu.dpc.edu.javase.demo.Employee;

/**
 *
 * @author IQJB
 */
public class EmployeeCreator {
    Employee create(long id) {
        return new Employee(id);
    }
}
