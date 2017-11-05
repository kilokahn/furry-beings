package com.kilo.arrays;

import java.util.List;

class MaxProfitCalculator {

    Integer calculateProfit(List<Integer> prices) {
        int minBuyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (Integer price : prices) {
            maxProfit = Math.max(maxProfit, price - minBuyPrice);
            minBuyPrice = Math.min(minBuyPrice, price);
        }
        return maxProfit;
    }
}
