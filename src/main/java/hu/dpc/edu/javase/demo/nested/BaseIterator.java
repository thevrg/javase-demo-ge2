/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo.nested;

import hu.dpc.edu.javase.demo.Employee;
import hu.dpc.edu.javase.demo.EmployeeIterator;

/**
 *
 * @author IQJB
 */
public class BaseIterator implements EmployeeIterator{
    private Employee[] empArr;
    private int index;

    public BaseIterator(Employee[] empArr) {
        this.empArr = empArr;
    }

    @Override
    public boolean hasNext() {
        return index < empArr.length;
    }

    @Override
    public Employee next() {
        return empArr[index++];
    }
}
