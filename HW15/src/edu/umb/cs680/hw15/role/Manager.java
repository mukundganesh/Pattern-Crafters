package edu.umb.cs680.hw15.role;

import edu.umb.cs680.hw15.EmployeeRole;

public class Manager implements EmployeeRole {

    //paygrade 1
    @Override
    public double calculateSalary(double base) {
        // Just base salary for regular employees
        return base;
    }

    @Override
    public double calculateBonus(double base) {
        //20% bonus for paygrade1
        return base*0.20;
    }

    @Override
    public double calculateHike(double base) {
        //15% hike for paygrade1
        return base*0.15;
    }
}
