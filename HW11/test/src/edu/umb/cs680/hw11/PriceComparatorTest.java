package edu.umb.cs680.hw11;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class PriceComparatorTest {
    public static final ArrayList<Car> carss=new ArrayList<>();

    @BeforeAll
    public static void createcarsslist(){
        Car Cruze=new Car("chevrolet","cruze",2021,17,16000);
        Car Sentra=new Car("nissan","sentra",2018,16,13000);
        Car Camry=new Car("Toyota","camry",2022,19,19000);
        Car accord=new Car("Honda","accord",2019,20,17000);
        Car city=new Car("Honda","city",2016,18,12000);

        carss.add(Cruze);
        carss.add(Sentra);
        carss.add(Camry);
        carss.add(accord);
        carss.add(city);
    }

    @Test
    void PriceComparatortest(){
        Collections.sort(carss,new PriceComparator());
        String actual=carss.get(0).getModel()+","+
                carss.get(1).getModel()+","+ carss.get(2).getModel()+","+ carss.get(3).getModel()+","+ carss.get(4).getModel();
        assertEquals("city,sentra,cruze,accord,camry",actual);


    }

}