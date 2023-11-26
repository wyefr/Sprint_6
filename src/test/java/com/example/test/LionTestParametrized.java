package com.example.test;

import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(Parameterized.class)
public class LionTestParametrized {

    private final String sex;
    private final boolean isHaveMane;

    public LionTestParametrized(String sex, boolean isHaveMane) {
        this.sex = sex;
        this.isHaveMane = isHaveMane;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}, {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {"Самец", true},
            {"Самка", false}
        });
    }

    @Test
    public void testDoesHaveMane() {
        Feline mockFeline = mock(Feline.class);
        Lion lion = new Lion(sex,mockFeline);
        assertEquals(isHaveMane, lion.doesHaveMane());
    }
}
