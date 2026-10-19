package com.example;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class FelineTest {

    @Spy
    private Feline feline;

    @Description("Метод getFamily. Позитивный тест для результата Кошачьи")
    @Test
    void testGetFamilyKoshachyResultKoshachyTrue(){
        Feline feline = new Feline();
        String actual = feline.getFamily();
        String expected = "Кошачьи";
        assertEquals(expected, actual, "Ожидается Кошачьи.");
    }

    @Description("Метод eatMeat. Рацион хищника: [Животные, Птицы, Рыба]")
    @Test
    // Stub не работает
    // Unnecessary stubbings detected.
    // Clean & maintainable test code requires zero unnecessary code.
    void eatMeatPredatorFoodResult() throws Exception {
        Feline feline = new Feline();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat(), "Рацион хищника: [Животные, Птицы, Рыба]");
    }

    @Description("Метод getKittens(int). Позитивный тест")
    @ParameterizedTest
    @ValueSource(ints = {1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0})
    void testGetKittensIntResultTrue(int kittensCount) {
        Feline feline = new Feline();
        int actual = feline.getKittens(kittensCount);
        assertEquals(kittensCount, actual, "Ожидается: " + kittensCount);
    }

    @Test
    void testGetKittensWithoutParams() {
        this.feline.getKittens();
        Mockito.verify(this.feline, Mockito.times(1)).getKittens(1);
    }
}