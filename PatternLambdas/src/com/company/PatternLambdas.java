package com.company;

import java.util.Scanner;
import java.util.function.*;

public class PatternLambdas {

    static void predicateLambda(){
        Predicate<Integer> predicate = x -> x % 2 == 0;
        System.out.println(predicate.test(2));
        System.out.println(predicate.test(1));
    }

    static void binaryOperatorLambda(){
        BinaryOperator<Double> binaryOperator = (x, y) -> x + y;
        System.out.println(binaryOperator.apply(2.5, 3.2));
    }

    static void unaryOperatorLambda(){
        UnaryOperator<Boolean> unaryOperator = x -> !x;
        System.out.println(unaryOperator.apply(false));
    }

    static void functionLambda(){
        Function<String, Boolean> function = x -> Boolean.valueOf(x);
        System.out.println(!function.apply("true"));
    }

    static void consumerLambda(){
        Consumer<Double> consumer = s -> System.out.println(s + "$");
        consumer.accept(35.5);
    }

    static void supplierLambda(){
        Supplier<User> userSupplier = () -> {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter name: ");
            return new User(in.next());
        };

        System.out.println(userSupplier.get());
        System.out.println(userSupplier.get());
    }


}
