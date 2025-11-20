package com.Day6;
import java.util.HashMap;
public class HashMapDemo {

        public static boolean isAnagram(String s, String t) {

            if (s.length() != t.length()) {
                return false; // different length -> not an anagram
            }

            HashMap<Character, Integer> map = new HashMap<>();

            // Count characters in string s
            for (char c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            // Subtract character counts using string t
            for (char c : t.toCharArray()) {
                if (!map.containsKey(c)) return false;

                map.put(c, map.get(c) - 1);

                // If count becomes negative -> more occurrences in t
                if (map.get(c) < 0) return false;
            }

            return true; // all counts balanced -> anagram
        }

        public static void main(String[] args) {
            String s = "anagram";
            String t = "nagaram";

            System.out.println(isAnagram(s, t)); // true
        }
    }

