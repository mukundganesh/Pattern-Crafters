package edu.umb.cs680.hw15;

import edu.umb.cs680.hw15.role.Attendant;
import edu.umb.cs680.hw15.role.Manager;
import edu.umb.cs680.hw15.role.Supervisor;
import edu.umb.cs680.hw15.role.Worker;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EmployeePayTest {

    @Test
    void testsupervisorpaydetails(){
        EmployeeRole supervisor = new Supervisor();
        EmployeePay workerPay = new EmployeePay("John", 50000.0, supervisor);
        ArrayList<Double> SupervisorPayDetails = workerPay.executeStrategy(workerPay.getempBase());
        ArrayList<Double> expected=new ArrayList<Double>();
        expected.add(50000.0);
        expected.add(7500.0);
        expected.add(5000.0);
        assertEquals(expected,SupervisorPayDetails);
    }

    @Test
    void testworkerpaydetails(){
            EmployeeRole workerRole = new Worker();
            EmployeePay workerPay = new EmployeePay("John", 50000.0, workerRole);
            ArrayList<Double> workerPayDetails = workerPay.executeStrategy(workerPay.getempBase());
            ArrayList<Double> expected=new ArrayList<Double>();
            expected.add(50000.0);
            expected.add(5000.0);
            expected.add(2500.0);
            assertEquals(expected,workerPayDetails);
        }

    @Test
    void testattendantpaydetails(){
        EmployeeRole attendant = new Attendant();
        EmployeePay AttendantPay = new EmployeePay("John", 50000.0, attendant);
        ArrayList<Double> attendantPayDetails = AttendantPay.executeStrategy(AttendantPay.getempBase());
        ArrayList<Double> expected=new ArrayList<Double>();
        expected.add(50000.0);
        expected.add(2500.0);
        expected.add(1500.0);
        assertEquals(expected,attendantPayDetails);
    }

    @Test
    void testmanagerpaydetails(){
        EmployeeRole Manager = new Manager();
        EmployeePay Managerpay = new EmployeePay("John", 50000.0, Manager);
        ArrayList<Double> ManagerPayDetails = Managerpay.executeStrategy(Managerpay.getempBase());
        ArrayList<Double> expected=new ArrayList<Double>();
        expected.add(50000.0);
        expected.add(10000.0);
        expected.add(7500.0);
        assertEquals(expected,ManagerPayDetails);
    }
}

