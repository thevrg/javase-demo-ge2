package hu.dpc.edu.javase.demo.concurrency;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IQJB
 */
public class MyStack {

    private final char[] array = new char[10];
    private int index;

    
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();
    private final Condition NOT_EMPTY = writeLock.newCondition();
    private final Condition NOT_FULL = writeLock.newCondition();

    public void push(char c) {
        try {
            writeLock.lock();
            String tn = Thread.currentThread().getName();
            System.out.println(tn + ":  push " + c);
            while (index == array.length) {
                try {
                    System.out.println(tn + ": waiting... ");
                    NOT_FULL.await();
                } catch (InterruptedException ex) {
                    if (WaitNotifyDemo.isTimeToQuit()) {
                        System.out.println(tn + ": waking up from waiting, shutting down, because of an interrupt...");
                        throw new IllegalStateException("No char, shutdown!");
                    }
                }
            }
            array[index++] = c;
            NOT_EMPTY.signal();
        } finally {
            writeLock.unlock();
        }
    }
    
    @Override
    public String toString() {
        try {
            readLock.lock();
            return Arrays.toString(array) + ", index: " + index;
        } finally {
            readLock.unlock();
        }
    }

    public char pop() {
        String tn = Thread.currentThread().getName();
        try {
            writeLock.lock();
            while (index == 0) {
                try {
                    System.out.println(tn + ": waiting... ");
                    NOT_EMPTY.await();

                    if (index == 0) {
                        System.out.println(tn + ": VAKLARMA!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    }
//                throw new IllegalStateException("Stack is empty");
                } catch (InterruptedException ex) {
                    if (WaitNotifyDemo.isTimeToQuit()) {
                        System.out.println(tn + ": waking up from waiting, shutting down, because of an interrupt...");
                        throw new IllegalStateException("No char, shutdown!");
                    }
                }
            }
            char c = array[--index];
            NOT_FULL.signal();
            System.out.println(tn + ":  popped " + c);
            return c;
        } finally {
            lock.writeLock();
        }
    }
}
