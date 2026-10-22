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
class LionTests {

    @Spy
    private Feline felineSpy;

    @Mock
    private Feline felineMock;

    @Description("Позитивный тест конструктора класса Lion на поле Sex")
    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    void testLionConstructorSexParam(String sex, boolean hasMane) {
        try {
            Lion lion = new Lion(sex, felineMock);
            assertEquals(hasMane, lion.hasMane, "Для " + sex + " ожидается hasMane " + hasMane);
        } catch (Exception exception) {
            fail("Конструктор не должен кидать исключение на значение " + sex);
        }
    }

    @Description("Конструктор класса Lion должен кидать исключение для поля sex == null")
    @Test
    void testLionConstructorSexIsNullThrowException() {
        boolean exceptionTrows = false;
        try {
            Lion lion = new Lion(null, felineMock);
        } catch (Exception e) {
            exceptionTrows = true;
        }
        assertTrue(exceptionTrows,"Конструктор класса должен кидать исключение для поля sex == null");
    }

    @Description("getKittens вызывает метод Feline.getKittens()")
    @Test
    void testGetKittensCallsFelineGetKittensWithoutParams() throws Exception {
        Lion lion = new Lion("Самец", this.felineSpy);
        lion.getKittens();
        Mockito.verify(this.felineSpy, Mockito.times(1)).getKittens();
    }

    @Description("Метод doesHaveMane должен возвращать значение поля hasMane")
    @ParameterizedTest
    @ValueSource(strings = {"Самец", "Самка"})
    void testDoesHaveManeReturnsHasManeField(String sex) throws Exception {
        Lion lion = new Lion(sex, felineMock);
        boolean actualHasMane = lion.doesHaveMane();
        assertEquals(lion.hasMane, actualHasMane, "Ожидалось, что вернет значение поля hasMane");
    }

    @Description("getFood() вызывает метод Feline::getFood()")
    @Test
    void testGetFoodCallsFelineGetFood() throws Exception {
        Lion lion = new Lion("Самец", this.felineSpy);
        lion.getFood();
        Mockito.verify(this.felineSpy, Mockito.times(1)).getFood("Хищник");
    }

    @Description("getFood не должен выдавать исключение")
    @Test
    void testGetFoodDoesNotThrowsException() {
        try {
            Lion lion = new Lion("Самец", felineMock);
            Executable executable = lion::getFood;
            assertDoesNotThrow(executable, "Не должно вылетать исключение в getFood");
        } catch (Exception e) {
            fail("Lion не создался с валидным значением Самец");
        }
    }

    @Description("getFood должен вернуть не null")
    @Test
    void testGetFoodReturnNotNull() throws Exception {
        try {
            Lion lion = new Lion("Самец", felineMock);
            List<String> food = lion.getFood();
            assertTrue(Objects.nonNull(food), "getFood должен вернуть не null");
        } catch (Exception e) {
            fail("Lion не создался с валидным значением Самец");
        }
    }
}