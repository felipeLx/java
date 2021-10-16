package org.codewar;

import java.util.ArrayList;
import java.util.List;

public class Accumul {

    public static String accum(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            char actualChar = s.charAt(i);
            for (int j = 0; j <= i; j++) {
                if(j == 0) {
                    result += Character.toUpperCase(actualChar);
                } else {
                    result += Character.toLowerCase(actualChar);
                }
            }
            result += "-";
        }
        return result.substring(0, result.length()-1);
    }

    public static String accumNew(String s) {
        StringBuilder bldr = new StringBuilder();
        int i = 0;
        for(char c : s.toCharArray()) {
            if(i > 0) bldr.append('-');
            bldr.append(Character.toUpperCase(c));
            for(int j = 0; j < i; j++) bldr.append(Character.toLowerCase(c));
            i++;
        }
        System.out.println(bldr.toString());
        return bldr.toString();
    }

    public static String reverseOrder(String s) {
        StringBuilder bldr = new StringBuilder();
        StringBuilder result = new StringBuilder();

//        for (int i = 0; i < s.length(); i++) {
//            bldr.append(s.charAt(i));
            for (int j = s.length(); j > 0; j--) {
                result.append(s.charAt(j));
            }


            result = bldr.reverse();

            System.out.println(result);

        System.out.println(bldr.toString());
        return bldr.toString();
    }


    public static void main(String[] args) {
        Accumul test = new Accumul();
        test.reverseOrder("ad321lda2");
    }
}
