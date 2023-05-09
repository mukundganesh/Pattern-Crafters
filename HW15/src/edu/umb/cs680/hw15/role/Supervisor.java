package edu.umb.cs680.hw15.role;

import edu.umb.cs680.hw15.EmployeeRole;

public class Supervisor implements EmployeeRole {

    //supervisor has paygrade 2
    @Override
    public double calculateSalary(double base) {
        // Just base salary for regular employees
        return base;
    }

    @Override
    public double calculateBonus(double base) {
        //15% bonus for paygrade2
        return base*0.15;
    }

    @Override
    public double calculateHike(double base) {
        //// 10% hike for paygrade2
        return base*0.10;
    }


}
