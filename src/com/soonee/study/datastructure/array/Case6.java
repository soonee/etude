package com.soonee.study.datastructure.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 문자열 압축
 * 반복되는 문자의 개수를 세는 방식의 기본적인 문자열 압축 메서드를 작성하라.
 * 예를 들어 문자열 aabccccaaa를 압축하면 a2b1c4a3이 된다.
 * 만약 '압축된' 문자열의 길이가 기존 문자열의 길이보다 길다면 기존 문자열을 반환해야 한다.
 * 문자열은 대소문자 알파벳(a-z)으로만 이루어져 있다.
 */
public class Case6 {

	private static int countCompression(String str) {
		int compressedLength = 0;
		int consecutive = 0;
		for(int i = 0; i < str.length(); i++) {
			consecutive++;
			if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressedLength += String.valueOf(str.charAt(i)).length() + String.valueOf(consecutive).length();
				consecutive = 0;
			}
		}
//		return 0;
		return compressedLength;
	}
	private static String compressWorstPractice(String str) {
		String compressedString = "";
		int countConsecutive = 0;
		for(int i = 0; i < str.length(); i++) {
			countConsecutive++;
			// 다음 문자와 현재 문자가 같지 않다면
			if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressedString += "" + str.charAt(i) + countConsecutive;
				countConsecutive = 0;
			}
		}
		System.out.println(str.length() + " " + compressedString.length());
		return compressedString.length() < str.length() ? compressedString : str;
	}
	private static String compressBestPractice(String str) {
		// 압축 전/후의 문자열 길이를 먼저 계산한다
		// stringbuilder의 효율적으로 사용한다
		int compressedLength = countCompression(str);
		System.out.println(str.length() + " " + compressedLength);
		if(compressedLength >= str.length()) {
			return str;
		}

		StringBuilder compressed = new StringBuilder(compressedLength);
		int consecutive = 0;
		for(int i = 0; i < str.length(); i++) {
			consecutive++;
			if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressed.append(str.charAt(i));
				compressed.append(consecutive);
				consecutive = 0;
			}
		}
		return compressed.toString();
	}

	public static void main(String[] args) {
		String worst = compressWorstPractice("aaabbbcccccddaaa");
		System.out.println(worst);

		String best = compressBestPractice("abbweaserrqsroweiroasweiruj");
		System.out.println(best);
	}

}
