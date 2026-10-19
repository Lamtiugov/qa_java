package com.example;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FelineTest {

    @Description("Позитивный тест на для результата Кошачьи")
    @Test
    public void getFamilyKoshachyResultKoshachy(){
        Feline feline = new Feline();
        String actual = feline.getFamily();
        String expected = "Кошачьи";
        assertEquals(expected, actual, "Ожидается Кошачьи.");
    }

}