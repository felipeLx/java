package org.codewar;

import java.util.Arrays;
import java.util.List;

public class Streams {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);

        numbers.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2.0)
                .reduce(0.0, (carry, e) -> carry + e);
        //filter: 0 <= number of elements in the output <= numbers of element in input
        //input: Stream<T> filter takes Predicate<T>

        //map transform value
        //number of output == number of input
        //no guarantee on the type of the output with respect to the type of the input
        //parameter: Stream<T> map takes Function<T, R> to return Stream<R>

        //both filter and map stay within their swimlanes
        //reduce cuts across the swimlanes

        //reduce on Stream<T> takes two parameters:
        //first: is of Type of T
        //second: is of Type BiFunction<R,T,R> to produce a result of R
        /*

                filter   map      reduce
           x1      /                0.0
           ----------------------
           x2     ->      x2`  ->    +
           ----------------------
           x3      /
           ----------------------
           x4     ->      x4`  ->    +


         */
    }
}
