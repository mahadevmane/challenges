package org.open.challenges.lendingkart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Given:
 * T - Number of test cases
 * L and V space separated values provided for each test case
 * L - Length of string of small case chars
 * V - Sum of character of string; a = 1, b = 2, ..., z = 26
 * <p>
 * Find lexicographical smallest string of length L and value of V
 */
public class SmallestString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter length: ");
        int len = Integer.parseInt(br.readLine());
        System.out.print("Enter value: ");
        int val = Integer.parseInt(br.readLine());
        System.out.println(findSmallestString(len, val));
    }

    private static String findSmallestString(int len, int val) {
        int temp;
        Stack<Character> stack = new Stack<>();

        for (int i = len - 1; i >= 0; i--) {
            temp = val - i;

            if (temp >= 26) {
                val -= 26;
                stack.push('z');
            } else {
                val -= temp;
                stack.push((char) ('a' + temp - 1));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}