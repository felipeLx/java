package org.codewar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamUtils {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,1,2,3,4,5);

        numbers.stream()
                .filter(e -> e % 2 == 0)
                .forEach(System.out::println);
        //sized, ordered, non-distinct, non-sorted

        numbers.stream()
                .filter(e -> e % 2 == 0)
                .sorted()
                .distinct()
                .forEach(System.out::println);
        //sized, ordered, distinct, sorted

        //infinite stream
        Stream.iterate(100, e -> e + 1);

        //given a number k, and count n, find the total of the double of the
        //even numbers starting with k, where sqrt of each number is > 20
        int k = 121;
        int n = 51;
        System.out.println(
                compute(k, n));
    }

    public static int compute(int k, int n) {
//        int result = 0;
//        int index = k;
//        int count = 0;
//
//        while(count < n) {
//            if(index % 2 == 0 && Math.sqrt(index) > 20) {
//                result = index * 2;
//                count++;
//            }
//            index++;
//        }

        //unbounded, lazy
        return Stream.iterate(k, e -> e + 1)
                      .filter(e -> e % 2 == 0)
                      .filter(e -> Math.sqrt(e) > 20)
                      .mapToInt(e -> e * 2)
                      .limit(n)
                      .sum();
    }



}
