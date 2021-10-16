package org.codewar;

import static java.util.Arrays.stream;

/*
Given an array, find the integer that appears an odd number of times.

There will always be only one integer that appears an odd number of times
 */
public class FindOdd {
    public static int findIt(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int count = 0;
            for (int j = 0; j < a.length; j++) {
                if (a[i] == a[j])
                    count++;
            }
            if (count % 2 != 0)
                return a[i];
        }
        return -1;
    }

    public static int findItJannik(int[] arr) {
            return stream(arr).reduce(0, (x, y) -> x ^ y);
        }
}
