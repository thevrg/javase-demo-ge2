package hu.dpc.edu.javase.demo.generics;

import hu.dpc.edu.javase.demo.Employee;
import hu.dpc.edu.javase.demo.annotation.Role;
import hu.dpc.edu.javase.demo.annotation.RolesAllowed;

/**
 *
 * @author IQJB
 */
public class EmployeeDAO extends BaseDAO<Employee, Long> {

    public EmployeeDAO() {
        super(Employee.class);
    }

    @RolesAllowed(Role.ADMIN)
    @Override
    public void update(Employee entity) {
        super.update(entity);
    }

    @RolesAllowed(value = {Role.MANAGER, Role.ADMIN}, description = "hello")
    @Override
    public void persist(Employee entity) {
        super.persist(entity);
    }
    
    
    
    
    
}
