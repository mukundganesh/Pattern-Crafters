package edu.umb.cs680.hw10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Distance {

	public static double get(List<Double> p1, List<Double> p2) throws Exception {
		return Distance.get(p1, p2, new Euclidean());
	}

	public static double get(List<Double> p1, List<Double> p2, DistanceMetric metric) throws Exception {
		return metric.distance(p1, p2);
	}

	
	public static List<List<Double>> matrix(List<List<Double>> points) throws Exception {
			return Distance.matrix(points, new Euclidean());
	};

	public static List<List<Double>> matrix(List<List<Double>> points, DistanceMetric metric) throws Exception {
		// This method is not that efficient; there is a room for performance
		// improvement by, for example, taking advantage of the symmetric nature
		// of a distance matrix. But, let's not worry about that here.   
		int numOfPoints = points.size();
		List<List<Double>> distanceMatrix = Distance.initDistanceMatrix(numOfPoints);
		List<Double> current, peer;

		for(int i=0; i < numOfPoints; i++) {
			current = points.get(i);
			for(int j=0; j < numOfPoints; j++) {
				peer = points.get(j);
				double distance = Distance.get(current, peer, metric);
				distanceMatrix.get(i).set(j, distance);
			}
		}
		return distanceMatrix;
	}
	
	private static List<List<Double>> initDistanceMatrix(int numOfPoints){
		List<List<Double>> distanceMatrix = new ArrayList<>(numOfPoints);
		for(int i=0; i < numOfPoints; i++) {
			Double[] vector = new Double[numOfPoints];
			Arrays.fill(vector, 0.0);
			distanceMatrix.add( Arrays.asList(vector) );
		}
		return distanceMatrix;
	}

	public static void main(String[] args) throws Exception {
		List<Double> p1 = List.of(0.0,5.0);
		System.out.println(p1);
		List<Double> p2 = List.of(5.0, 0.0);
		System.out.println(p2);
		List<Double> p3=List.of(11.0,12.0);
		List<List<Double>> l=List.of(p1,p2);
		System.out.println("---------------------------------------");
		System.out.println("Manhattan Metrics");
		System.out.println("---------------------------------------");
		System.out.println(Distance.matrix(l,new Manhattan()));
		System.out.println(Distance.get(p1,p2,new Manhattan()));
		System.out.println("---------------------------------------");
		System.out.println("Euclidean Metrics");
		System.out.println("---------------------------------------");
		System.out.println(Distance.matrix(l,new Euclidean()));
		System.out.println(Distance.get(p1,p2,new Euclidean()));
		System.out.println("---------------------------------------");
		System.out.println("Cosine Metrics");
		System.out.println("---------------------------------------");
		System.out.println(Distance.matrix(l,new Cosine()));
		System.out.println(Distance.get(p1,p2,new Cosine()));
	}
}
