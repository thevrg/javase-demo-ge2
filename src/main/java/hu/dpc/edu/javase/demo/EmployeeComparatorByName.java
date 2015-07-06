package hu.dpc.edu.javase.demo;

import java.util.Comparator;

/**
 *
 * @author IQJB
 */
public class EmployeeComparatorByName implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.name.compareTo(o2.name);
    }
}
