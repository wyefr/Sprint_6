package com.example.test;

import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline felineMock;

    @Test
    public void testDoesHaveMane() {
        Lion lion = Lion.getInstance("Самец", felineMock);
        assertTrue(lion.doesHaveMane());
    }
    @Test
    public void testDoesHaveManeForMale() {
        Lion lion = Lion.getInstance("Самец", felineMock);
        assertTrue(lion.doesHaveMane());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidSex() {
        Lion.getInstance("Недопустимое значение пола", felineMock);
    }

    @Test(expected = IllegalStateException.class)
    public void testGetKittensWithoutFeline() {
        Lion lion = Lion.getInstance("Самка", null);
        lion.getKittens();
    }

    @Test
    public void testGetKittens() {
        when(felineMock.getKittens()).thenReturn(3);
        Lion lion = Lion.getInstance("Самец", felineMock);
        assertEquals(3, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = Lion.getInstance("Самец", felineMock);
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(felineMock.getFood("Хищник")).thenReturn(expectedFood);
        List<String> food = lion.getFood();
        assertEquals(expectedFood, food);
    }
}
