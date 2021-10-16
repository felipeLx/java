package org.codewar;

/*
Three conditions must be met for a valid experiment:
Float parameter "h" in meters must be greater than 0
Float parameter "bounce" must be greater than 0 and less than 1
Float parameter "window" must be less than h.
If all three conditions above are fulfilled, return a positive integer, otherwise return -1.
 */
public class BouncingBall {

    public static int bouncingBall(double h, double bounce, double window) {
        int result = 0;
        do {
            if (h <= 0 || bounce >= 1 || bounce <= 0 || window >= h)
                return -1;
            if (h > window)
                result++;
            h = h * bounce;
            if (h > window)
                result++;

        } while (h > window);

        return result;
    }

    public static int boucingBestPratice(double h, double bounce, double window) {
        if ((h <= 0) || (window >= h) || (bounce <= 0) || (bounce >= 1))
            return -1;
        int seen = -1;
        while (h > window) {
            seen += 2;
            h = h * bounce;
        }
        return seen;
    }
}
