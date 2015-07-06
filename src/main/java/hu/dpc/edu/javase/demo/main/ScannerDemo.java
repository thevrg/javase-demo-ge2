package hu.dpc.edu.javase.demo.main;

import java.util.Scanner;

/**
 *
 * @author IQJB
 */
public class ScannerDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner("a,234,342").useDelimiter(",");
        
        while (scanner.hasNextInt()) {
            System.out.println("token: " + scanner.nextInt());
        }
    }
}
