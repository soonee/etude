package com.soonee.test.programmers.level1;

/**
 * 정수 제곱근 판별
 *
 * long의 데이터 범위는? 8byte, 부호가 없음
 * double의 데이터 범위는? 8byte, 4byte씩 부호가 있음
 *
 * double to int / int to double
 * 캐스팅 연산시 데이터 유실을 최소한으로 하는 방법은?
 *
 * 정수와 실수 판별 알고리즘?
 * 1로 나눈 나머지 값이 0과 같은지 체크만 하면?
 */
public class IntegerSquareRootDistinguish {
    public static long solution(long n) {
        double answer = -1;
        double sqrt = Math.sqrt(n);
        if(sqrt % 1 == 0) answer = Math.pow(sqrt + 1, 2);
        return (long) answer;
    }
    public static void print(long n) {
        double answer = -1;
        double sqrt = Math.sqrt(n);
        if(sqrt % 1 == 0) answer = Math.pow(sqrt + 1, 2);
        System.out.printf("given number : %,d, square : %f, power : %,f%n",
                n, sqrt, answer);
    }

    public static void main(String[] args) {
        print(49999999999999L);
        print(4999999);
        print(3);
        print(121);
    }
}
