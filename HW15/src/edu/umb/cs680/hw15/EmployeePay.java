package edu.umb.cs680.hw15;

import java.util.ArrayList;

public class EmployeePay {

    private EmployeeRole employeeRole;
    private String name;
    private double base;

    protected ArrayList<Double> paydetails;


    public EmployeePay(String name, double base, EmployeeRole employeerole) {
        this.employeeRole = employeerole;
        this.name = name;
        this.base = base;
        this.paydetails=new ArrayList<>();
    }

    public String getempName(){
        return name;
    }

    public double getempBase() {
        return base;
    }

    public void setEmployeeRole(EmployeeRole employeeRole) {
        this.employeeRole = employeeRole;

    }

    public ArrayList<Double> executeStrategy(double base) {
        paydetails.add(employeeRole.calculateSalary(base));
        paydetails.add(employeeRole.calculateBonus(base));
        paydetails.add(employeeRole.calculateHike(base));
        return paydetails;
    }

    public static void main(String[] args) {

    }
}
