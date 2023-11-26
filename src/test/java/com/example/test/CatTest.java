package com.example.test;

import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CatTest {

    @Mock
    private Feline mockFeline;

    private Cat cat;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        cat = new Cat(mockFeline);
    }

    @Test
    public void testGetSound() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(mockFeline.eatMeat()).thenReturn(expectedFood);
        List<String> actualFood = cat.getFood();
        assertEquals(expectedFood, actualFood);
    }
}
