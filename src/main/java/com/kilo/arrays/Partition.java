package com.kilo.arrays;

import java.util.Collections;
import java.util.List;

enum Color {
    RED((short)1), WHITE((short)2), BLUE((short)3), GREEN((short)4);

    final short rank;

    Color(short i) {
        this.rank = i;
    }
}
class Partition {

    void partition(int pivotIndex, List<Color> colors) {
        Color pivot = colors.get(pivotIndex);
        // first pass makes the elements lesser than pivot to the left
        int smallest = 0;
        for(int i =0; i < colors.size(); i++) {
            if(colors.get(i).rank < pivot.rank) {
                Collections.swap(colors, i, smallest);
                smallest++;
            }
        }

        // Second pass to make the elements greater than pivot to the right
        int largest = colors.size() -1;
        for(int i = colors.size() - 1; i >= 0; i--) {
            if(colors.get(i).rank > pivot.rank) {
                Collections.swap(colors, i, largest);
                largest--;
            }
        }
    }
}
