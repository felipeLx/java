package com.felipelisboa.test.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestBook {

    static Runnable runnable = new Runnable() {

        public void run() {
            System.out.println("hi");
            new Thread(() -> System.out.println("hi")).start();
        }
    };

    public static void main(String[] args) {
        new Thread(runnable).start();

    }

    public class Java8 {

        List<String> strs = Arrays.asList("C", "a", "A", "b");


    }

}
