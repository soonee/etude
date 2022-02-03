package com.soonee.study.datastructure.array;


/**
 * 문자열 중복 체크
 * 문자열이 주어졌을 때, 이 문자열에 같은 문자가 중복되어 등장하는지 확인하는 알고리즘을 작성하라.
 * 자료구조를 추가로 사용자히 않고 풀 수 있는 앎고리즘 또한 고민하라.
 * 문자열은 ASCII코드라고 가정한다면....?
 */
public class Case1 {

	// 공간복잡도 O(n), 시간복잡도 O(n)
	private String isUniqueCharsByCharArray(String str) {
		if(str.length() > 128) return "아스키코드 범위가 아닌 문자입니다.";
		boolean[] char_set = new boolean[128];
		for(int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if(char_set[val]) {
				return String.format("중복된 문자(%c)가 존재합니다", val);
			}
			char_set[val] = true;
		}
		return "중복된 문자가 존재하지 않습니다.";
	}

	// 공간복잡도 O(1 / 8), 시간복잡도 O(n)
	private String isUniqueCharsByBitwiseOperation(String str) {
		if(str.length() > 128) return "아스키코드 범위가 아닌 문자입니다.";
		int checker = 0;
		for(int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			int bitwise = 1 << val;
//			System.out.println("-----------------------");
//			System.out.printf("%c: %d\n", str.charAt(i), val);
//			System.out.println("checker: " + intToString(checker, 32));
//			System.out.println("val: " + intToString(val, 32));
//			System.out.println("bitwise: " + intToString(bitwise, 32));
			if(( checker & (bitwise) ) > 0) {
				return String.format("중복된 문자(%c)가 존재합니다", str.charAt(i));
			}
			checker = checker | bitwise;
		}
		return "중복된 문자가 존재하지 않습니다.";
	}

	public static void main(String[] args) {
		Case1 ds = new Case1();
//		String str = "exercise4zerg";
//		String str = "abcdefghijklmnop";
		String str = "abcdefghhjklmnop";
		System.out.println(ds.isUniqueCharsByCharArray(str));
		System.out.println(ds.isUniqueCharsByBitwiseOperation(str));
	}

}
