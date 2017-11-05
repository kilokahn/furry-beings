package com.kilo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.assertEquals;

class BitCounterTest {

    @ParameterizedTest
    @CsvSource({"0, 0","1, 1", "2, 1", "3, 2"})
    void test(long x, int o) {
        BitCounter bitCounter = new BitCounter();
        int actual = bitCounter.countBits(x);
        assertEquals(o, actual);
    }
}
