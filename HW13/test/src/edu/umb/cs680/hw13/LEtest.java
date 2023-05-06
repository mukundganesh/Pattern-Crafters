package edu.umb.cs680.hw13;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LEtest {

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
    void pricecomparatortest(){
        Collections.sort(carss, Comparator.comparing(Car::getPrice,Comparator.naturalOrder()));
        String actual=carss.get(0).getModel()+","+
                carss.get(1).getModel()+","+ carss.get(2).getModel()+","+ carss.get(3).getModel()+","+ carss.get(4).getModel();
        assertEquals("city,sentra,cruze,accord,camry",actual);
    }

    @Test
    void reversepricecomparatortest(){
        Collections.sort(carss, Comparator.comparing(Car::getPrice).reversed());
        String actual=carss.get(0).getModel()+","+
                carss.get(1).getModel()+","+ carss.get(2).getModel()+","+ carss.get(3).getModel()+","+ carss.get(4).getModel();
        assertEquals("camry,accord,cruze,sentra,city",actual);
    }

    @Test
    void Mileagecomparatortest(){
        Collections.sort(carss,Comparator.comparing((Car car)->car.getMileage()));
        String actual=carss.get(0).getModel()+","+
                carss.get(1).getModel()+","+ carss.get(2).getModel()+","+ carss.get(3).getModel()+","+ carss.get(4).getModel();
        assertEquals("sentra,cruze,city,camry,accord",actual);
    }

    @Test
    void reverseMileagecomparatortest(){
        Collections.sort(carss,Comparator.comparing((Car car)->car.getMileage(),Comparator.reverseOrder()));
        String actual=carss.get(0).getModel()+","+
                carss.get(1).getModel()+","+ carss.get(2).getModel()+","+ carss.get(3).getModel()+","+ carss.get(4).getModel();
        assertEquals("accord,camry,city,cruze,sentra",actual);
    }

    @Test
    void yearComparisiontest(){
        Collections.sort(carss,Comparator.comparing(Car::getYear));
        String actual=carss.get(0).getModel()+","+
                carss.get(1).getModel()+","+ carss.get(2).getModel()+","+ carss.get(3).getModel()+","+ carss.get(4).getModel();
        assertEquals("city,sentra,accord,cruze,camry",actual);
    }

    @Test
    void reverseyearComparisiontest(){
        Collections.sort(carss,Comparator.comparing(Car::getYear,Comparator.reverseOrder()));
        String actual=carss.get(0).getModel()+","+
                carss.get(1).getModel()+","+ carss.get(2).getModel()+","+ carss.get(3).getModel()+","+ carss.get(4).getModel();
        assertEquals("camry,cruze,accord,sentra,city",actual);
    }
}
