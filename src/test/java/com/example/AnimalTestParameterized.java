package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class AnimalTestParameterized {
    private final String animalKind;
    private final List<String> expectedFood;

    public AnimalTestParameterized(String animalKind, List<String> expectedFood) {
        this.animalKind = animalKind;
        this.expectedFood = expectedFood;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Травоядное", Arrays.asList("Трава", "Различные растения")},
                {"Хищник", Arrays.asList("Животные", "Птицы", "Рыба")}
        });
    }

    @Test
    public void testGetFood() {
        Animal animal = new Animal();
        try {
            List<String> actualFood = animal.getFood(animalKind);
            assertTrue(actualFood.containsAll(expectedFood) && expectedFood.containsAll(actualFood));
        } catch (Exception e) {
            fail("Неожиданное исключение: " + e.getMessage());
        }
    }
}