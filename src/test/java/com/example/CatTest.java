package com.example;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CatTest {
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
}