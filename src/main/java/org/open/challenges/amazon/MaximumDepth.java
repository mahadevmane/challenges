package org.open.challenges.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumDepth {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Press enter to exit...");
        System.out.println("ASCII value is " + br.read());
        br.close();
    }
}