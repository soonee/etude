package com.soonee.test.programmers.level1;

import java.util.Arrays;

public class LottoRanking {

	public int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];
		System.out.println(Arrays.toString(lottos));
		System.out.println(Arrays.toString(win_nums));
		int correct = 0;
		int zero = 0;
		for(int i = 0; i < lottos.length; i++) {
			if(lottos[i] == 0) {
				zero++;
			} else {
				for(int j = 0; j < win_nums.length; j++) {
					if(lottos[i] == win_nums[j]) {
						correct++;
					}
				}
			}
		}
		// 최고 순위 (0을 뺀 나머지 숫자들 중 맞은 갯수 + 0인 갯수)
		answer[0] = Math.min(7 - (zero + correct), 6);
		// 최저 순위 (0을 뺀 나머지 숫자들 중 맞은 갯수)
		answer[1] = Math.min(7 - (correct), 6);
		System.out.println(Arrays.toString(answer));
		return answer;
	}

	public static void main(String[] args) {
		LottoRanking o = new LottoRanking();
		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] win_nums = {31, 10, 45, 1, 6, 19};
		o.solution(lottos, win_nums);
	}
}
