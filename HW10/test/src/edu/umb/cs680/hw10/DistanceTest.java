package edu.umb.cs680.hw10;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DistanceTest {

    private  List<Double> values;
    private List<Double> x;
    private List<Double> y;

    public List<Double> minMaxNormalization(Car car) {
        values = List.of((double) car.getMileage(),(double) car.getYear(),(double) car.getPrice());
        double minValue = values.stream().min(Double::compareTo).orElseThrow();
        //System.out.println(minValue);
        double maxValue = values.stream().max(Double::compareTo).orElseThrow();
        //System.out.println(maxValue);
        List<Double> normalizedValues = new ArrayList<>();
        double range = maxValue - minValue;
        for (Double value : values) {
            double normalizedValue = (value - minValue) / range;
            normalizedValues.add(normalizedValue);
        }
        return normalizedValues;
    }

    Car car1=new Car("Toyota","RAV8",2021,15,10000);
    Car car2=new Car("Honda","Accord",2022,19,12000);
    Car car3=new Car("BMW","i8",2021,22,33000);
    Car car4=new Car("Nissan","Sentra",2001,19,18000);
    Car car5=new Car("Nissan","Lancer",2011,16,8000);
    List<Double> cordinates1 = minMaxNormalization(car1);
    List<Double> cordinates2 = minMaxNormalization(car2);
    List<Double> cordinates3 = minMaxNormalization(car3);
    List<Double> cordinates4 = minMaxNormalization(car4);
    List<Double> cordinates5 = minMaxNormalization(car5);




    @Test
    public void Manhattantest() throws Exception{
        List<List<Double>> l=List.of(cordinates1,cordinates2,cordinates3,cordinates4,cordinates5);
        List<List<Double>> l1=List.of(cordinates1,cordinates2,cordinates3,cordinates4,cordinates5);
        String Matrixactual="[[0.0, 0.033719981524745174, 0.1402851836733814, 0.09067388970670288, 0.048973397470955915], [0.033719981524745174, 0.0, 0.10656520214863621, 0.05695390818195771, 0.08269337899570109], [0.1402851836733814, 0.10656520214863621, 0.0, 0.04961129396667851, 0.1892585811443373], [0.09067388970670288, 0.05695390818195771, 0.04961129396667851, 0.0, 0.13964728717765879], [0.048973397470955915, 0.08269337899570109, 0.1892585811443373, 0.13964728717765879, 0.0]]";
        assertEquals(Distance.matrix(l,new Manhattan()).toString(),Matrixactual);
        assertEquals(0.033719981524745174,Distance.get(cordinates1,cordinates2,new Manhattan()));
    }

    @Test
    public void Euclideantest() throws Exception{
        List<List<Double>> l=List.of(cordinates1,cordinates2,cordinates3,cordinates4,cordinates5);
        List<List<Double>> l1=List.of(cordinates1,cordinates2,cordinates3,cordinates4,cordinates5);
        String Matrixactual="[[0.0, 0.033719981524745174, 0.1402851836733814, 0.09067388970670288, 0.048973397470955915], [0.033719981524745174, 0.0, 0.10656520214863621, 0.05695390818195771, 0.08269337899570109], [0.1402851836733814, 0.10656520214863621, 0.0, 0.04961129396667851, 0.1892585811443373], [0.09067388970670288, 0.05695390818195771, 0.04961129396667851, 0.0, 0.13964728717765879], [0.048973397470955915, 0.08269337899570109, 0.1892585811443373, 0.13964728717765879, 0.0]]";
        assertEquals(Matrixactual,Distance.matrix(l,new Euclidean()).toString());
        assertEquals(0.033719981524745174,Distance.get(cordinates1,cordinates2,new Euclidean()));
    }

    @Test
    public void Cosinetest() throws Exception {
        List<List<Double>> l=List.of(cordinates1,cordinates2,cordinates3,cordinates4,cordinates5);
        List<List<Double>> l1=List.of(cordinates1,cordinates2,cordinates3,cordinates4,cordinates5);
        String Matrixactual="[[0.0, 5.317458456122193E-4, 0.009468420015808832, 0.003911610414905953, 0.0010855221673559123], [5.317458456122193E-4, 0.0, 0.005518692768771483, 0.0015600524979819674, 0.003135578838089348], [0.009468420015808832, 0.005518692768771483, -2.220446049250313E-16, 0.001212150866896189, 0.01693865221896651], [0.003911610414905953, 0.0015600524979819674, 0.001212150866896189, 2.220446049250313E-16, 0.009108969561654079], [0.0010855221673559123, 0.003135578838089348, 0.01693865221896651, 0.009108969561654079, 0.0]]";
        assertEquals(Distance.matrix(l,new Cosine()).toString(),Matrixactual);
        assertEquals(5.317458456122193E-4,Distance.get(cordinates1,cordinates2,new Cosine()));
    }
}