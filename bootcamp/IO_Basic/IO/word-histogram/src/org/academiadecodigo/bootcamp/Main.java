package org.academiadecodigo.bootcamp;

import java.util.Iterator;
import java.util.Set;

/**
 * WordHistogram entry point
 */
public class Main {

    public static final String FILE_PATH = "resources/lorem_ipsum.txt";

    public static void main(String[] args) {
        listWordHistogram(FILE_PATH);
    }

   public static void listWordHistogram(String fileName) {

        WordHistogram wordHistogram = new WordHistogram(fileName);
        System.out.println("MAP has " + wordHistogram.size() + " distinct words");

        Iterator<String> it = wordHistogram.iterator();

        while (it.hasNext()) {

            String word = it.next();
            int times = wordHistogram.get(word);

            System.out.println(word + " : " + times);

        }

    }
}
