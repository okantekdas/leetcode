package leetcode.other;

import java.util.Arrays;

public class CountingElements {

    public int countElements(int[] arr) {

        Arrays.sort(arr);

        int counter = 0;
        int tempCounter = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == arr[i]) {
                tempCounter++;
            } else if (arr[i - 1] + 1 == arr[i]) {
                counter += tempCounter;
                tempCounter = 1;
            } else {
                tempCounter = 1;
            }

        }

        return counter;

    }

    public static void main(String[] args) {

        int[] arr = { 2, 9, 0, 7, 6, 2, 7, 7, 0 };
        System.out.println(new CountingElements().countElements(arr));

    }

}