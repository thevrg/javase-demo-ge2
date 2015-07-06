/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo.nested;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author IQJB
 */
public class MyGui {

    private JFrame frame = new JFrame("My GUI");
    private JButton ok = new JButton("OK");

    public MyGui() {
        
    }

    public void setVisible() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.getContentPane().add(ok);
                frame.pack();

                ok.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ok.setBackground(Color.RED);
                    }
                });
                
                ok.addActionListener((ActionEvent e) -> {
                    System.out.println("ActionListener as Lambda expression: " + e.getActionCommand());
                });

                ok.addActionListener(new MyActionListener());

                frame.setVisible(true);

            }
        });
    }

    public static void main(String[] args) {
        new MyGui().setVisible();
    }
}
