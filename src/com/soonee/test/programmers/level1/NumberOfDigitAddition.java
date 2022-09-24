package com.soonee.test.programmers.level1;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 자릿수 더하기
 */
public class NumberOfDigitAddition {
    public static int solution(int n) {
        char[] digits = Integer.toString(n).toCharArray();
        Stream<Character> digitStream = IntStream.range(0, digits.length).mapToObj(index -> digits[index]);
        return digitStream.map(d -> d - '0').mapToInt(Integer::intValue).sum();
    }
    public static int print(int n) {
        char[] digits = Integer.toString(n).toCharArray();
        Stream<Character> digitStream = IntStream.range(0, digits.length).mapToObj(index -> digits[index]);
        int sum = digitStream.map(d -> d - '0').mapToInt(Integer::intValue).sum();
        System.out.printf("given number : %d, digits : %s, sum : %d\n", n, Arrays.toString(digits), sum);
        return sum;
    }

    public static void main(String[] args) {
        solution(765);
        solution(5);
        print(765);
        print(5);
    }
}
