package com.Day5;
import java.util.HashMap;
import java.util.Map;
public class HashSum {
        public static void main(String[] args) {

            // Input Array and Target
            int[] nums = {2, 7, 11, 15};
            int target = 9;
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int tarnum = target - nums[i];
                if (map.containsKey(tarnum)) {
                    System.out.println("Indices: " + map.get(tarnum) + " , " + i);
                    System.out.println("Values: " + nums[map.get(tarnum)] + " + " + nums[i] + " = " + target);
                    return;
                }
                map.put(nums[i], i);
            }

            System.out.println("No two sum solution found");
        }
    }



