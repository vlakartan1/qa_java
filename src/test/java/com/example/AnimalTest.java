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
    public void getSound() {assertEquals("Мяу", cat.getSound());}

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
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        Assert.assertEquals(expectedFamily, actualFamily);
    }

    @Test
    public void testCatGetSound() {
        Cat cat = new Cat(new Feline());
        String expectedSound = "Мяу";
        String actualSound = cat.getSound();
        Assert.assertEquals(expectedSound, actualSound);
    }

    @Test
    public void testCatGetFood() throws Exception {
        Cat cat = new Cat(new Feline());
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = cat.getFood();
        Assert.assertEquals(expectedFood, actualFood);
    }  
}