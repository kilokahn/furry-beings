package com.kilo.arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EvenOddSplitterTest {

    // @ParameterizedTest
    // @MethodSource("inputs")
    void test(int[] input, int expected) {
        testDirect(input, expected);
    }

    static Stream<Arguments> inputs() {
        return Stream.of(Arguments.of(new int[]{2, 3, 4, 5}, 1));
    }

    @Test
    void testSimple() {
        int[] input = new int[]{2, 3, 4, 5};
        int result = 1;
        testDirect(input, result);
    }

    private void testDirect(int[] input, int expected) {
        EvenOddSplitter splitter = new EvenOddSplitter();
        int splitIndex = splitter.split(input);
        assertEquals(expected, splitIndex);
    }
}
