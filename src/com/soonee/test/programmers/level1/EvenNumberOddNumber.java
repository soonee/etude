package com.soonee.test.programmers.level1;

/**
 * 짝수와 홀수
 */
public class EvenNumberOddNumber {
    public static String solution(int num) {
        String answer = "";
        if((num & 1) == 0) answer = "even";
        else answer = "odd";
        return answer;
    }
    public static void main(String[] args) {
        for(int i = 10; i < 20; i++) System.out.printf("%d: %s\n", i, solution(i));
    }
}
