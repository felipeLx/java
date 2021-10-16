package org.codewar.Integer;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.codewar.SqlinRect;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SqlinRectTest {

    @Autowired
    private SqlinRect sqlinRect;

    @Test
    public void test1() {
        List<Integer> res = new ArrayList<Integer>(Arrays.asList(3, 2, 1, 1));
        for (int r : res)
            assertEquals(res, SqlinRect.sqInRect(5, 3));
    }
    @Test
    public void test2() {
        assertEquals(null, SqlinRect.sqInRect(5, 5));
    }
}