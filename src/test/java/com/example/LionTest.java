package com.example;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Spy
    private Feline felineSpy;

    @Test
    public void testGetKittens() {
        int KITTENS_COUNT = 3;
        Mockito.when(felineSpy.getKittens()).thenReturn(KITTENS_COUNT);
        Lion lion = Lion.getInstance("Самец", felineSpy);
        int result = lion.getKittens();
        assertEquals(KITTENS_COUNT, result);
    }

    @Test
    public void testDoesHaveMane() {
        Lion lion = Lion.getInstance("Самец", felineSpy);
        boolean result = lion.doesHaveMane();
        assertTrue(result);
    }

    @Test
    public void testDoesHaveManeWithException() {
        assertThrows(IllegalArgumentException.class, () -> Lion.getInstance("Сумка", felineSpy));
    }

    @Test
    public void testIsLion() {
        Lion lion = Lion.getInstance("Самец", felineSpy);
        boolean result = lion.doesHaveMane();
        assertTrue(result);
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = Lion.getInstance("Самец", felineSpy);
        List<String> result = lion.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), result);
    }
}