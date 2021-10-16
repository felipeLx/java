package org.codewar.Integer;

import org.codewar.Tortoise;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertArrayEquals;

public class TortoiseTest {

    @Autowired
    Tortoise tortoise;
    @Test
    public void test1() {
        System.out.println("Basic Tests");
        assertArrayEquals(new int[]{0, 32, 18}, Tortoise.race(720, 850, 70));
        assertArrayEquals(new int[]{3, 21, 49}, Tortoise.race(80, 91, 37));
        assertArrayEquals(new int[]{2, 0, 0}, Tortoise.race(80, 100, 40));
    }
}
