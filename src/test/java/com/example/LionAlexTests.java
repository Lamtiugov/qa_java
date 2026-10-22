package com.example;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(MockitoExtension.class)
public class LionAlexTests {

    @Mock
    private Feline feline;

    @Description("Конструктор LionAlex не должен кидать исключения")
    @Test
    void testLionAlexConstructorDoesNotThrowsException() {
        try {
            LionAlex lionAlex = new LionAlex(feline);
        } catch (Exception exception) {
            fail("Конструктор не должен кидать исключение");
        }
    }

    @Description("У Алекса три друга — зебра Марти, бегемотиха Глория и жираф Мелман." +
            " Здесь же и проверка на непустой список")
    @Test
    void doesGetFriendsReturnList() throws Exception {
        LionAlex lionAlex = new LionAlex(feline);
        List<String> actualList = lionAlex.getFriends();
        assertEquals(List.of("Марти", "Глория", "Мелман"), actualList, "Друзья Алекса: Марти, Глория, Мелман");
    }

    @Description("Алекс живёт — Нью-Йоркский зоопарк")
    @Test
    void doesGetPlaceOfLivingIsNewYorkZoo() throws Exception {
        LionAlex lionAlex = new LionAlex(feline);
        String actualPlace = lionAlex.getPlaceOfLiving();
        assertEquals("Нью-Йоркский зоопарк", actualPlace, "Алекс живёт — Нью-Йоркский зоопарк");
    }

    @Description("У Алекса нет львят")
    @Test
    void testGetKittensReturnZero() throws Exception {
         LionAlex lionAlex = new LionAlex(feline);
        int actualKittens = lionAlex.getKittens();
        assertEquals(0, actualKittens, "У Алекса нет львят");
    }
}