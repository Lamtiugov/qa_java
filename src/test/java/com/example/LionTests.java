package com.example;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LionTests {

    private Feline feline;

    @Description("Тест конструктора класса Lion")
    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false",
    })
    void testLionConstructorSexParam(String sex, boolean hasMane) throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(sex, feline);
        assertEquals(hasMane, lion.hasMane, "Для " + sex + " ожидается hasMane " + hasMane);
    }

    @Test
    void getKittens() {
    }

    @Test
    void doesHaveMane() {
    }

    @Test
    void getFood() {
    }
}