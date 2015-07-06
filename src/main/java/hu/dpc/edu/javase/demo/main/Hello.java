package hu.dpc.edu.javase.demo.main;

import hu.dpc.edu.javase.demo.Employee;

/**
 * Ez itt a valami
 *
 * @author IQJB
 */
public class Hello {

    private static void changeNumber(int num) {
        num = 33;
    }

    private static void changeRef(Employee emp) {
        emp = new Employee(222L, "Jozsi", 2000);
    }
    private static void changeObjectState(Employee emp) {
        emp.setName("Feri");
    }
    
    private static Employee createEmployee(Employee emp, String name) {
        return new Employee(121L, name);
    }

    /**
     * Ez itt a main metodus
     *
     * @param args Ez a parameter meg arra valo
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Employee emp2 = new Employee(12F);
        
        
        Employee emp = new Employee(123L, "Bela", 1000);
        String name = emp.getName();
        name = "Akarmi";
        System.out.println(name);

        int num = 11;
        changeNumber(num);
            System.out.println("num: " + num);

        changeRef(emp);
        System.out.println(emp.getName());

        changeObjectState(emp);
        System.out.println(emp.getName());
        
        
    }
}
