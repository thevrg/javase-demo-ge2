
package hu.dpc.edu.javase.demo.zoo;

/**
 *
 * @author IQJB
 */
public class Cat extends Animal implements Pet {

    private final String name;

    public Cat(String name) {
        this.name = name;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Cat{" + "name=" + name + '}';
    }
    
}
