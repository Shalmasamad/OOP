package com.Day9;

public class RotateRecursive
{
    public static void rotateOnce(int[] arr) {
        int temp = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = temp;
    }
    public static void leftRotateRecursive(int[] arr, int k) {
        if (k == 0)
            return;
        rotateOnce(arr);
        leftRotateRecursive(arr, k - 1);
    }
    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40, 50};
        int k = 3;
        leftRotateRecursive(arr, k);
        System.out.print("Recursive Rotation: ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
