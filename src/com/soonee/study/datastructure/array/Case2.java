package com.soonee.study.datastructure.array;

import java.util.Arrays;

/**
 * 순열 관계 확인
 * 순열이란? n개 중에서 r개를 선택하여 중복없이 순서있게 나열하는 것)
 * 문자열 두 개가 주어졌을 때 이 둘이 서로 순열 관계에 있는지 확인하는 메서드를 작성하라.
 */
public class Case2 {

	// 새로운 String 객체 생성 (기존 문자열을 바꾸지 않는다는 의미??)
	private static String sort(String str) {
		char[] content = str.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	// 알파벳순으로 정렬한 후 단순 비교
	// 시간복잡도는??
	private static boolean permutation2(String source, String target) {
		if(source.length() != target.length()) return false;
		return sort(source).equals(sort(target));
	}

	// 기수정렬(radix sort)? 계수정렬(counting sort)?
	private static boolean permutation1(String source, String target) {
		// 순열관계에 있다면 동일한 문자 개수를 가지고 있어야한다.
		if(source.length() != target.length()) return false;
		// 문자인코딩 방식은 ascii 방식이라고 가정한다.
		int[] letters = new int[128];
		for(char c : source.toCharArray()) {
			letters[c]++;
		}
		for(int i = 0; i < target.length(); i++) {
			char c = target.charAt(i);
			letters[c]--;
			if(letters[c] < 0) {
				// 문자열 비교와 근본적으로 같다?
				return false;
			}
		}
		return true;
	}

	// test
	public static void main(String args[]) {
		System.out.println( permutation1("abc", "bcd") );
		System.out.println( permutation2("1234", "3214") );
	}

}
