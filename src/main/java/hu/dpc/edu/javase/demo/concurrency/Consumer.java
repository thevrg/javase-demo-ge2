package hu.dpc.edu.javase.demo.concurrency;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IQJB
 */
public class Consumer implements Runnable {

    private Random rnd = new Random();
    private final MyStack stack;

    public Consumer(MyStack stack) {
        this.stack = stack;
    }

    @Override
    public void run() {
        String tn = Thread.currentThread().getName();
        for (int i = 0; i < 1050; ) {
            try {
                char c = stack.pop();
                i++;
            } catch (IllegalStateException ex) {
                System.out.println(tn + ":  pop failed: " + ex.getMessage());
            }
            if (WaitNotifyDemo.isTimeToQuit()) {
                System.out.println(tn + ": Shutting down...");
                return;
            }
            try {
                Thread.sleep(rnd.nextInt(100));
            } catch (InterruptedException ex) {
                if (WaitNotifyDemo.isTimeToQuit()) {
                    System.out.println(tn + ": Shutting down, because of an interrupt...");
                    return;
                }
            }
        }
    }

}
