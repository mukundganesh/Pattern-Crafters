package edu.umb.cs680.hw15.role;

import edu.umb.cs680.hw15.EmployeeRole;

public class Worker implements EmployeeRole {

//a worker is an employee with the paygrade 3
    @Override
    public double calculateSalary(double base) {
        // Just base salary for regular employees
        return base;
    }

    @Override
    public double calculateBonus(double base) {
        // 10% of base as bonus
        return base*0.10;
    }

    @Override
    public double calculateHike(double base) {
        // 5% hike for paygrade3
        return base*0.05;
    }
}
