package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Default object = DefaultFactory.create(DefaultImpl::new);
        System.out.println(object.defaultMethod());
        object = DefaultFactory.create(OverrideImpl::new);
        System.out.println(object.defaultMethod());

    }


    public static class Car {
        public static Car create( final Supplier< Car > supplier ) {
            return supplier.get();
        }

        public static void collide( final Car car ) {
            System.out.println( "Collided " + car.toString() );
        }

        public void follow( final Car another ) {
            System.out.println( "Following the " + another.toString() );
        }

        public void repair() {
            System.out.println( "Repaired " + this.toString() );
        }
    }

}
