package com.Day1.Hw;

public class Hw1 {
        public static void main(String[] args) {
            // Check if exactly 2 arguments are given
            if(args.length != 2) {
                System.out.println("Please enter your two command line arguments");
                return;
            }
            String company = args[0];
            String location = args[1];

            System.out.println(company + " Technologies " + location);
        }

}
