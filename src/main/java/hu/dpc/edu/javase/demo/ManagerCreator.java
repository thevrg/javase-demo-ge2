package hu.dpc.edu.javase.demo;

/**
 *
 * @author IQJB
 */
public class ManagerCreator extends EmployeeCreator {

    @Override
    public Manager create(long id) {
        return new Manager(id, "Default Manager",  new Department("Default"));
    }
}
