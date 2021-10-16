package org.codewar;

import java.util.ArrayList;
import java.util.List;

public class Decompose {
    public String decompose(long n) {
        List<Long> decomposeArray = Decomposer(n, n*n);

        if(decomposeArray == null) {
            return null;
        }

        decomposeArray.remove(decomposeArray.size() -1);
        List<String> result = new ArrayList<>();

        for(Long find : decomposeArray) {
            result.add(String.valueOf(find.longValue()));
        }

        return String.join(" ", result);
    }

    public List<Long> Decomposer(long n, long remain) {
        if(remain == 0) {
            List<Long> newList = new ArrayList<>();
            newList.add(n);
            return newList;
        }

        for (long i = n-1; i > 0; i--) {
            if(remain - (1 * i) >= 0) {
                List<Long> newList = Decomposer(i, (remain - (i * i)));

                if(newList != null) {
                    newList.add(n);
                    return newList;
                }
            }
        }

        return null;
    }

}
