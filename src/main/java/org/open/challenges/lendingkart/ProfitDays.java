package org.open.challenges.lendingkart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given:
 * N - Number of days
 * N space separated profits
 * Q - Number of queries
 * For each query L and R
 * <p>
 * Find profits for each query such that profit >= L and profit <= R
 */
public class ProfitDays {
    public static void main(String[] args) throws IOException {
        List<Query> queries = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter no. of days: ");
        int n = Integer.parseInt(br.readLine());

        int[] profits = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter profit of day " + (i + 1) + ": ");
            profits[i] = Integer.parseInt(br.readLine());
        }

        System.out.print("Enter no. of queries: ");
        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            System.out.print("Enter lower limit of query " + (i + 1) + ": ");
            int l = Integer.parseInt(br.readLine());
            System.out.print("Enter upper limit of query " + (i + 1) + ": ");
            int r = Integer.parseInt(br.readLine());

            queries.add(new Query(l, r));
        }

        Arrays.sort(profits);
        System.out.println("Number of profits for each query: ");
        queries.forEach(query -> System.out.println(findNumberOfProfits(profits, query)));
    }

    private static int findNumberOfProfits(int[] sortedProfits, Query query) {
        int left = findFirstOccurrence(sortedProfits, query.lowerLimit);
        int right = findLastOccurrence(sortedProfits, query.upperLimit);
        return right - left + 1;
    }

    private static int findFirstOccurrence(int[] sortedArr, int num) {
        int mid = 0, left = 0, right = sortedArr.length - 1;

        while (left <= right) {
            mid = (left + right) / 2;

            if (num <= sortedArr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (mid < sortedArr.length - 1 && num > sortedArr[mid])
            return mid + 1;

        return mid;
    }

    private static int findLastOccurrence(int[] sortedArr, int num) {
        int mid = 0, left = 0, right = sortedArr.length - 1;

        while (left <= right) {
            mid = (left + right) / 2;

            if (num >= sortedArr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (mid > 0 && num < sortedArr[mid])
            return mid - 1;

        return mid;
    }

    static class Query {
        private final int lowerLimit;
        private final int upperLimit;

        Query(int lowerLimit, int upperLimit) {
            this.lowerLimit = lowerLimit;
            this.upperLimit = upperLimit;
        }
    }
}