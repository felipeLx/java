package org.academiadecodigo.bootcamp;

import java.util.HashMap;
import java.util.Iterator;

/**
 * WordHistogram iterable class wrapper for the WordReader
 */
public class WordHistogram extends HashMap<String, Integer> implements Iterable<String> {

    WordReader wordReader;

    WordHistogram(String filename) {
        wordReader = new WordReader(filename);

        Iterator<String> it = wordReader.iterator();
        while (it.hasNext()) {

            String s = it.next();
            if (!containsKey(s)) {
               put(s, 1);
            } else {
                put(s, get(s) + 1);
            }

        }
    }

    @Override
    public Iterator<String> iterator() {
        return keySet().iterator();
    }
}
