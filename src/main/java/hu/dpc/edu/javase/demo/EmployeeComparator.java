package hu.dpc.edu.javase.demo;

import java.util.Comparator;

/**
 *
 * @author IQJB
 */
public enum EmployeeComparator implements Comparator<Employee> {

    BY_ID() {
                @Override
                public int compare(Employee o1, Employee o2) {
                    return (int) (o1.getId() - o2.getId());
                }
            },
    BY_NAME() {
                @Override
                public int compare(Employee o1, Employee o2) {
                    return o1.name.compareTo(o2.name);
                }
            };
    
    public Comparator<Employee> asc() {
        return this;
    }

    public Comparator<Employee> desc() {
        return new Comparator<Employee>() {

            @Override
            public int compare(Employee o1, Employee o2) {
                return -EmployeeComparator.this.compare(o1, o2);
            }
        };
    }

}
