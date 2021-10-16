package org.codewar;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaExpression {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);

        //external iterators
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }

        for (int e: numbers) {
            System.out.println(e);
        }

        //internal iterators = benefit of polimophirsm
        numbers.forEach(new Consumer<Integer>() {
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        numbers.forEach(value -> System.out.println(value));

        numbers.forEach(System.out::println);

        //static method
        numbers.stream()
                .map(String::valueOf)
                .forEach(System.out::println);

        numbers.stream()
                .map(e -> e.toString())
                .forEach(System.out::println);

        //error compilation
//        System.out.println(
//        numbers.stream()
//                .reduce(0, (total, e) ->
//                    Integer.sum(total + e);
//                ));

        System.out.println(
                numbers.stream()
                .reduce(0, Integer::sum)
        );

        System.out.println(
        numbers.stream()
                .map(String::valueOf)
                .reduce("", (carry, str) -> carry.concat(str)));

        System.out.println(
                numbers.stream()
                        .map(String::valueOf)
                        .reduce("", String::concat));
    }
//    public static void main(String[] args) {

        // function has 4 things
        /*
        1. name
        2. parameter list
        3. body
        4. return type
         */

        // old approach
//        Thread th = new Thread(new Runnable() {
//            public void run() {
//                System.out.println("In another thread");
//            }
//        });
//        th.start();

//        System.out.println("in Main");
//    }

//    public static void main(String[] args) {
//        /*
//        lambda expression just have:
//        name - anonymous
//        1. parameter list
//        2. body
//        return - inferred
//         */
//        Thread th = new Thread(() -> System.out.println("thread in lambda"));
//        th.start();
//    }
}
