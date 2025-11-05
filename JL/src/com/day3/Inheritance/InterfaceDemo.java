package com.day3.Inheritance;

    interface Payable{
        void generatePayslip();

    }
    class Contractor implements Payable{
        public void generatePayslip(){
            System.out.println("Contractor salary");
        }
    }

    class FullTimeEmployee implements Payable{
        @Override
        public void generatePayslip() {
            System.out.println("Full Time Employee salary");
        }
    }

    public class InterfaceDemo {
        public static void main(String[] args) {

        }
    }

