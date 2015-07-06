package hu.dpc.edu.javase.demo.main;

import hu.dpc.edu.javase.demo.Department;
import hu.dpc.edu.javase.demo.Employee;
import hu.dpc.edu.javase.demo.EmployeeIterator;
import hu.dpc.edu.javase.demo.InfoExposerBaseClass;
import hu.dpc.edu.javase.demo.InfoProducer;
import hu.dpc.edu.javase.demo.Manager;

/**
 *
 * @author IQJB
 */
public class AbstractDemo {
    
    
    public static void printEmployees(EmployeeIterator ei) {
        while(ei.hasNext()) {
            Employee emp = ei.next();
            System.out.println("emp: " + emp);
        }
    }
    
    public static void printInfo(InfoProducer ip) {
        System.out.println(ip.getInfo());
    }
    
    public static void main(String[] args) {
        InfoExposerBaseClass b = new Manager();
        System.out.println("b.getInfo() : " +  b.getInfo());
        
        Department d = new Department("HR");
        d.addEmployee(new Employee(123, "Bela"));
        d.addEmployee(new Employee(1234, "Feri"));
        
        printEmployees(d.iterator());
        
        Manager m = new Manager(121, "XXX", new Department("XX"));
        printInfo(m);
        
        
    }
}
