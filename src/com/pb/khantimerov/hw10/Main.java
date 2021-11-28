package com.pb.khantimerov.hw10;

public class Main {
    public static void main(String[] args) {

        NumBox<IntNumber> integers = new NumBox<>(4);
        integers.add( new IntNumber(100),0);
        integers.add( new IntNumber(0),1);
        integers.add( new IntNumber(100),2);
        integers.add( new IntNumber(-1),3);

        integers.length();
        integers.average();
        integers.sum();
        integers.max().get();
    }
}
