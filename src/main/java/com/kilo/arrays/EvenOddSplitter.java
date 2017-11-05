package com.kilo.arrays;

class EvenOddSplitter {

    int split(int[] input) {
        int nextEven = 0; int nextOdd = input.length -1;
        while(nextEven < nextOdd) {
            if(input[nextEven] %2 == 0) {
                nextEven++;
            } else {
                int temp = input[nextEven];
                input[nextEven] = input[nextOdd];
                input[nextOdd--] = temp;
            }
        }
        return nextOdd;
    }
}
