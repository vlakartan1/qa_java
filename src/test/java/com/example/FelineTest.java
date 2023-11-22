package com.example;

import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FelineTest {
    private Feline felineMock;
    private Cat cat;

    @Before
    public void setUp() {
        felineMock = mock(Feline.class);
        cat = new Cat(felineMock);
    }
    @Test
    public void getFood() throws Exception {
        when(felineMock.eatMeat()).thenReturn(List.of("Мясо"));
        assertEquals(List.of("Мясо"), cat.getFood());
    }

    @Test
    public void getFamily() {
        when(felineMock.getFamily()).thenReturn("Кошачьи");
        assertEquals("Кошачьи", felineMock.getFamily());
    }

    @Test
    public void eatMeat() throws Exception {
        when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), felineMock.eatMeat());
    }

    @Test
    public void getKittens() {
        when(felineMock.getKittens()).thenReturn(6);
        assertEquals(6, felineMock.getKittens());
    }

}