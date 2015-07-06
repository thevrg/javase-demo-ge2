package hu.dpc.edu.javase.demo.nested;

import hu.dpc.edu.javase.demo.Employee;
import hu.dpc.edu.javase.demo.EmployeeIterator;

/**
 *
 * @author IQJB
 */
public class Outer {
    
    private static String valami;

    public static String getValami() {
        return valami;
    }

    public static void setValami(String valami) {
        Outer.valami = valami;
    }
    
    private String name;

    
    public Outer(String name) {
        this.name = name;
    }
    
    public Inner createInner(String name) {
        return new Inner(name);
    }
    
    public static class StaticNested {
        private static String valamiMas;
        private String mas;

        public StaticNested(String name) {
            this.mas = name;
        }
        
        public static void hello(Outer o) {
            System.out.println("Outer.valami : " + Outer.valami);
            System.out.println("o.name: " + o.name);
        }

        @Override
        public String toString() {
            return "StaticNested{" + "mas=" + mas + '}';
        }
        
    }
    
    public class Inner {
        private String name;

        public Inner(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Inner{" 
                    + "Outer.valami=" + Outer.valami
                    + ", Outer.this.name=" + Outer.this.name
                    + ", this.name=" + this.name + '}';
        }

    }
    
    public EmployeeIterator iterator(final long id) {
        
        final double rnd = Math.random();
        
        class MyEmployeeIterator implements EmployeeIterator {
            
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Employee next() {
                return new Employee(id, Outer.this.name + ", rnd: " + rnd);
            }
        }

        
        MyEmployeeIterator empIt = new MyEmployeeIterator();
        
        return empIt;
    }

    public EmployeeIterator iteratorAnon(final long id) {
        
        final double rnd = Math.random();
        
        return new BaseIterator(null){
            
            @Override
            public Employee next() {
                return new Employee(id, Outer.this.name + ", rnd: " + rnd);
            }
        };
        
    }
    
}
