package hu.dpc.edu.javase.demo.nested.generics;

import hu.dpc.edu.javase.demo.Department;
import hu.dpc.edu.javase.demo.Employee;
import hu.dpc.edu.javase.demo.Manager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author IQJB
 */
public class GenericsDemo {
    public static void main(String[] args) {
        List<Manager>lm = new ArrayList<>();
        lm.add(new Manager(121, "jozsi", null));
        //lm.add(new Secretary(111, "Feri", 10000));
        
        List<?>lu = lm;
        
        Object valami = lu.get(0);
        System.out.println("vlami: " + valami);
        lu.add(null);
        for (Object i : lu) {
            System.out.println("i: " + i);
        }
        
        List<? extends Employee>lee = lm;
        
        
        
        lee.add(null);
        
        Employee emp = lee.get(0);
        System.out.println("emp: " + emp);
        
        for (Employee e : lee) {
            System.out.println("emp: " + e);
        }
        
        List<? super Manager>lsm = lm;

        lsm.add(new Manager(1111, "Uj manager", new Department("xxx")));
        System.out.println("lm: " + lm);
        
        Object valami2 = lsm.get(3);
        System.out.println("valami2: " + valami2);
        
        
        List l = lm;
        l.add("Hello world");
        System.out.println("lm: " + lm);
        
//        for (Manager m : lm) {
//            System.out.println("m: " + m);
//        }
        
        for (Iterator<Manager> iterator = lm.iterator(); iterator.hasNext();) {
            Manager next = iterator.next();
            System.out.println("next: " + next);
            
        }
        
    }
}
