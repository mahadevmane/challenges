package org.open.challenges.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoodRanges {
    private static long result, prev = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);

        result = 1 + n;
        for (int i = 0; i < m; i++) {
            long x = Long.parseLong(br.readLine().trim());
            goodRangeSum(x);
            System.out.println(result);
        }

        br.close();
    }

    private static void goodRangeSum(long x) {
        if (prev != 0) {
            result += (prev + x);
        }
        prev = x;
    }
}