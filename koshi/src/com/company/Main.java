//МЕТОД ЭЙЛЕРА-КОШИ

package com.company;


import java.io.FileWriter;

public class Main {

    private static final double K = 6, U = 4, T = 5;

    private static double function(double y){
        return (K * U - y) / T;
    }

    public static void main(String[] args) {
        //начальные условия
        double a = 0, b = 51;
        double h = 0.1;
        int n = ((int) ((b - a) / h));
        double[] x = new double[n + 1];
        double[] y = new double[n + 1];
        double[] y1 = new double[n + 1];
        x[0] = 0;
        y[0] = 1;
        //рассчет
        for (int i = 1; i < n + 1; i++) {
            x[i] = a + h * i;
            y1[i] = y[i - 1] + h * function(y[i - 1]);
            y[i] = y[i - 1] + h * (function(y[i - 1]) + function(y1[i])) / 2;
        }
        //вывод
        try(FileWriter fileWriter = new FileWriter("out.txt")){
            for (int i = 0; i < n + 1; i++) {
                fileWriter.write( x[i] + " " + y[i] + "\n");
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
