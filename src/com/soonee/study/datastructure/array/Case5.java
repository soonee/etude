package com.soonee.study.datastructure.array;

import javax.jws.Oneway;

/**
 * 하나 빼기
 * 문자열을 편집하는 방법에는 세 가지 종류가 있다.
 * 문자 삽입, 문자 삭제, 문자 교체, 문자열 두 개가 주어졌을 때
 * 문자열을 같게 만들기 위한 편집 횟수가 1회 이내인지 확인하는 함수를 작성하라.
 *
 * input : pale, ple
 * output : true
 *
 * input : pales, pale
 * output : true
 *
 * input : pale, bake
 * output : false
 */
public class Case5 {

	/**
	 * 교체: 두 문자열이 단 하나의 문자만 다를때
	 * 삽입: 문자열에서 특정한 위치를 빈 공간으로 남겨두면 그 부분을 제외한 나머지 부분이 동일할때
	 * 삭제: 문자 한개를 삭제하면 같다? 근본적으로 삽입과 같은 원리?
	 */
	private static boolean replace(String s1, String s2) {
		boolean foundDifference = false;
		for(int i = 0; i < s1.length(); i++) {
			if(s1.charAt(i) != s2.charAt(i)) {
				if(foundDifference) return false;
				foundDifference = true;
			}
		}
		return true;
	}
	// s1에 문자 하나를 삽입해서 s2를 만들수 있는지 확인
	private static boolean insert(String s1, String s2) {
		int index1 = 0;
		int index2 = 0;
		while(index2 < s2.length() && index1 < s1.length()) {
			if(s1.charAt(index1) != s2.charAt(index2)) {
				if(index1 != index2) return false;
				index2++;
			} else {
				index1++;
				index2++;
			}
		}
		return true;
	}
	boolean oneEditAway1(String first, String second) {
		if(first.length() == second.length()) {
			return replace(first, second);
		}
		else if(first.length() + 1 == second.length()) {
			return insert(first, second);
		}
		else if(first.length() - 1 == second.length()) {
			return insert(second, first);
		}
		return false;
	}

	boolean oneEditAway2(String first, String second) {
		// 길이 체크
		if(Math.abs(first.length() - second.length()) > 1) {
			return false;
		}
		// 길이가 짧은 문자열이 s1, 긴 문자열이 s2
		String s1 = first.length() < second.length() ? first : second;
		String s2 = first.length() < second.length() ? second : first;
		int index1 = 0;
		int index2 = 0;
		boolean foundDifference = false;
		while(index1 < s1.length() && index2 < s2.length()) {
			char c1 = s1.charAt(index1);
			char c2 = s2.charAt(index2);
			if(c1 != c2) {
				// 반드시 첫 번째로 다른 문자여야 한다
				if(foundDifference) return false;
				foundDifference = true;
				// 교체의 경우 짧은 문자열의 인덱스 증가
				if(s1.length() == s2.length()) index1++;
			} else {
				index1++;
			}
			index2++;
		}
		return true;
	}

	public static void main(String[] args) {
		Case5 c5 = new Case5();
//		boolean result2 = c5.oneEditAway1("pale", "pake");
//		System.out.println(result2);
		boolean result3 = c5.oneEditAway2("pale", "pakle");
		System.out.println(result3);
	}

}
