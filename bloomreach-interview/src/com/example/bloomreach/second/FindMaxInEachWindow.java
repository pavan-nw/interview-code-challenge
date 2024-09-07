package com.example.bloomreach.second;

/**
 * Inputs: [2,5,2,3,5,7,8,3,2] k=3,
 * window moves from left to right one element at a time...
 * output the max at each instance of the window
 * output : [5,5,5,7,8,8,8]
 */
public class FindMaxInEachWindow {
    public static void main(String[] args) {
//        int[] arr = {2,5,2,3,5,7,8,3,2};
        int[] arr = {8,7,6,5,4,3,1};
        int k = 3;
        int[] output = new int[arr.length - k + 1];
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - k + 1; i++) {
            int max = arr[i];
            for (int j = i; i + k < arr.length && j < i + k; j++) {
                if (max < arr[j]) {
                    max = arr[j];
                } else if (arr[i] > secondMax) {
                    secondMax = max;
                }
            }
            output[i] = max;
        }

        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + " ");
        }
    }
}
