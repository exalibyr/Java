package com.company;

public class Main {

    static double dif1(double x){
        return Math.exp(-0.5*x)*(1-0.5*x);
    }

    static double dif2(double x){
        return Math.exp(-0.5*x)*(0.25*x-1);
    }

    public static void main(String[] args) {
	    final double E = 0.02, A = 0, B = 3;
	    double x, x1 = B;
	    int k = 0;
	    do{
	        x = x1;
            x1 = x - dif1(x)/dif2(x);
            k++;
            System.out.println("N=" + k + "\n" + "x=" + x + "\n" + "dif1=" + dif1(x) + "\n" +
                    "dif2=" + dif2(x) + "\n" + "dx=" + Math.abs(x1-x));
        }
	    while (Math.abs(x1 - x) > E);
        System.out.println(x1);
        System.out.println(dif1(x1));
        System.out.println(dif2(x1));
    }
}
