package com.example;

import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class LionTestParamertrized {

    private final String sex;
    private final Feline felineSpy;
    private final boolean isHaveMane;

    public LionTestParamertrized(String sex, Feline felineSpy, boolean isHaveMane) {
        this.sex = sex;
        this.felineSpy = felineSpy;
        this.isHaveMane = isHaveMane;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", new Feline(), true},
                {"Самка", new Feline(), false}
        });
    }

    @Test
    public void testDoesHaveMane() {
        Lion lion = Lion.getInstance(sex, felineSpy);
        assertEquals(isHaveMane,lion.doesHaveMane());
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = Lion.getInstance(sex, felineSpy);
        assertEquals(List.of("Животные","Птицы", "Рыба"), lion.getFood());
    }
}