package org.codewar.Integer;

import org.codewar.TrailingZerosOfN;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TrailingZerosOfNTest {

    @Autowired
    private TrailingZerosOfN trailingZerosOfN;


    @Test
    public void testZeros() throws Exception {
        assertThat(TrailingZerosOfN.zeros(0), is(0));
        assertThat(TrailingZerosOfN.zeros(6), is(1));
        assertThat(TrailingZerosOfN.zeros(14), is(2));
    }

    @Test
    public void testOtherZeros() throws Exception {
        assertThat(TrailingZerosOfN.zerosDZheng(0), is(0));
        assertThat(TrailingZerosOfN.zerosDZheng(6), is(1));
        assertThat(TrailingZerosOfN.zerosDZheng(14), is(2));
    }
}
