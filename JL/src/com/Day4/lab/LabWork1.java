package com.Day4.lab;
interface Payable {
    void generatePayslip();
}
class Contractor implements Payable {
    private String name;
    private int hoursWorked;
    private double hourlyRate;

    public Contractor(String name, int hoursWorked, double hourlyRate) {
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public void generatePayslip() {
        double totalPay = hoursWorked * hourlyRate;
        System.out.println("=== Contractor Payslip ===");
        System.out.println("Name: " + name);
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Hourly Rate: $" + hourlyRate);
        System.out.println("Total Pay: $" + totalPay);
        System.out.println();
    }
}
class FullTimeEmployee implements Payable {
    private String name;
    private double monthlySalary;

    public FullTimeEmployee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    @Override
    public void generatePayslip() {
        System.out.println("=== Full-Time Employee Payslip ===");
        System.out.println("Name: " + name);
        System.out.println("Monthly Salary: $" + monthlySalary);
        System.out.println();
    }
}
public class LabWork1 {
    public static void main(String[] args) {
        Payable p1 = new Contractor("ZuhaFathima", 160, 25.0); // 160 hrs, $25/hr
        Payable p2 = new FullTimeEmployee("AzwaFathima", 5000.0); // $5000 monthly
        p1.generatePayslip();
        p2.generatePayslip();
    }
}

