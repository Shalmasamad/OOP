package com.Day1.Hw;

public class Hw6 {
    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("Error: Please pass exactly one integer as a command line argument.");
        } else {
            int num = Integer.parseInt(args[0]);

            if(num % 2 == 0) {
                System.out.println(num + " is Even");
            } else {
                System.out.println(num + " is Odd");
            }
        }
    }
}
