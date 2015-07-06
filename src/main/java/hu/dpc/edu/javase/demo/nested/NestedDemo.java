package hu.dpc.edu.javase.demo.nested;

import hu.dpc.edu.javase.demo.EmployeeIterator;

/**
 *
 * @author IQJB
 */
public class NestedDemo {
    public static void main(String[] args) {
        Outer.setValami("VALAMI");
        Outer o1 = new Outer("o1");
        Outer o2 = new Outer("o2");
        
        Outer.Inner i1 = o1.createInner("i1");
        Outer.Inner i2 = o1.createInner("i2");
        Outer.Inner i3 = o2.createInner("i3");
        Outer.Inner i4 = o2.new Inner("i4");
        
        Outer.StaticNested.hello(o2);
        
        System.out.println("i1.toString() " + i1);
        System.out.println("i2.toString() " + i2);
        System.out.println("i3.toString() " + i3);
        System.out.println("i4.toString() " + i4);
        
        EmployeeIterator empIt = o2.iterator(111);
        EmployeeIterator empIt2 = o2.iterator(222);
        
        System.out.println("empIt.next() : " + empIt.next());
        System.out.println("empIt.next() : " + empIt.next());
        System.out.println("empIt2.next() : " + empIt2.next());
        System.out.println("empIt2.next() : " + empIt2.next());
    }
}
