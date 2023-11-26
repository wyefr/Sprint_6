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

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {"Самец", true},
            {"Самка", false}
        });
    }

    @Test
    public void testDoesHaveMane() {
        Feline mockFeline = mock(Feline.class);
        Lion lion = Lion.getInstance(sex,mockFeline);
        assertEquals(isHaveMane, lion.doesHaveMane());
    }
}
