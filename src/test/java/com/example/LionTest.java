package com.example;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Spy
    private Feline feline;

    @Test
    public void testDoesHaveMane() {
        Lion lion = Lion.getInstance("Самец", feline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testDoesHaveManeFemale() {
        Lion lion = Lion.getInstance("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void testGetKittens() {
        Mockito.when(feline.getKittens()).thenReturn(4);
        Lion lion = Lion.getInstance("Самец", feline);
        assertEquals(4, lion.getKittens());
    }

    @Test
    public void testDoesHaveManeException() {
        assertThrows(IllegalArgumentException.class, () -> Lion.getInstance("Зебра", feline));
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = Lion.getInstance("Самец", feline);
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }
}