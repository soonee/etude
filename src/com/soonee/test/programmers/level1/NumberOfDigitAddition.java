package com.soonee.test.programmers.level1;

import java.util.Arrays;

/**
 * 자릿수 더하기
 */
public class NumberOfDigitAddition {
    public static int solution(int n) {
        Integer.toString(n);
        char[] digits = Integer.toString(n).toCharArray();
//        Arrays.asList(digits).stream().mapToInt().sum();
        int number = 5;
        String numberOriginString = Integer.toString(number);
        number = 10;
        String numberModifyString = Integer.toString(number);
        if(numberOriginString == numberModifyString) {
            System.out.println("메모리 할당이 같음");
        } else {
            System.out.println("메모리 할당이 다름");
        }
        System.out.printf("digits : %s\n", Arrays.toString(digits));
        return 0;
    }

    public static void main(String[] args) {
        solution(987);
    }
}
