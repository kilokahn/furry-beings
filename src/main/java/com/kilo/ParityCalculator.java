package com.kilo;

class ParityCalculator {

    short parity(long x) {
        BitCounter bc = new BitCounter();
        int bits = bc.countBits(x);
        return (short) (bits %2);
    }
}
