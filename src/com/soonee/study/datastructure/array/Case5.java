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
	boolean oneEditAway(String first, String second) {
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

	public static void main(String[] args) {
		Case5 c5 = new Case5();
		boolean result1 = c5.oneEditAway("pale", "ale");
		boolean result2 = c5.oneEditAway("pale", "bake");
		System.out.println(result1);
		System.out.println(result2);
	}

}
