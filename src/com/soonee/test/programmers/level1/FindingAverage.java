package com.soonee.test.programmers.level1;

import java.util.Arrays;

/**
 * 평균 구하기
 */
public class FindingAverage {
    public static double solution(int[] arr) {
        System.out.printf("sum : %d, count : %d\n", Arrays.stream(arr).sum(), arr.length);
        return Arrays.stream(arr).average().getAsDouble();
    }

    public static void main(String[] args) {
        System.out.println( solution(new int[]{1,2,3,4,5,6,7}) );
        System.out.println( solution(new int[]{2,3,1,6,87,5,9}) );
    }
}
