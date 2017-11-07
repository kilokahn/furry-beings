package com.kilo.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DigitConverterTest {

    @ParameterizedTest
    @CsvSource({"'123', 123", "'-123', -123",  "'0',0"})
    void testStringToInt(String input, int expected) {
        DigitConverter dc = new DigitConverter();
        int actual = dc.convert(input);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"'123', 123", "'-123', -123",  "'0',0"})
    void testIntToString(String expected, int input) {
        DigitConverter dc = new DigitConverter();
        String actual = dc.convert(input);
        assertEquals(expected, actual);
    }
}
