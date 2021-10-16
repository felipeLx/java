package org.academiadecodigo.bootcamp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Word Reader reads a text file using a buffered (character) reader
 */
public class WordReader implements Iterable<String> {

    private final String filename;

    /**
     * Single argument constructor
     * @param filename the name of the file to to read
     */
    public WordReader(String filename) {
        this.filename = filename;
    }

    /**
     * To obtain an WordReader iterator
     * @return an instance of the WordReader iterator
     */
    @Override
    public Iterator<String> iterator() {
        return new WordReaderIterator();
    }

    private class WordReaderIterator implements Iterator<String> {

        private BufferedReader inputBufferedReader;
        private String[] words;
        private String nextLine;
        private int wordsIndex;

        public WordReaderIterator() {
            try {
                inputBufferedReader = new BufferedReader(new FileReader(filename));
                readLineOfWords();
                getNextLineWords();
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
        }

        private void readLineOfWords() {

            try {

                nextLine = inputBufferedReader.readLine();

                // end of file
                if (nextLine == null) {
                    return;
                }

                // line contains no words, fetch a new one
                if (nextLine.equals("") || wordSplit(nextLine).length == 0) {
                    readLineOfWords();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        private void getNextLineWords() {

                words = wordSplit(nextLine);
                wordsIndex = 0;

                readLineOfWords();

        }

        private String[] wordSplit(String line) {
            return line != null ? line.split("\\W+") : new String[]{line};
        }

        @Override
        public boolean hasNext() {

            return !(wordsIndex == words.length && nextLine == null);

        }

        @Override
        public String next() {

            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            if (wordsIndex == words.length) {
                getNextLineWords();
            }

            return words[wordsIndex++];

        }
    }

}
