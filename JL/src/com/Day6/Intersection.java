package com.Day6;
import java.util.HashSet;
import java.util.Set;

public class Intersection {
    public static int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        for (int n : nums1) {
            set1.add(n); // store unique elements of nums1
        }

        Set<Integer> result = new HashSet<>();
        for (int n : nums2) {
            if (set1.contains(n)) {
                result.add(n);
            }
        }

        // convert set to array
        int[] ans = new int[result.size()];
        int i = 0;
        for (int val : result) {
            ans[i++] = val;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 12,6,5, 1};
        int[] nums2 = {2, 3,5,12,2};

        int[] res = intersection(nums1, nums2);

        System.out.print("Intersection: ");
        for (int x : res) {
            System.out.print(x + " ");
        }
    }
}


