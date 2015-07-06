package hu.dpc.edu.javase.demo.main;

import hu.dpc.edu.javase.demo.Employee;

/**
 *
 * @author IQJB
 */
public class StaticInitDemo {
    public static void main(String[] args) throws Exception {
        System.out.println("StaticInitDemo started");
        
        //Class.forName("hu.dpc.edu.javase.demo.Employee");
        
        Employee emp = null;
        System.out.println("emp = null");
        System.out.println("Employee.DEFAULT_SALARY = " + Employee.DEFAULT_SALARY);
        System.out.println("Employee.DEFAULT_NAME = " + Employee.DEFAULT_NAME);
        System.out.println("Employee.getCounter() = " + Employee.getCounter());
        emp = new Employee(123L);
        
        {
            int x = 3;
            
            {
                System.out.println("x: " + x);
            }
            System.out.println("x: " + x);
        }
        
        
    }
}
