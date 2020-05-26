package com;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;


public class TEST {

    // Returns count of possible paths to reach
    // cell at row number m and column number n
    // from the topmost leftmost cell (cell at 1, 1)
    static int numberOfPaths(int m, int n)
    {
        // If either given row number is first or given column number is first
        if (m == 1 || n == 1)
            return 1;

        // If diagonal movements are allowed then the last addition is required.
        return numberOfPaths(m - 1, n) + numberOfPaths(m, n - 1);
        // + numberOfPaths(m-1, n-1);
    }

    public static void main(String args[])
    {
        Map<Character, Integer> map = new LinkedHashMap<>();
    }
}