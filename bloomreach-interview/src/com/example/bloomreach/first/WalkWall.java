package com.example.bloomreach.first;

// There is a n * n grid. Each cell is either occupied by a person (1) or there is a wall present (0).
// The location/address of each person is defined by the (row, column) it belongs to. People communicate
// with the other people around them in 4 possible directions (up, down, right, left) and form groups.
// A person cannot communicate through a wall. you can break one wall then return the size of the biggest group
// that can be formed by doing so.

//        [1, 0, 0, 1]
//        [0, 1, 0, 1]
//        [0, 1, 1, 0]
//        [1, 0, 0, 1]

// Ans is 5

public class WalkWall {
    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {1, 0, 0, 1},
                {0, 1, 0, 1},
                {0, 1, 1, 0},
                {1, 0, 0, 1},
        };
    }
}
