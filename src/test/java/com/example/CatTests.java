package com.example;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CatTests {

    @Spy
    Feline feline = new Feline();

    @Description("Метод getSound должен возвращать Мяу")
    @Test
    void testGetSoundMyau() {
        Cat cat = new Cat(this.feline);
        assertEquals("Мяу", cat.getSound(), "Кошка должна говорить Мяу");
    }

    @Description("Метод getFood. Проверяем, что вызывается реализация eatMeat из Feline")
    @Test
    void testGetFoodCallsEatMeatFromFeline() throws Exception {
        Cat cat = new Cat(this.feline);
        cat.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }

    @Description("Метод getFood. Проверяем, что не вылетает исключение из getFood")
    @Test
    void testGetFoodCDoesNotThrowException() {
        Cat cat = new Cat(this.feline);
        Executable executable = cat::getFood;
        assertDoesNotThrow(executable, "Не должно вылетать исключение");
    }

    @Description("Метод getFood. Список еды не должен быть null")
    @Test
    void testGetFoodNotNullReturn() throws Exception {
        Cat cat = new Cat(this.feline);
        List<String> foods = cat.getFood();
        assertTrue(Objects.nonNull(foods), "Список еды не должен быть null");
    }
}