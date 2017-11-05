package com.kilo.primitives;

import com.kilo.primitives.PowerCalculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PowerCalculatorTest {

    @ParameterizedTest
    @CsvSource({"0, 20, 0", "1, 0, 1", "1, 1, 1", "2, 2, 4", "3, -1, 0.333", "-3, -1, -0.333"})
    void test(double x, int y, double result) {
        PowerCalculator pc = new PowerCalculator();
        double actual = pc.power(x, y);
        assertEquals(result, actual, 0.01);
    }

}
