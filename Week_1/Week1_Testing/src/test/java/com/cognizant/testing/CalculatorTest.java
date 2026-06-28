package com.cognizant.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calc;

    @BeforeEach
    public void setup(){

        System.out.println("Creating Calculator Object");

        calc = new Calculator();

    }

    @AfterEach
    public void teardown(){

        System.out.println("Test Finished");

    }

    @Test
    public void testAddition(){

        // Arrange

        // Act
        int result = calc.add(2,3);

        // Assert
        assertEquals(5,result);

    }

    @Test
    public void testSubtraction(){

        int result = calc.subtract(8,3);

        assertEquals(5,result);

    }

    @Test
    public void testMultiplication(){

        int result = calc.multiply(4,5);

        assertEquals(20,result);

    }

}