package edu.umb.cs680.hw10;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Manhattan implements DistanceMetric{
    @Override
    public double distance(List<Double> p1, List<Double> p2) throws IllegalAccessException {
        if (p1.size() == p2.size()) {
            double sumOfDifferences = 0.0;
            for (int i = 0; i < p1.size(); i++) {
                sumOfDifferences += Math.abs(p1.get(i) - p2.get(i));
            }
            return sumOfDifferences;
        }
        else {
            throw new IllegalAccessException("P1 and P2 do not have the same size");
        }
    }
}

