package com.Day1.Hw;

public class Hw7b {
    public static void main(String[] args) {

        if(args.length == 0) {
            System.out.println("No values");
            return;
        }

        int i = 0;
        while(i < args.length) {
            System.out.print(args[i]);
            if(i < args.length - 1) {
                System.out.print(",");
            }
            i++;
        }
    }
}
