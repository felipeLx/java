package org.bootcamp.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileLoader {

    static public String readFile() {

        StringBuilder builder = new StringBuilder();

        try {

            BufferedReader reader = new BufferedReader(new FileReader("resources/maze"));

            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }


        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return builder.toString();
    }

}
