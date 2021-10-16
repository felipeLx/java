package org.codewar;

/*
The >>> operator is the unsigned right bit-shift operator in Java.
It effectively divides the operand by 2 to the power of the right operand, or just 2 here.

The difference between >> and >>> would only show up when shifting negative numbers.
The >> operator shifts a 1 bit into the most significant bit if it was a 1, and the >>> shifts in a 0 regardless.
https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op3.html
 */
public class FindDuplicate {

    private static int findDuplicate(int[] array) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            System.out.println(mid);
            int midVal = array[mid];

            if (midVal == mid)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return high;
    }
}
