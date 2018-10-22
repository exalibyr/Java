package com.company.methodReferrences;

import com.company.Main;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Main2 {

    public static void main(String[] args) {
        final Main.Car car = Main.Car.create( Main.Car::new );
        final List< Main.Car > cars = Arrays.asList(car);
        cars.forEach( Main.Car::collide );
        cars.forEach( Main.Car::repair );
        final Main.Car police = Main.Car.create( Main.Car::new );
        cars.forEach( police::follow );
    }

    private static class Car {
        static Car create( final Supplier< Car > supplier ) {
            return supplier.get();
        }

        static void collide( final Car car ) {
            System.out.println( "Collided " + car.toString() );
        }

        void follow( final Car another ) {
            System.out.println( "Following the " + another.toString() );
        }

        void repair() {
            System.out.println( "Repaired " + this.toString() );
        }
    }
}
