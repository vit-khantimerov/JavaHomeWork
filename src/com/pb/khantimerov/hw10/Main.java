package com.pb.khantimerov.hw10;

public class Main {
    public static void main(String[] args) {

        NumBox<Integer> integers = new NumBox<>(4);
        integers.add( 100,0);
        integers.add( 0,1);
        //integers.add( 200,2);
        integers.add( -100,3);
        integers.add( -1,3);
        integers.add( 1000,4);

        integers.get(2);
        integers.get(3);
        integers.length();
        integers.average();
        integers.sum();
        integers.max();

        System.out.println();

        NumBox<Float> floats = new NumBox<>(5);
        floats.add( 10.0f,0);
        floats.add( 500.0f,1);
        //floats.add(50.0f,2);
        floats.add(-10.0f,3);
        floats.add(99.0f, 4);
        floats.add( 99.0f,5);

        floats.get(2);
        floats.get(3);
        floats.length();
        floats.average();
        floats.sum();
        floats.max();
    }
}
