package hu.dpc.edu.javase.demo.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author IQJB
 */
public class DeserializeDemo {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        MyPoint p = null;
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("out.ser"))) {
            p = (MyPoint) in.readObject();
            System.out.println("p: " + p);
        }
    }
}
