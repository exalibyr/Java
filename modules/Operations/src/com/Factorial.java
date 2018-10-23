package com;

public class Factorial {
    public static int calculate(int n){
        if (n < 0) return 0;
        int result = 1;
        for(int i =1; i <= n; i++){

            result = result * i;
        }
        return result;
    }
}
