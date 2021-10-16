package org.codewar;

/*
The >>> operator is the unsigned right bit-shift operator in Java.
It effectively divides the operand by 2 to the power of the right operand, or just 2 here.

The difference between >> and >>> would only show up when shifting negative numbers.
The >> operator shifts a 1 bit into the most significant bit if it was a 1, and the >>> shifts in a 0 regardless.
 https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op3.html
 */
public class LongToIP {
    public static String longToIP(long ip) {
        return String.format("%d.%d.%d.%d", ip>>>24, (ip>>16)&0xff, (ip>>8)&0xff, ip&0xff);
    }
}

/*
It sets result to the (unsigned) value resulting from putting the 8 bits of value in the lowest 8 bits of result.

The reason something like this is necessary is that byte is a signed type in Java. If you just wrote:

int result = value;
then result would end up with the value ff ff ff fe instead of 00 00 00 fe. A further subtlety is that the & is defined to operate only on int values1, so what happens is:

value is promoted to an int (ff ff ff fe).
0xff is an int literal (00 00 00 ff).
The & is applied to yield the desired value for result.
(The point is that conversion to int happens before the & operator is applied.)
 */
