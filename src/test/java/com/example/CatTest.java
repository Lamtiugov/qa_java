package com.example;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CatTest {

    @Spy
    Predator predator;

    @Spy
    Feline feline = new Feline();

    @Description("Метод getSound. Позитивный тест.")
    @Test
    void getSoundMyau() {
        Cat cat = new Cat(this.feline);
        assertEquals("Мяу", cat.getSound(), "Кошка должна говорить Мяу");
    }

    @Description("Метод getFood. Проверяем, что вызывается реализация eatMeat из Feline")
    @Test
    void getFoodCallsEatMeatFromFeline() throws Exception {
        Cat cat = new Cat(this.feline);
        cat.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }

    @Description("Метод getFood. Проверяем, что не вылетает исключение из eatMeat")
    @Test
    void getFoodCDoesNotThrowException() {
        Cat cat = new Cat(this.feline);
        Executable executable = cat::getFood;
        assertDoesNotThrow(executable, "Не должно вылетать исключение.");
    }
}