package com.kilo.primitives;

import com.kilo.primitives.ParityCalculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParityCalculatorTest {

    @ParameterizedTest
    @CsvSource({"11, 1", "8, 1", "2, 1", "0, 0", "9, 0"})
    void test(long input, short output) {
        ParityCalculator pc = new ParityCalculator();
        short parity = pc.parity(input);
        assertEquals(output, parity);
    }

}
