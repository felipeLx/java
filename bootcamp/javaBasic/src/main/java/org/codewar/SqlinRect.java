package org.codewar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SqlinRect {

    public static List<Integer> sqInRect(int lgn, int wdth) {
        if(lgn == wdth)
            return null;
        else if(lgn > wdth)
            return sqInRect(wdth, lgn);

        List<Integer> answer = new ArrayList<>();
        answer.add(wdth);
        answer.addAll(Objects.requireNonNull(sqInRect(wdth, lgn - wdth)));
        return answer;
    }
}
