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
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline felineMock;

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidSex() {
        new Lion("Недопустимое значение пола", felineMock);
    }

    @Test(expected = IllegalStateException.class)
    public void testGetKittensWithoutFeline() {
        Lion lion = new Lion("Самка", null);
        lion.getKittens();
    }

    @Test
    public void testGetKittens() {
        when(felineMock.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", felineMock);
        assertEquals(3, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(felineMock.getFood("Хищник")).thenReturn(expectedFood);
        List<String> food = lion.getFood();
        assertEquals(expectedFood, food);
    }

    @Test(expected = IllegalStateException.class)
    public void testGetFoodWithoutFeline() throws Exception {
        Lion lion = new Lion("Самец", null);
        lion.getFood();
    }
}
