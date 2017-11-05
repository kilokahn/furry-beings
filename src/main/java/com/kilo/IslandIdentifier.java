package com.kilo;

class IslandIdentifier {

    private static final int[] ROW_OFFSET = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] COL_OFFSET = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
    private static final int UNVISITED_MARKER = -1;
    private static final int VISITED_WATER_MARKER = 0;

    int[][] identifyIsland(boolean[][] input) {
        int rowsLength = input.length;
        int count = 0;
        int[][] result = getInitialResult(input, rowsLength);
        for (int i = 0; i < rowsLength; i++) {
            int colLength = input[i].length;
            for (int j = 0; j < colLength; j++) {
                if(!isVisited(i, j, result) && island(i, j, input)) {
                    traverse(input, i, j, rowsLength, colLength, result, ++count);
                }
            }
        }
        return result;
    }

    private boolean island(int row, int col, boolean[][] input) {
        return input[row][col];
    }

    private boolean isReachable(int rowIndex, int colIndex, int rowsLength, int colsLength) {
        return rowIndex >= 0 && rowIndex < rowsLength && colIndex >= 0 && colIndex < colsLength;
    }

    private boolean isVisited(int row, int col, int[][] result) {
        return result[row][col] != UNVISITED_MARKER;
    }

    private void traverse(boolean[][] input, int row, int col, int rowsLength, int colLength, int[][] result, int identifier) {
        if(island(row,col,input)) {
            result[row][col] = identifier;
        } else {
            result[row][col] = VISITED_WATER_MARKER;
            // Return since we hit a dead-end
            return;
        }
        // For the other 8 neighbors recurse
        for (int i = 0; i < 8; i++) {
            int rowIndex = row + ROW_OFFSET[i];
            int colIndex = col + COL_OFFSET[i];
            if (isReachable(rowIndex, colIndex, rowsLength, colLength) &&
                    !isVisited(rowIndex, colIndex, result)) {
                traverse(input, rowIndex, colIndex, rowsLength, colLength, result, identifier);
            }
        }
    }

    private int[][] getInitialResult(boolean[][] input, int rowsLength) {
        int[][] result = new int[rowsLength][];
        for (int i = 0; i < rowsLength; i++) {
            result[i] = new int[input[i].length];
            for(int j = 0; j < input[i].length; j++) {
                result[i][j] = UNVISITED_MARKER;
            }
        }
        return result;
    }

}
