package edu.umb.cs680.hw01;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.*;



class PrimeGeneratorTest {

    @Test
    void oneto20() {
        PrimeGenerator prime = new PrimeGenerator(1,20);
        prime.generatePrimes();
        Long[] expprime = {2L,3L,5L,7L,11L,13L,17L,19L};
        assertArrayEquals(expprime,prime.getPrimes().toArray());
    }

    @Test
    void isdivisiblebytwo(){
        PrimeGenerator prime = new PrimeGenerator(2,30);
        prime.isEven(11);
        assertFalse(prime.isEven(11));
    }

    @Test
    void zero(){
        try {
            PrimeGenerator prime = new PrimeGenerator(0, 0);
            fail("Wrong input values: from=0 to=0");
        }
        catch (RuntimeException hello){
            assertEquals("Wrong input values: from=0 to=0",hello.getMessage());
        }

    }

    @Test
    void isprimetest(){
        PrimeGenerator prime= new PrimeGenerator(1,20);
        assertTrue(prime.isPrime(19));
    }


}