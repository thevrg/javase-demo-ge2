package hu.dpc.edu.javase.demo.main;

import hu.dpc.edu.javase.demo.Department;
import hu.dpc.edu.javase.demo.Employee;
import hu.dpc.edu.javase.demo.Manager;
import hu.dpc.edu.javase.demo.ReflectionDemo;

/**
 *
 * @author IQJB
 */
public class InheritanceDemo {
    public static void main(String[] args) {
        Department hr = new Department();
        hr.setName("HR");
        Manager m = new Manager(hr, "Bela");
        m.getName();
        
        System.out.println("m.toString() : " + m);
        
        Employee e = m;
        
        System.out.println("e.toString() : " + e);
        System.out.println("e.getInfo() : " + e.getInfo());
        
        Object o = m;
        System.out.println("o.toString() :  " + o);
        
//        o = null;
        
        if (o instanceof Manager) {
            System.out.println("o is a Manager");
        }
        
        if (o instanceof Employee) {
            System.out.println("o is an Employee");
        }
        
        if (o instanceof Object) {
            System.out.println("o is an Object");
        }
        
        Manager m2 = (Manager) o;
        
        System.out.println("m2.getManagerOf() : " + m2.getManagerOf());
        
        ReflectionDemo.printInfo(o);
        Object other = ReflectionDemo.createSameTypeObject(o);
        System.out.println("other: " + other);
    }
}
