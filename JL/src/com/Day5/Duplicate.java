package com.Day5;
import java.util.*;

public class Duplicate {
    public static boolean CDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int x : nums) {
            if (!seen.add(x)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(CDuplicate(new int[]{1,2,3,3}));
        System.out.println(CDuplicate(new int[]{1,7,3,4}));
    }
}
