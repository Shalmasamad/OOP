package com.Day1.Hw;

public class Hw9 {
    public static void main(String[] args) {

        char ch = '@'; // Change this value to test other characters

        if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
            System.out.println("Alphabet");
        }
        else if(ch >= '0' && ch <= '9') {
            System.out.println("Digit");
        }
        else {
            System.out.println("Special Character");
        }
    }
}
