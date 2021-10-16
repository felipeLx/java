package org.codewar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionComposition {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3,4,5,6,7,8,9);

        int result = 0;

        //double to even number of the list
//        for (int e: list) {
//            if(e % 2 == 0) {
//                result += e*2;
//            }
//        }
//        System.out.println(result);

        System.out.println(
        list.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e*2)
                .reduce(0, Integer::sum));

        System.out.println(
                list.stream()
                        .filter(e -> e % 2 == 0)
                        .mapToInt(e -> e*2)
                        .sum());
    }
}
