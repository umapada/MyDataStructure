package com.stackqueue;

import java.util.*;
import java.util.function.BiFunction;


class ReversePolishNotation {

    private static final Map<String, BiFunction<Integer, Integer, Integer>> OPERATIONS = new HashMap<>();


    public static void main(String[] args) {

        Map<String, BiFunction<Integer, Integer, Integer>> map = new HashMap<>();

        map.put("+", (a, b) -> a + b);
        map.put("-", (a, b) -> a - b);
        map.put("/", (a, b) -> a / b);
        map.put("*", (a, b) -> a * b);

        BiFunction fun = map.get("+");

        BiFunction<Integer, Integer, List<Integer>> f = (a, b) -> Arrays.asList(a + b);

        List<Integer> list = f.apply(3, 4);

        System.out.println(list);
    }


    // Ensure this only gets done once for ALL test cases.
    static {
        OPERATIONS.put("+", (a, b) -> a + b);
        OPERATIONS.put("-", (a, b) -> a - b);
        OPERATIONS.put("*", (a, b) -> a * b);
        OPERATIONS.put("/", (a, b) -> a / b);
    }

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            if (!OPERATIONS.containsKey(token)) {
                stack.push(Integer.valueOf(token));
                continue;
            }

            int number2 = stack.pop();
            int number1 = stack.pop();
            BiFunction<Integer, Integer, Integer> operation;
            operation = OPERATIONS.get(token);
            int result = operation.apply(number1, number2);
            stack.push(result);
        }

        return stack.pop();

    }
}