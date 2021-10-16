package org.codewar.Integer;

import org.codewar.AreSame;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class AreSameTest {

    @Autowired
    AreSame areSame;

    @Test
    public void test1() {
        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};
        assertEquals(true, AreSame.comp(a, b));
    }


    @Test
    public void test2() {
        int[] a = new int[]{144, 19, 161, 19, 144, 19, 11};
        int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};
        assertEquals(false, AreSame.comp(a, b));
    }

    @Test
    public void test3() {
        int[] a =null;
        int[] b = null;
        assertEquals(false, AreSame.comp(a, b));
    }
}
