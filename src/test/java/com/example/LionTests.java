package com.example;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LionTests {

    private Feline feline;

    @Description("Позитивный тест конструктора класса Lion на поле Sex")
    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    void testLionConstructorSexParam(String sex, boolean hasMane) {
        Feline feline = new Feline();

        try {
            Lion lion = new Lion(sex, feline);
            assertEquals(hasMane, lion.hasMane, "Для " + sex + " ожидается hasMane " + hasMane);
        } catch (Exception exception) {
            fail("Конструктор не должен кидать исключение на значение " + sex);
        }
    }

    @Description("Конструктор класса Lion должен кидать исключение для поля sex == null")
    @Test
    void testLionConstructorSexIsNullThrowException() {
        Feline feline = new Feline();
        boolean exceptionTrows = false;
        try {
            Lion lion = new Lion(null, feline);
        } catch (Exception e) {
            exceptionTrows = true;
        }
        assertTrue(exceptionTrows,"Конструктор класса должен кидать исключение для поля sex == null");
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