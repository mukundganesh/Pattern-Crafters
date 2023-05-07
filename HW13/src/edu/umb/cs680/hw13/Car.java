package edu.umb.cs680.hw13;

import java.util.ArrayList;
import java.util.Collections;

public class Car {
    private String make, model;
    private int mileage, year;
    private float price;
    private static ArrayList<Car> carss=new ArrayList<>();

    private int Dominationcount;

    private ArrayList<Car> carArrayList;

    public Car(String make, String model, int year, int mileage, float price) {
        this.make = make;
        this.model = model;
        this.mileage = mileage;
        this.year = year;
        this.price = price;
    }

    //Getter methods
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getMileage() {
        return mileage;
    }

    public int getYear() {
        return year;
    }

    public float getPrice() {
        return price;
    }

    public int getDominationcount() {
        return Dominationcount;
    }

    private boolean isDominating(Car fourwheeler) {
        return (this.getYear() > fourwheeler.getYear() ||
                this.getPrice() < fourwheeler.getPrice() ||
                this.getMileage() < fourwheeler.getMileage()) &&
                        this.getPrice() <= fourwheeler.getPrice() &&
                        this.getMileage() <= fourwheeler.getMileage() &&
                        this.getYear() >= fourwheeler.getYear();
    }

    public void setDominationcount(ArrayList<Car> carArrayList) {
        for (Car fourwheeler : carArrayList) {
            if (isDominating(fourwheeler)) {
                Dominationcount++;
            }
        }
    }


    public static void main(String[] args) {
    }

}
