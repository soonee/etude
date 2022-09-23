package com.soonee.test.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 약수의 합
 */
public class DivisorNumbersSum {
    public static int solution(int n) {
        double sqrt = Math.sqrt(n);
        int answer = 0;
        for(int i = 1; i <= sqrt; i++) {
            if(i * i == n) {
                answer += i;
                continue;
            }
            if(n % i == 0) {
                answer += i;
                answer += n / i;
            }
        }
        return answer;
    }

    public static int test(int n) {
        double sqrt = Math.sqrt(n);
        int answer = 0;

        List<Integer> sequences = new ArrayList<>();

        for(int i = 1; i <= sqrt; i++) {
            if(i * i == n) {
                answer += i;
                sequences.add(i);
                continue;
            }
            if(n % i == 0) {
                answer += i;
                answer += n / i;
                sequences.add(i);
                sequences.add(n / i);
            }
        }
        System.out.printf("given number : %d, square root : %f, number : %s, sum : %d, sequences : %s\n",
            n, sqrt, sqrt % 1 == 0 ? "정수" : "실수", answer, Arrays.toString(sequences.toArray()));
        return answer;
    }

    public static void main(String[] args) {
        test(12);
        test(5);
        test(25);
        test(55);
        System.out.println("====================");
        System.out.println(solution(12));
        System.out.println(solution(55));
        System.out.println(solution(25));
        System.out.println(solution(5));
    }
}
