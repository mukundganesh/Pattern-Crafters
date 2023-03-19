package edu.umb.cs680.hw02;

import org.junit.jupiter.api.*;
import org.opentest4j.AssertionFailedError;

import java.util.Arrays;
import java.util.LinkedList;

import static edu.umb.cs680.hw02.SingletonPrimeGenerator.*;
import static org.junit.jupiter.api.Assertions.*;


class SingletonPrimeGeneratorTest {

    @Test
    void exceptionTest() {

        try {
            SingletonPrimeGenerator gen = new SingletonPrimeGenerator();
            gen.setRange(-1,100);
            gen.getInstance();
            fail("Failed");
        }
        catch (RuntimeException hello2){
            assertEquals("Wrong input values: from=-1 to=100",hello2.getMessage());
        }
    }
//            assertEquals(hello2.getMessage(), "Wrong input values: from=-1 to=-10");
//            System.out.println(hello2.getMessage());




    @Test
    void singletonGetInstance() {
        SingletonPrimeGenerator gen = new SingletonPrimeGenerator();
        SingletonPrimeGenerator pri = new SingletonPrimeGenerator();
        gen.setRange(20,100);
        SingletonPrimeGenerator x = SingletonPrimeGenerator.getInstance();
        pri.setRange(1,20);
        SingletonPrimeGenerator y = SingletonPrimeGenerator.getInstance();
        assertSame(x,y);
//        assertEquals(SingletonPrimeGenerator.getInstance(10,20).hashCode(), SingletonPrimeGenerator.getInstance(20,40).hashCode());
    }

    @Test

    void singletonNonNullTest()
    {
        SingletonPrimeGenerator Pri = new SingletonPrimeGenerator();
        Pri.setRange(1,20);
        assertNotNull(SingletonPrimeGenerator.getInstance());
    }

    @Test

    void testGetPrimes() {
        SingletonPrimeGenerator Pri = new SingletonPrimeGenerator();
        Pri.setRange(1,20);
        Pri.generatePrimes();
        LinkedList<Long> predicted = new LinkedList<Long>(Arrays.asList(2L, 3L, 5L, 7L,11L,13L,17L,19L));
        assertIterableEquals(predicted, Pri.getPrimes());
    }


}
