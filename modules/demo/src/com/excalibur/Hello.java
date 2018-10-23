package com.excalibur;

import com.Factorial;

import javax.swing.*;

public class Hello {
    public static void main(String[] args) {
            JOptionPane.showMessageDialog(null, "Hi Vsauce! Michael here!");
            String mes = JOptionPane.showInputDialog("Enter number");
            int answer = Factorial.calculate(Integer.valueOf(mes));
            JOptionPane.showMessageDialog(null, String.valueOf(answer));
            JOptionPane.showMessageDialog(null, "Bye Vsauce! Michael out!");

    }
}
