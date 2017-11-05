package com.kilo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class IslandIdentifierTest {

    @Test
    void testSimple() {
        boolean[][] input = new boolean[][]{
                {true, false, false, false},
                {true, false, true, false},
                {true, false, false, false},
                {false, false, true, true}};
        IslandIdentifier identifier = new IslandIdentifier();
        int[][] taggedIslands = identifier.identifyIsland(input);
        int[][] expected =  new int[][]{{1, 0, 0, 0}, {1, 0, 2, 0}, {1, 0, 0, 0}, {0, 0, 3, 3}};
        assertArrayEquals(expected, taggedIslands);
    }

    @Test
    void testComplex() {
        boolean[][] input = new boolean[][]{
                {true, false, true, false},
                {true, true, true, false},
                {false, true, false, false},
                {false, true, false, true}};
        IslandIdentifier identifier = new IslandIdentifier();
        int[][] taggedIslands = identifier.identifyIsland(input);
        int[][] expected =  new int[][]{{1, 0, 1, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {0, 1, 0, 2}};
        assertArrayEquals(expected, taggedIslands);
    }

}
