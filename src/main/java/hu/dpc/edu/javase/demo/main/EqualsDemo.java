/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo.main;

import hu.dpc.edu.javase.demo.Employee;

/**
 *
 * @author IQJB
 */
public class EqualsDemo {
    public static void main(String[] args) {
        Employee e1 = new Employee(101, "Bela", 10000);
        Employee e2 = new Employee(101, "Bela", 10000);
        Employee e3 = e1;
        System.out.println("e1 == e2 : " + (e1 == e2));
        System.out.println("e1 == e3 : " + (e1 == e3));
        
        System.out.println("e1.equals(e2) : " +  e1.equals(e2));
        
        String s1 = "AB".toString() + "C";
        String s2 = "A".toString() + "BC";
        System.out.println("s1 == s2 : " + (s1 == s2));
        
        String abIntern = new String("AB").intern();
        
        System.out.println("abIntern == \"AB\" : " + (abIntern == "AB"));
        
        String abcIntern = s1.intern();
        String abcIntern2 = s2.intern();
        String abc = "ABC";
        
        System.out.println("s1 == abcIntern : " + (s1 == abcIntern));
        System.out.println("s1 == abcIntern : " + (s2 == abcIntern));
        System.out.println("abcIntern == abcIntern2 : " + (abcIntern == abcIntern2));
        System.out.println("abc == abcIntern : " + (abc == abcIntern) );
        
               
    }
}
