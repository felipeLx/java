package org.codewar;

import java.util.*;

public class ReverseArrays {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7};
        reverse(numbers);

        String word = "a2jh3it";
        reverseAndKeep(word);

        reverseKeep(word);

        keepAndReverse(word);

        reverseList(word);

    }

    public static void reverse(int[] input) {
//        System.out.println("Original array: " + Arrays.toString(input));

        if(input == null || input.length <= 1) {
            return;
        }

        for (int i = 0; i < input.length /2; i++) {
            int temp = input[i];
            input[i] = input[input.length -1 - i];
            input[input.length -1 -i] = temp;
        }

//        System.out.println("reversed array:" + Arrays.toString(input));
    }


    public static String reverseAndKeep(String str) {
        StringBuilder builder = new StringBuilder();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
//            builder.append(str.charAt(i));
            if(isNumber(str.charAt(i))) {
                builder.append(str.charAt(i));
            } else {
                builder.append(str.charAt(i)).reverse();
            }
        }
        System.out.println("ReverseAndKeep:" + builder.toString());
        return builder.toString();
    }

    public static String reverseKeep(String str) {
        char[] stringArray = new char[str.length()];

        for (int i = 0, j = stringArray.length - 1; i < stringArray.length; i++, j--) {
            if(isNumber(str.charAt(i))) {
                stringArray[i] = str.toCharArray()[i];
            } else {
                stringArray[i] = str.toCharArray()[j];
            }
        }

        System.out.println("ReverseKeep: " + Arrays.toString(stringArray));
        return Arrays.toString((stringArray));
    }

    public static String keepAndReverse(String str) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0, j = str.length() - 1; i < str.length(); i++, j--) {
            if(isNumber(str.charAt(i))) {
                builder.append(str.charAt(j));
            } else {
                builder.append(str.charAt(i));
            }
        }
        System.out.println("KeepAndReverse: " + builder.toString());
        return builder.toString();
    }

    public static String reverseList(String str) {
        List<Character> list = new ArrayList<>();
        for (int i = 0, j = str.length() - 1; i < str.length(); i++, j--) {
            if(isNumber(str.charAt(i))) {
                list.add(str.charAt(i));
            } else {
                list.add(str.charAt(j));
            }
        }
        System.out.println("List:" + list.toString());
        return list.toString();
    }

    public static boolean isNumber(char number) {
        switch (number) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                return true;
            default:
                return false;
        }
    }
}
