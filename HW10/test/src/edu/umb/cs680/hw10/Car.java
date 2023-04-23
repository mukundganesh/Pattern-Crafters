package edu.umb.cs680.hw10;

import java.time.Year;

public class Car {
    private String make, model;
    private int mileage, year;
    private float price;

    public Car(String make,String model,int year,int mileage,float price){
        this.make =make;
        this.model=model;
        this.mileage=mileage;
        this.year=year;
        this.price=price;
    }

    //Getter methods
    public String getMake(){
        return make;
    }

    public String getModel(){
        return model;
    }

    public int getMileage(){
        return  mileage;
    }
    public  int getYear(){
        return year;
    }

    public float getPrice(){
        return price;
    }



    public static void main(String[] args) {
        Car honda=new Car("honda","amaze",2020,19,18000);
    }


}