package edu.umb.cs680.hw02;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;


import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class SingletonPrimeGeneratorTest {

    @Test
    void exceptionTest() {
        try {
            SingletonPrimeGenerator.getInstance(-1,-10);
            fail("Failed");
        }
        catch (RuntimeException hello2){
            assertEquals("Wrong input values: from=-1 to=10",hello2.getMessage());
//            assertEquals(hello2.getMessage(), "Wrong input values: from=-1 to=-10");
//            System.out.println(hello2.getMessage());
        }

    }

    @Test

    void singletonGetInstance() {
        assertSame(SingletonPrimeGenerator.getInstance(10,20), SingletonPrimeGenerator.getInstance(20,40));
        assertEquals(SingletonPrimeGenerator.getInstance(10,20).hashCode(), SingletonPrimeGenerator.getInstance(20,40).hashCode());
    }

    @Test

    void singletonNonNullTest()
    {
        assertNotNull(SingletonPrimeGenerator.getInstance(1,20));
    }

    @Test

    void testGetPrimes() {
        SingletonPrimeGenerator Pri = SingletonPrimeGenerator.getInstance(1, 20);
        Pri.generatePrimes();
        LinkedList<Long> predicted = new LinkedList<Long>(Arrays.asList(2L, 3L, 5L, 7L,11L,13L,17L,19L));
        assertIterableEquals(predicted, Pri.getPrimes());
    }




}
