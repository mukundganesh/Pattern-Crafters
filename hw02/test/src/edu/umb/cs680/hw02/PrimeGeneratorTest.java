package edu.umb.cs680.hw02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrimeGeneratorTest {

    @Test
    void onetotwenty() {
        PrimeGenerator pri= new PrimeGenerator(1,20);
        pri.generatePrimes();
        Long[] predictedprimes = {2L,3L,5L,7L,11L,13L,17L,19L};
        assertArrayEquals(predictedprimes,pri.getPrimes().toArray());
    }

    @Test
    void negativetopositive() throws Exception {
        try{
            PrimeGenerator pri =new PrimeGenerator(-1,50);
            fail();
        }
        catch (RuntimeException wow){
            assertEquals("Wrong input values: from=-1 to=50",wow.getMessage());

        }

    }

    @Test
    void zerotohero() {
        try{
            PrimeGenerator pri =new PrimeGenerator(0,0);
            fail("Wrong input values: from=0 to=0" );
        }
        catch (RuntimeException wow){
            assertEquals("Wrong input values: from=0 to=0",wow.getMessage());

        }
    }

    @Test
    void isEven() {
        PrimeGenerator pri =new PrimeGenerator(2,100);
        pri.isEven(4);
        assertTrue(pri.isEven(4));

    }
    @Test
    void isprime(){
        PrimeGenerator pri =new PrimeGenerator(1,100);
        pri.isPrime(17);
        assertTrue(pri.isPrime(17));
    }

}