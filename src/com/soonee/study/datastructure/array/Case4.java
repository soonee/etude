package com.soonee.study.datastructure.array;

import java.util.Arrays;

/**
 * 회문 순열 확인
 * 주어진 문자열이 회문의 순열인지 아닌지 확인하는 함수를 작성하라.
 * 회문이란 앞으로 읽으나 뒤로 읽으나 같은 단어 혹은 구절을 의미하며, 수녕ㄹ이란 문자열을 재배치하는 것을 뜻한다.
 * 회문이 꼭 사전에 등장하는 단어로 제한될 필요는 없다.
 *
 * 알고리즘
 * 문자열의 길이가 짝수일때
 * 중복없이 각 문자들이(한 글자씩) 짝수여야함
 *
 * 문자열의 길이가 홀수일때
 * 중복없이 각 문자들이(한 글자씩) 홀수여야함
 *
 * input : tact coa
 * output : true (순열: "taco cat", "atco cta" 등등)
 */
public class Case4 {

	// 알파벳(a-z)을 대소문자 구문 없이 숫자로 대응한다
	// 문자가 아닌 경우에는 -1로 대응한다
	int getCharName(Character c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		if(a <= val && val <= z) return val - a;
		return -1;
	}

	// hash table 개념을 이용해서 홀수인지 아닌지 체크?
	// 계수 정렬과 다른 점은?
	boolean isPermutationOfPalindrome(String phrase) {
		int countOdd = 0;
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

		for(char c : phrase.toCharArray()) {
			int x = getCharName(c);
			if(x != -1) {
				table[x]++;
				if(table[x] % 2 == 1) countOdd++;
				else countOdd--;
			}
		}

		for(int i = 0; i < table.length; i++) {
			System.out.printf("table[ %c ] : %d\n", i + 'a', table[i]);
		}
		return countOdd <= 1;
	}

	public static void main(String[] args) {
		Case4 c4 = new Case4();
		System.out.println(
			c4.isPermutationOfPalindrome("tact coa")
		);
	}

}
