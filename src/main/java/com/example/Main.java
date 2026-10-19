package com.example;

public class Main {
    public static void main(String[] args) throws Exception {
        Lion lion = new Lion("Самец");

        System.out.println(lion.getKittens());      // 1
        System.out.println(lion.hasMane);           // true
        System.out.println(lion.doesHaveMane());    // true
        System.out.println(lion.getFood());         // [Животные, Птицы, Рыба]

        System.out.println("5 спринт");
    }
}
