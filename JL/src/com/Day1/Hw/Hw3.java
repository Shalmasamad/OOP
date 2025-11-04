package com.Day1.Hw;

public class Hw3 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Error: Please pass one name as a command line argument.");
        } else {
            System.out.println("Welcome " + args[0]);
        }
    }
}
