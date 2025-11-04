package com.Day1.Hw;

public class Hw2 {
    public static void main(String[] args) {
        if(args.length != 2) {
            System.out.println("Error: Please pass exactly two command line arguments.");
        } else {
            System.out.println(args[0] + " Technologies " + args[1]);
        }
    }
}
