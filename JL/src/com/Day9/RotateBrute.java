package com.Day9;

public class RotateBrute {
        public static void leftRotateByOne(int[] arr) {
            int temp = arr[0];
            for (int i = 0; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[arr.length - 1] = temp;
        }
        public static void leftRotate(int[] arr, int k) {
            k = k % arr.length;
            for (int i = 0; i < k; i++) {
                leftRotateByOne(arr);
            }
        }
        public static void main(String[] args) {
            int arr[] = {1, 2, 3, 4, 5};
            int k = 2;
            leftRotate(arr, k);
            System.out.print("Brute Force Rotation: ");
            for (int x : arr) {
                System.out.print(x + " ");
            }
        }
    }


