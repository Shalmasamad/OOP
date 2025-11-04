package com.Day1.Hw;

public class Hw5 {
    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("Error: Please pass exactly one integer as a command line argument.");
        } else {
            int num = Integer.parseInt(args[0]);

            if(num > 0) {
                System.out.println(num + " is Positive");
            } else if(num < 0) {
                System.out.println(num + " is Negative");
            } else {
                System.out.println("The number is Zero");
            }
        }
    }
}
