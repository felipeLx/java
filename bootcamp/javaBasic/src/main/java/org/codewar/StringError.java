package org.codewar;

public class StringError {

    public static String printerError(String s) {
        int printErr = 0;

        for (int i = 0; i < s.length(); i++) {
            // assuming the input rules hold true, we really only need the second condition
            if (s.charAt(i) < 'a' || s.charAt(i) > 'm') {
                printErr++;
            }
        }

        return String.format("%d/%d", printErr, s.length());
    }

    public static String printerOtherError(String s) {
        return s.replaceAll("[a-m]", "").length() + "/" + s.length();
    }
}
