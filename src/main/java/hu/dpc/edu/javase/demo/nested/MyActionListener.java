package hu.dpc.edu.javase.demo.nested;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author IQJB
 */
public class MyActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button pressed: " + e.getActionCommand());
    }

}
