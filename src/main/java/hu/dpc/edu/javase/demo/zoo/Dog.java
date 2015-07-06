/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo.zoo;

/**
 *
 * @author IQJB
 */
public class Dog extends Animal implements Pet {

    private final String name;

    public Dog(String name) {
        this.name = name;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Dog{" + "name=" + name + '}';
    }
    
}
