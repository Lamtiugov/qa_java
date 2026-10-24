package com.example;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class LionTests {

    @Mock
    private Feline felineMock;

    @Description("Позитивный тест конструктора класса Lion на поле Sex")
    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    void lionConstructorWithValidSexParamsWorks(String sex, boolean hasMane) {
        try {
            Lion lion = new Lion(sex, felineMock);
            assertEquals(hasMane, lion.hasMane, "Для " + sex + " ожидается hasMane " + hasMane);
        } catch (Exception exception) {
            fail("Конструктор не должен кидать исключение на значение " + sex);
        }
    }

    @Description("Конструктор класса Lion должен кидать исключение для поля sex == null")
    @Test
    void lionConstructorWithSexNullThrowsException() {
        boolean exceptionTrows = false;
        try {
            Lion lion = new Lion(null, felineMock);
        } catch (Exception e) {
            exceptionTrows = true;
        }
        assertTrue(exceptionTrows,"Конструктор класса должен кидать исключение для поля sex == null");
    }

    @Description("getKittens вызывает метод Feline.getKittens(), который всегда возвращает 1")
    @Test
    void getKittensAlwaysReturnsOne() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion("Самец", feline);
        int actual = lion.getKittens();
        assertEquals(1, actual, "getKittens всегда возвращает 1");
    }

    @Description("doesHaveMane должен возвращать значение поля hasMane")
    @ParameterizedTest
    @ValueSource(strings = {"Самец", "Самка"})
    void haveManeReturnsHasManeField(String sex) throws Exception {
        Lion lion = new Lion(sex, felineMock);
        boolean actualHasMane = lion.doesHaveMane();
        assertEquals(lion.hasMane, actualHasMane, "Ожидалось, что вернет значение поля hasMane");
    }

    @Description("getFood не должен выдавать исключение")
    @Test
    void getFoodDoesNotThrowsException() {
        try {
            Lion lion = new Lion("Самец", felineMock);
            Executable executable = lion::getFood;
            assertDoesNotThrow(executable, "Не должно вылетать исключение в getFood");
        } catch (Exception e) {
            fail("Lion не создался с валидным значением Самец");
        }
    }

    @Description("eatMeat на самом деле вызывает feline.getFood")
    @Test
    void getFoodCallsFelineGetFood() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        Mockito.when(felineMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> foods = lion.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), foods, "getFood должен вызывать Feline.getFood");
    }

    @Description("Еда: Животные, Птицы, Рыба")
    @Test
    void getFoodReturnsFixedList() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion("Самец", feline);
        List<String> foods = lion.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), foods, "getFood должен вернуть: Животные, Птицы, Рыба");
    }
}