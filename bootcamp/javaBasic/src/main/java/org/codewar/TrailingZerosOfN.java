package org.codewar;

public class TrailingZerosOfN {
        public static int zeros(int n) {
            // your beatiful code here
            if(n < 0) {
                return -1;
            }

            int count = 0;
            for(int i = 5; (n/i) > 0; i = i*5 ) {
                count = count + n/i;
            }
            return count;
        }
    public static int zerosDZheng(int n) {
        int num = (int)( Math.log(n)/Math.log(5));
        int zeros = 0;
        for (int i = 1; i<=num; i++){
            zeros += n/Math.pow(5, i );
        }
        return zeros;
    }
}
