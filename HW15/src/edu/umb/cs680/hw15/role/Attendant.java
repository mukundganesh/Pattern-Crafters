package edu.umb.cs680.hw15.role;

import edu.umb.cs680.hw15.EmployeeRole;

public class Attendant implements EmployeeRole {
    //an Attendant is an employee with paygrade 4
    @Override
    public double calculateSalary(double base) {
        // Just base salary for regular employees
        return base;
    }

    @Override
    public double calculateBonus(double base) {
        //5% of base is bonus
        return base*0.05;
    }

    @Override
    public double calculateHike(double base) {
        //3% hike
        return base*0.03;
    }



}
