package com.example;

import jdk.jfr.Description;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
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
    void testGetFamilyKoshachyResultKoshachy(){
        Feline feline = new Feline();
        String actual = feline.getFamily();
        String expected = "Кошачьи";
        assertEquals(expected, actual, "Ожидается Кошачьи.");
    }

    @Description("Метод eatMeat. Проверяем, что вызывается метод Animal::getFood")
    @Test
    void testEatMeatCallsAnimalFood() throws Exception {
        this.feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Description("Метод eatMeat. Проверяем, что не вылетает исключение из eatMeat")
    @Test
    void testEatMeatDoesNotThrowException() {
        Feline feline = new Feline();
        Executable executable = feline::eatMeat;
        assertDoesNotThrow(executable, "Не должно вылетать исключение.");
    }

    @Description("Метод getKittens(int). Тест на разные значения.")
    @ParameterizedTest
    @ValueSource(ints = {1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0})
    void testGetKittensIntResultTrue(int kittensCount) {
        Feline feline = new Feline();
        int actual = feline.getKittens(kittensCount);
        assertEquals(kittensCount, actual, "Ожидается: " + kittensCount);
    }

    @Description("Метод getKittens на самом деле вызывает getKittens(1)")
    @Test
    void testGetKittensWithoutParams() {
        this.feline.getKittens();
        Mockito.verify(this.feline, Mockito.times(1)).getKittens(1);
    }
}