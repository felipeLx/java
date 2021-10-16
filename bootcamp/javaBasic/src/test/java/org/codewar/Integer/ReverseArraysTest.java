package org.codewar.Integer;


import org.codewar.ReverseArrays;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertArrayEquals;

public class ReverseArraysTest {

    @Autowired
    public ReverseArrays reverseArrays;

    @Test
    public void testReverseWithEvenLengthOfArray(){ int[] numbers = {1, 2, 3, 4, 5, 6}; ReverseArrays.reverse(numbers); assertArrayEquals(new int[]{6, 5, 4, 3, 2, 1}, numbers); }

    @Test public void testReverseWithOddLengthOfArray(){ int[] numbers = {1, 2, 3, 4, 5, 6, 7}; ReverseArrays.reverse(numbers); assertArrayEquals(new int[]{7, 6, 5, 4, 3, 2, 1}, numbers); }

    @Test public void testReverseWithEmptyArray(){ int[] numbers = {}; ReverseArrays.reverse(numbers); assertArrayEquals(new int[]{}, numbers); }

    @Test public void testReverseWithNullArray(){ int[] numbers = null; ReverseArrays.reverse(numbers); assertArrayEquals(null, numbers); }

    @Test public void testReverseWithJustOneElementArray(){ int[] numbers = {1}; ReverseArrays.reverse(numbers); assertArrayEquals(new int[]{1}, numbers); }



}
