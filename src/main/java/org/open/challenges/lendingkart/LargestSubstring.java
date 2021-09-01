package org.open.challenges.lendingkart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Given:
 * T - Number of test cases
 * Small case character string for each test case
 * <p>
 * Find biggest length substring of distinct characters.
 */
public class LargestSubstring {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter string: ");
        String str = br.readLine();
        System.out.println(findLargestSubstring(str));
    }

    private static int findLargestSubstring(String str) {
        int result = 0, temp = 0;
        boolean[] arr = new boolean[26];

        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';

            if (arr[idx]) {
                if (temp > result) {
                    result = temp;
                }
                Arrays.fill(arr, false);
                temp = 1;
                arr[idx] = true;
            } else {
                arr[idx] = true;
                temp++;
            }
        }

        if (temp > result) {
            result = temp;
        }

        return result;
    }
}