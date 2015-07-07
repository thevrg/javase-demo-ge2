/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo.serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author IQJB
 */
public class SerializeDemo {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        MyPoint p = new MyPoint(65,66);
        MyPoint p2 = new MyPoint(67,68);
        p.setOther(p2);
        p2.setOther(p);
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("out.ser"))) {
            out.writeObject(p);
        }
    }
}
