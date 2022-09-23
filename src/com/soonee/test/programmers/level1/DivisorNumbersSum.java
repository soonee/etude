package com.soonee.test.programmers.level1;

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

    public static void main(String[] args) {
        System.out.println(solution(12));
        System.out.println(solution(55));
        System.out.println(solution(25));
        System.out.println(solution(5));
    }
}
