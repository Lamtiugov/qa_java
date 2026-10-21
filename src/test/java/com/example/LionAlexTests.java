package com.example;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class LionAlexTests {

    @Description("Конструктор LionAlex не должен кидать исключения")
    @Test
    void testLionAlexConstructorDoesNotThrowsException() {
        Feline feline = new Feline();

        try {
            LionAlex lionAlex = new LionAlex(feline);
        } catch (Exception exception) {
            fail("Конструктор не должен кидать исключение");
        }
    }

    @Test
    void getFriends() {
    }

    @Test
    void getPlaceOfLiving() {
    }

    @Test
    void getKittens() {
    }
}