package hu.dpc.edu.javase.demo.zoo;

/**
 *
 * @author IQJB
 */
public class ZooDemo {

    public static void main(String[] args) {
        Cat c = new Cat("Szerenyke");
        Dog d = new Dog("Frakk");
        
        Animal a = c;
        Animal a2 = d;
        
        Cat c2 = (Cat) a;
        //Cat c3 = (Cat) a2; //runtime error
        
        //Dog d2 = (Dog)c; //compilation error
        
        Pet p1 = c;
        
        System.out.println("p1.getName(): " + p1.getName() );
        
        //Pet p2 = (Pet) a2;
        Spider s = new MySpider();
        
        Pet p = (Pet) s;

        System.out.println("p.getName() : " + p.getName());
        
        
    }
    
}
