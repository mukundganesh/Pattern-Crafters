package edu.umb.cs680.hw04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private String[] carToStringArray(Car car) {
        var year = String.valueOf(car.getYear());
        String[] value = new String[]{car.getMake(), car.getModel(), year};
        return value;
    }

        @Test
        void verifyCarEqualityWithMakeModelYear() {
            String[] valueexpected;
            valueexpected = new String[]{"Toyota", "RAV4", "2018"};
            Car actual = new Car("Toyota", "RAV4", 2018, 19, 18000);
            assertArrayEquals(valueexpected, carToStringArray(actual));
        }
    }


