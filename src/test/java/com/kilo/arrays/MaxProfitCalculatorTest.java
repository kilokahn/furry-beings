package com.kilo.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class MaxProfitCalculatorTest {

    @Test
    void test() {
        MaxProfitCalculator calc = new MaxProfitCalculator();
        List<Integer> prices = Arrays.asList(310,315,275,295,260,270,290,230,255,250);
        Integer profit = calc.calculateProfit(prices);
        assertEquals(30, profit.intValue());
    }

    @Test
    void test2() {
        MaxProfitCalculator calc = new MaxProfitCalculator();
        List<Integer> prices = Arrays.asList(310,315,275,295,260,270);
        Integer profit = calc.calculateProfit(prices);
        assertEquals(20, profit.intValue());
    }
}
