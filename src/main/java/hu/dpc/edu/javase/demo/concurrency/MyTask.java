package hu.dpc.edu.javase.demo.concurrency;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IQJB
 */
public class MyTask implements Runnable {

    private final Object lock = new Object();
    private int i;
    private final String name;

    public MyTask(String name) {
        this.name = name;
    }
    
    @Override

    public void run() {
        String tn = Thread.currentThread().getName();
        while (true) {
            synchronized (lock) {
                if (i >= 50) {
                    break;
                }
                System.out.println(tn + ": " + name + ": i=" + i);
                i++;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

}
