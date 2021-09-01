package org.open.challenges.bny;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class JavaLevel3 {
    public static void main(String[] args) {
        System.out.println("Can read to destination: " + canReach(1, 4, 5, 9));
        System.out.println("Total candles burnt: " + getTotalCandlesBurnt(10, 2, 5));

        System.out.println("Maximum cup cakes-");
        maximumCupcakes(Arrays.asList("6 2 2", "6 2 3"));
        System.out.println("Trailing zeros: " + zeros(5));
    }

    private static String canReach(int x1, int y1, int x2, int y2) {
        Stack<Point> points = new Stack<>();
        points.push(new Point(x1, y1));

        Point temp;
        while (!points.empty()) {
            temp = points.pop();
            if (temp.x == x2 && temp.y == y2) {
                return "Yes";
            }

            if (temp.x <= x2 && temp.y <= y2) {
                points.push(new Point(temp.x + temp.y, temp.y));
                points.push(new Point(temp.x, temp.x + temp.y));
            }
        }

        return "No";
    }

    private static int getTotalCandlesBurnt(int amount, int costOfCandle, int noOfResidueCandles) {
        int totalCandles = 0;
        int candles = amount / costOfCandle;
        totalCandles += candles;

        while (candles >= noOfResidueCandles) {
            totalCandles += (candles / noOfResidueCandles);
            candles = (candles / noOfResidueCandles) + (candles % noOfResidueCandles);
        }

        return totalCandles;
    }

    private static void maximumCupcakes(List<String> trips) {
        int n, c, m, res, temp;
        for (String str : trips) {
            String[] ss = str.split(" ");
            n = Integer.parseInt(ss[0]);
            c = Integer.parseInt(ss[1]);
            m = Integer.parseInt(ss[2]);

            res = (n / c);
            temp = (n / c) + (n % c);

            while (temp >= m) {
                res += (temp / m);
                temp = (temp / m) + (temp % m);
            }

            System.out.println(res);
        }
    }

    private static int zeros(int n) {
        BigInteger fact = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }

        int res = 0;
        while (fact.mod(BigInteger.valueOf(10)).equals(BigInteger.valueOf(0))) {
            res++;
            fact = fact.divide(BigInteger.valueOf(10));
        }

        return res;
    }

    private static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}