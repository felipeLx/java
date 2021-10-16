package org.codewar;

import java.util.Arrays;
import java.util.List;

public class StreamEfficient {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,5,4,6,7,8,9,10);

        //given an order list find the double of the first
        //even number that is greater than 3
        System.out.println(
                numbers.stream()
                        .filter(e -> e > 3)
                        .filter(e -> e % 2 == 0)
                        .map(e -> e * 2)
                        .findFirst()
        );

        System.out.println(
                numbers.stream()
                        .filter(StreamEfficient::isGT3)
                        .filter(StreamEfficient::isEven)
                        .map(StreamEfficient::doubleIt)
                        .findFirst()
        );
    }

    public static boolean isGT3(int number) {
        return number > 3;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static int doubleIt(int number) {
        return number * 2;
    }
}
