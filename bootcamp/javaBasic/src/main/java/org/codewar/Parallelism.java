package org.codewar;

import java.util.Arrays;
import java.util.List;

public class Parallelism {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);

        Timeit.code(() ->
        System.out.println(
                numbers.parallelStream()
                    .filter(e -> e % 2 == 0)
                    .mapToInt(Parallelism::compute)
                    .sum()
        ));
    }

    public static int compute(int number) {
        //assume this is time intensive
        try{ Thread.sleep(1000); } catch (Exception e){}
        return number * 2;
    }
}
