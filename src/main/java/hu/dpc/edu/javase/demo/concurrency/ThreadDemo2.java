package hu.dpc.edu.javase.demo.concurrency;

/**
 *
 * @author IQJB
 */
public class ThreadDemo2 {
    public static void main(String[] args) {
         MyThread t1 = new MyThread("T1");
         t1.start();
         t1.run();
         
//         Thread t2 = new Thread(t1, "T2");
//         t2.start();
//
         System.out.println("main ends...");
    }
}
