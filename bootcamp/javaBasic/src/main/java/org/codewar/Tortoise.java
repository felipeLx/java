package org.codewar;

public class Tortoise {

    public static int[] race(int v1, int v2, int g) {
        int totalSecondsTaken = 0;
        if (v2 > v1) {
            totalSecondsTaken = (g * 3600) / (v2 - v1);
        } else {
            return null;
        }
        return new int[]{totalSecondsTaken / 3600, (totalSecondsTaken % 3600) / 60, totalSecondsTaken % 60};
    }
}
