package InterfaceModules;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AbstractModule {

    AbstractModule(JPanel panel){
        panel.setPreferredSize(new Dimension(800, 500));
        panel.setBackground(Color.GREEN);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setPreferredSize(new Dimension(100, 25));
        panel.add(calculateButton);
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });
    }

     protected abstract void calculate();
}
