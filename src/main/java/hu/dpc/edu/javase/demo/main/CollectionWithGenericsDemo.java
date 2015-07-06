package hu.dpc.edu.javase.demo.main;

import hu.dpc.edu.javase.demo.Employee;
import hu.dpc.edu.javase.demo.EmployeeComparator;
import hu.dpc.edu.javase.demo.EmployeeComparatorByName;
import hu.dpc.edu.javase.demo.Manager;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author IQJB
 */
public class CollectionWithGenericsDemo {

    public static void main(String[] args) {
        SortedSet<Employee> c = new TreeSet<Employee>(EmployeeComparator.BY_NAME);
//        c.add("Hello");
//        c.add("Bello");
//        c.add("Hello");
//        c.add(new Integer(12000));
//        c.add(new Integer(12000));
//        c.add(new Integer(12000));
//        c.add(new Integer(12));
//        c.add(new Integer(13));
//        c.add(new Manager());
//        c.add(13);
        c.add(new Employee(1011L, "Cecil"));
        c.add(new Employee(101L, "Bela2"));
        c.add(new Employee(101L, "Bela3"));
        c.add(new Employee(102L, "Bela"));
        c.add(new Employee(102L, "Bela"));
        c.add(new Employee(102L, "Bela"));
        c.add(new Employee(102L, "Bela"));
        c.add(new Employee(102L, "Zsolti"));

        SortedSet<Employee> headSet = c.headSet(new Employee(101L, "Denes"));
        TreeSet frozenHeadSet = new TreeSet(headSet);

        System.out.println("c: " + c);
        System.out.println("headSet: " + headSet);

        c.add(new Employee(101L, "Csaba"));
        c.add(new Employee(101L, "Anita"));
        System.out.println("headSet: " + headSet);
        System.out.println("frozenHeadSet: " + frozenHeadSet);

        for (Employee e : c) {
            System.out.println("e: " + e);
        }

        
        for (Iterator<Employee> it = c.iterator(); it.hasNext();) {
//            c.add(new Employee(102, "Bela4"));
            Employee next = it.next();
            if (next.equals(new Employee(101, "Bela2"))) {
                it.remove();
            }
        }
        System.out.println("after removal:");
        for (Employee e : c) {
            System.out.println("e: " + e);
        }

    }
}
