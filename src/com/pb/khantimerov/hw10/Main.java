package com.pb.khantimerov.hw10;

public class Main {
    public static void main(String[] args) {

        NumBox<Integer> integers = new NumBox<>(4);
        integers.add( new Integer(100),0);
        integers.add( new Integer(0),1);
        //integers.add( new Integer(200),2);
        integers.add( new Integer(-100),3);
        integers.add( new Integer(-1),3);
        integers.add( new Integer(1000),4);

        integers.get(2);
        integers.get(3);
        integers.length();
        integers.average();
        integers.sum();
        integers.max();

        System.out.println();

        NumBox<Float> floats = new NumBox<>(5);
        floats.add( new Float(10.0),0);
        floats.add( new Float(500.0),1);
        //floats.add( new Float(50.0),2);
        floats.add( new Float(-10.0),3);
        floats.add( new Float(99.0), 4);
        floats.add( new Float(99.0),5);

        floats.get(2);
        floats.get(3);
        floats.length();
        floats.average();
        floats.sum();
        floats.max();
    }
}
