package userInterface;

import logic.GUIBuilder;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI extends JFrame {

    private JPanel mainPanel;
    private JTextField queryInput;

    public GUI(){
        super("MySQL DB test");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        mainPanel = GUIBuilder.createPanel();
        queryInput = GUIBuilder.createTextField();
        add(mainPanel);
        mainPanel.add(queryInput);

        queryInput.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_ENTER:{

                    }
                    case KeyEvent.VK_DELETE:{
                        queryInput.setText("");
                        break;
                    }
                    case KeyEvent.VK_ESCAPE:{
                        dispose();
                        break;
                    }
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        setVisible(true);
        pack();

    }
}
