package hu.dpc.edu.javase.demo.annotation;

import hu.dpc.edu.javase.demo.generics.EmployeeDAO;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 *
 * @author IQJB
 */
public class AnnotationDemo {
    public static void main(String[] args) {
        Class c = EmployeeDAO.class;
        
        Method[] declaredMethods = c.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println("method: " + method);
            RolesAllowed rolesAllowed = method.getAnnotation(RolesAllowed.class);
            if (rolesAllowed != null) {
                System.out.println("rolesAllowed.getClass(): " + rolesAllowed.getClass());
                System.out.println("roles allowed:  " + Arrays.toString(rolesAllowed.value()));
            }
        }
    }
}
