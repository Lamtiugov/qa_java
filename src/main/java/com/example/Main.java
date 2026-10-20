package com.example;

public class Main {
    public static void main(String[] args) throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion("Самец", feline);

//        System.out.println(lion.getKittens());      // 1
//        System.out.println(lion.hasMane);           // true
//        System.out.println(lion.doesHaveMane());    // true
//        System.out.println(lion.getFood());         // [Животные, Птицы, Рыба]
//
//        System.out.println(feline.getFamily());
        System.out.println(feline.eatMeat());
//        System.out.println(feline.getKittens());
//        System.out.println(feline.getKittens());
        System.out.println("5 спринт");
    }
}
