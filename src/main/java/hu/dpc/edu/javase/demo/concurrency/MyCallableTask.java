/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo.concurrency;

import java.util.concurrent.Callable;

/**
 *
 * @author IQJB
 */
public class MyCallableTask implements Callable<String> {

    private String name;
    private long waitFor;

    public MyCallableTask(String name, long waitFor) {
        this.name = name;
        this.waitFor = waitFor;
    }

    @Override
    public String call() throws Exception {
        String tn = Thread.currentThread().getName();
        try {
            System.out.println(tn + ": " + name + "  called");
            Thread.sleep(waitFor);
        } catch (InterruptedException ex) {
            System.out.println(tn + ": interrupted");
        } finally {
            System.out.println(tn + ": " + name + "  completed");
        }
        return "Completed " + name;
    }

}
