package CommonInterface;

import InterfaceModules.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame{

    private JPanel module;
    private boolean isModuleActive;

    public GUI(){
        super("Encryption algorithms");

        isModuleActive = false;
        final JPanel panel = initPanel();
        final JComboBox<String> comboBox = initComboBox(panel);
        setUniqueComboBoxModel(comboBox);
        JButton chooseButton = initChooseButton(panel);
        JButton resetButton = initResetButton(panel);

        getContentPane().add(BorderLayout.WEST, panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1920, 1080));
        pack();
        setVisible(true);

        chooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String choice = (String)comboBox.getSelectedItem();
                switch (choice){
                    case "Exponentiation":{
                        if(!isModuleActive){
                            module = new JPanel();
                            ExponentiationModule exponentiationModule = new ExponentiationModule(module);
                            onPick();
                        }
                        break;
                    }
                    case "Euclid algorithm":{
                        if(!isModuleActive){
                            module = new JPanel();
                            EuclidModule euclidModule = new EuclidModule(module);
                            onPick();
                        }
                        break;
                    }
                    case "XOR algorithm":{
                        if(!isModuleActive){
                            module = new JPanel();
                            SimpleXORModule simpleXORModule = new SimpleXORModule(module);
                            onPick();
                        }
                        break;
                    }
                    case "Elgamal's algorithm":{
                        if(!isModuleActive){
                            module = new JPanel();
                            ElgamalModule elgamalModule = new ElgamalModule(module);
                            onPick();
                        }
                        break;
                    }
                    case "Diffie Hellman":{
                        if(!isModuleActive){
                            module = new JPanel();
                            DiffieHellmanModule diffieHellmanModule = new DiffieHellmanModule(module);
                            onPick();
                        }
                        break;
                    }
                    case "Shamir's algorithm":{
                        if(!isModuleActive){
                            module = new JPanel();
                            ShamirModule shamirModule = new ShamirModule(module);
                            onPick();
                        }
                        break;
                    }
                    case "RSA algorithm":{
                        if(!isModuleActive){
                            module = new JPanel();
                            RSAModule rsaModule = new RSAModule(module);
                            onPick();
                        }
                        break;
                    }
                    case "Fermat's factorization":{
                        if(!isModuleActive){
                            module = new JPanel();
                            FermatFactorizationModule fermatFactorizationModule = new FermatFactorizationModule(module);
                            onPick();
                        }
                        break;
                    }
                    default: break;
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onReset();
            }
        });
    }

    private JPanel initPanel(){
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(200, 500));
        return panel;
    }

    private JComboBox<String> initComboBox(JPanel panel){
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setAutoscrolls(true);
        comboBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        comboBox.setAlignmentY(Component.TOP_ALIGNMENT);
        comboBox.setMaximumRowCount(10);
        panel.add(comboBox);
        return comboBox;
    }

    private void setUniqueComboBoxModel(JComboBox<String> comboBox){
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        comboBoxModel.addElement("Exponentiation");
        comboBoxModel.addElement("Euclid algorithm");
        comboBoxModel.addElement("XOR algorithm");
        comboBoxModel.addElement("Elgamal's algorithm");
        comboBoxModel.addElement("Diffie Hellman");
        comboBoxModel.addElement("Shamir's algorithm");
        comboBoxModel.addElement("RSA algorithm");
        comboBoxModel.addElement("Fermat's factorization");
        comboBox.setModel(comboBoxModel);
    }

    private JButton initChooseButton(JPanel panel){
        JButton chooseButton = new JButton("Pick");
        setPreferredSize(new Dimension(100, 50));
        panel.add(chooseButton);
        return chooseButton;
    }

    private JButton initResetButton(JPanel panel){
        JButton resetButton = new JButton("Reset");
        setPreferredSize(new Dimension(100, 50));
        panel.add(resetButton);
        return resetButton;
    }

    private void onPick(){
        getContentPane().add(module);
        pack();
        isModuleActive = true;
    }

    private void onReset(){
        if(isModuleActive){
            remove(module);
            pack();
            repaint();
            isModuleActive = false;
        }
    }
}
