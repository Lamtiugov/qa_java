package com.example;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CatTests {

    @Spy
    private Feline felineSpy;

    @Mock
    private Feline felineMock;

    @Description("Кошка всегда говорит Мяу")
    @Test
    void getSoundAlwaysReturnsMyau() {
        Cat cat = new Cat(felineMock);
        assertEquals("Мяу", cat.getSound(), "Кошка должна говорить Мяу");
    }

    @Description("getFood на самом деле вызывает eatMeat из Feline")
    @Test
    void getFoodCallsEatMeatFromFeline() throws Exception {
        Cat cat = new Cat(this.felineSpy);
        cat.getFood();
        Mockito.verify(felineSpy, Mockito.times(1)).eatMeat();
    }

    @Description("Из getFood не должено лететь исключение")
    @Test
    void getFoodDoesNotThrowException() {
        Cat cat = new Cat(felineMock);
        Executable executable = cat::getFood;
        assertDoesNotThrow(executable, "Не должно вылетать исключение");
    }

    @Description("getFood должен вернуть список не null")
    @Test
    void getFoodDoesNotReturnsNullList() throws Exception {
        Cat cat = new Cat(felineMock);
        List<String> foods = cat.getFood();
        assertTrue(Objects.nonNull(foods), "Список еды не должен быть null");
    }
}