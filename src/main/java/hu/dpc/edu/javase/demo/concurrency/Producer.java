package hu.dpc.edu.javase.demo.concurrency;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IQJB
 */
public class Producer implements Runnable {

    private Random rnd = new Random();
    private final MyStack stack;

    public Producer(MyStack stack) {
        this.stack = stack;
    }

    @Override
    public void run() {
        String tn = Thread.currentThread().getName();
        for (int i = 0; i < 1050; i++) {
            char c = (char) ('A' + rnd.nextInt('Z' - 'A'));
            stack.push(c);
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
