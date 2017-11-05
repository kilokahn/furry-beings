package com.kilo;

class BitCounter {

    int countBits(int x) {
        int numBits = 0;
        while (x !=0) {
            numBits += (x & 1);
            x = x >>> 1;
        }
        return numBits;
    }
}
