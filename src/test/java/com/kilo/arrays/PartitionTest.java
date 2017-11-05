package com.kilo.arrays;

import static com.kilo.arrays.Color.BLUE;
import static com.kilo.arrays.Color.GREEN;
import static com.kilo.arrays.Color.RED;
import static com.kilo.arrays.Color.WHITE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class PartitionTest {

    @Test
    void testSimple() {
        List<Color> colors = Arrays.asList(RED, RED, RED, WHITE, RED, BLUE, BLUE, RED, BLUE, WHITE, GREEN);
        int pivotIndex = 3;
        Partition p = new Partition();
        p.partition(pivotIndex, colors);
        List<Color> expected = Arrays.asList(RED, RED, RED, RED, RED, WHITE, WHITE, BLUE, BLUE, BLUE, GREEN);
        assertEquals(expected, colors);
    }

    @Test
    void testComplex() {
        List<Color> colors = Arrays.asList(RED, WHITE, RED, WHITE, RED, WHITE, BLUE, WHITE, BLUE, WHITE, RED, GREEN);
        int pivotIndex = 3;
        Partition p = new Partition();
        p.partition(pivotIndex, colors);
        List<Color> expected = Arrays.asList(RED, RED, RED, RED, WHITE, WHITE, WHITE, WHITE, WHITE, BLUE, BLUE, GREEN);
        assertEquals(expected, colors);
    }
}
