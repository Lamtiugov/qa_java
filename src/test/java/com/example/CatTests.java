package com.example;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CatTests {

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
        Cat cat = new Cat(felineMock);
        Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood(), "Стаб: Животные, Птицы, Рыба");
    }

    @Description("Еда: Животные, Птицы, Рыба")
    @Test
    void getFoodReturnsFixedList() throws Exception {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        List<String> foods = cat.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), foods, "Список еды должен быть: Животные, Птицы, Рыба");
    }
}