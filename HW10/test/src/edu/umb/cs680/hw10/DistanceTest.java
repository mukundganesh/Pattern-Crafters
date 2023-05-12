package edu.umb.cs680.hw10;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DistanceTest {

    private List<Double> values;
    private List<Double> x;
    private List<Double> y;

    public List<List<Double>> minMaxNormalization(Car car1, Car car2, Car car3, Car car4, Car car5) {
        values = List.of((double) car1.getMileage(), (double) car1.getYear(), (double) car1.getPrice(), (double) car2.getMileage(), (double) car2.getYear(), (double) car2.getPrice(),
                (double) car3.getMileage(), (double) car3.getYear(), (double) car3.getPrice(), (double) car4.getMileage(), (double) car4.getYear(), (double) car4.getPrice(), (double) car5.getMileage(), (double) car5.getYear(), (double) car5.getPrice());
        double minValue = values.stream().min(Double::compareTo).orElseThrow();
        double maxValue = values.stream().max(Double::compareTo).orElseThrow();
        double range = maxValue - minValue;
        List<Double> normalizedValues = new ArrayList<>();
        for (Double value : values) {
            double normalizedValue = (value - minValue) / range;
            normalizedValues.add(normalizedValue);

        }
        List<List<Double>> Finalvalues = new ArrayList<>();
        Finalvalues = List.of(List.of(normalizedValues.get(0), normalizedValues.get(1), normalizedValues.get(2)), List.of(normalizedValues.get(3), normalizedValues.get(4), normalizedValues.get(5)),
                List.of(normalizedValues.get(6), normalizedValues.get(7), normalizedValues.get(8)),
                List.of(normalizedValues.get(9), normalizedValues.get(10), normalizedValues.get(11)),
                List.of(normalizedValues.get(12), normalizedValues.get(13), normalizedValues.get(14)));

        return Finalvalues;
    }


    Car car1 = new Car("Toyota", "RAV8", 2021, 15, 10000);
    Car car2 = new Car("Honda", "Accord", 2022, 19, 12000);
    Car car3 = new Car("BMW", "i8", 2021, 22, 33000);
    Car car4 = new Car("Nissan", "Sentra", 2001, 19, 18000);
    Car car5 = new Car("Nissan", "Lancer", 2011, 16, 8000);
    List<Double> cordinates1 = minMaxNormalization(car1, car2, car3, car4, car5).get(0);
    List<Double> cordinates2 = minMaxNormalization(car1, car2, car3, car4, car5).get(1);
    List<Double> cordinates3 = minMaxNormalization(car1, car2, car3, car4, car5).get(2);
    List<Double> cordinates4 = minMaxNormalization(car1, car2, car3, car4, car5).get(3);
    List<Double> cordinates5 = minMaxNormalization(car1, car2, car3, car4, car5).get(4);


    @Test
    public void Manhattantest() throws Exception {
        List<List<Double>> l1 = minMaxNormalization(car1,car2,car3,car4,car5);
        String Matrixexpected="[[0.0, 0.060785205396392324, 0.6974988631195997, 0.2432620888282553, 0.0609671062604214], [0.060785205396392324, 0.0, 0.6367742913445504, 0.18253751705320603, 0.1216916780354707], [0.6974988631195997, 0.6367742913445504, 0.0, 0.4554494467182052, 0.7584053357586782], [0.2432620888282553, 0.18253751705320603, 0.4554494467182052, 0.0, 0.3035622252539033], [0.0609671062604214, 0.1216916780354707, 0.7584053357586782, 0.3035622252539033, 0.0]]";
        assertEquals(Matrixexpected,Distance.matrix(l1,new Manhattan()).toString());
        assertEquals(0.060785205396392324,Distance.get(cordinates1,cordinates2,new Manhattan()));
    }

    @Test
    public void Euclideantest() throws Exception {
        List<List<Double>> l1 = minMaxNormalization(car1, car2, car3, car4, car5);
        String Matrixexpected = "[[0.0, 0.060633750189343194, 0.6972866777388924, 0.24253527360793548, 0.060634386837672014], [0.060633750189343194, 0.0, 0.6366530313201526, 0.1819019781684843, 0.12126773533324217], [0.6972866777388924, 0.6366530313201526, 0.0, 0.45475257339175795, 0.7579203492496545], [0.24253527360793548, 0.1819019781684843, 0.45475257339175795, 0.0, 0.3031682719417467], [0.060634386837672014, 0.12126773533324217, 0.7579203492496545, 0.3031682719417467, 0.0]]";
        assertEquals(Matrixexpected, Distance.matrix(l1, new Euclidean()).toString());
        assertEquals(0.060633750189343194, Distance.get(cordinates1, cordinates2, new Euclidean()));
    }

    @Test
    public void Cosinetest() throws Exception {
        List<List<Double>> l1 = minMaxNormalization(car1, car2, car3, car4, car5);
        String Matrixexpected = "[[1.1102230246251565E-16, 5.230201487089747E-4, 0.009441193991741259, 0.003894377842068142, 0.0010896521657550728], [5.230201487089747E-4, -2.220446049250313E-16, 0.005526230654827602, 0.0015642415541869958, 0.003121218097310474], [0.009441193991741259, 0.005526230654827602, -2.220446049250313E-16, 0.0012119978122197006, 0.01691846418639642], [0.003894377842068142, 0.0015642415541869958, 0.0012119978122197006, -2.220446049250313E-16, 0.009094558069567271], [0.0010896521657550728, 0.003121218097310474, 0.01691846418639642, 0.009094558069567271, -2.220446049250313E-16]]";
        assertEquals(Matrixexpected, Distance.matrix(l1, new Cosine()).toString());
        assertEquals(5.230201487089747E-4, Distance.get(cordinates1, cordinates2, new Cosine()));
    }
}