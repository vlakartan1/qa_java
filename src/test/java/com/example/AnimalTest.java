package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AnimalTest {
    private Feline felineMock;
    private Cat cat;

    @Before
    public void setUp() {
        felineMock = mock(Feline.class);
        cat = new Cat(felineMock);
    }

    @Test
    public void getSound() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFood() throws Exception {
        when(felineMock.eatMeat()).thenReturn(List.of("Корм"));
        assertEquals(List.of("Корм"), cat.getFood());
    }


    @Test
    public void testFelineEatMeat() throws Exception {
        when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), felineMock.eatMeat());
    }

    @Test
    public void testFelineGetFamily() {
        Feline feline = new Feline();
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testCatGetSound() {
        Cat cat = new Cat(new Feline());
        Assert.assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testCatGetFood() throws Exception {
        Cat cat = new Cat(new Feline());
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood());
    }
}