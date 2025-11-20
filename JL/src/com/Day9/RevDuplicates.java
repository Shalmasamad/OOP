package com.Day9;
import java.util.Arrays;
public class RevDuplicates {
        public static void main(String[] args) {

            int[] arr = {1, 2, 3, 2, 4, 1, 5};
            int n = arr.length;
            int[] temp = new int[n];
            int j = 0;
            for (int i = 0; i < n; i++) {
                boolean found = false;
                for (int k = 0; k < j; k++) {
                    if (arr[i] == temp[k]) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    temp[j++] = arr[i];
                }
            }
            int[] result = Arrays.copyOf(temp, j);

            System.out.println("Array after removing duplicates:");
            System.out.println(Arrays.toString(result));
        }
    }


