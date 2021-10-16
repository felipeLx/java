package org.codewar;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SumOfInterval {
    public static int sumIntervals(int[][] intervals) {
        // TODO: implement this method
        return intervals == null ? 0 : (int) Arrays.stream(intervals)
                .flatMapToInt(interval -> IntStream.range(interval[0], interval[1]))
                .distinct()
                .count();
    }
}
