/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo;

import hu.dpc.edu.javase.demo.EmployeeCreator;
import hu.dpc.edu.javase.demo.Employee;
import hu.dpc.edu.javase.demo.Manager;
import hu.dpc.edu.javase.demo.ManagerCreator;

/**
 *
 * @author IQJB
 */
public class OverrideDemo {
    public static void main(String[] args) {
        ManagerCreator mc = new ManagerCreator();
        Manager m12 = mc.create(12);
        EmployeeCreator ec = new EmployeeCreator();
        Employee e13 = ec.create(13);
        EmployeeCreator ec2 = mc;
        Employee e14 = ec2.create(14);
        System.out.println("m12: " + m12);
        System.out.println("e13: " + e13);
        System.out.println("e14: " + e14);
    }
}
