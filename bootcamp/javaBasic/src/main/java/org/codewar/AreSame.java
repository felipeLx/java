package org.codewar;

import java.util.Arrays;

import static java.util.Arrays.stream;

public class AreSame {

    public static boolean comp(int[] a, int[] b) {
        boolean areTrue = true;
        if (a == null || b == null || a.length != b.length) {
            return false;
        }
        for (int i = 0; i < b.length; i++) {
            a[i] = a[i] * a[i];
        }
        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }


        }
        return areTrue;
    }

    public static boolean compBestPratice(int[]a, int[]b) {
        if(a == null || b == null) {
            return false;
        }
        int[]newArray = Arrays.stream(a).map(x -> x * x).toArray();
        Arrays.sort(newArray);
        Arrays.sort(b);
        return (Arrays.equals(newArray, b));
    }

}
