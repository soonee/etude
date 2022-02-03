package com.soonee.study.datastructure.array;

import java.util.Arrays;

/**
 * URLify 문제
 * 문자열에 들어있는 모든 공백을 '%20'으로 바꾸는 메서드를 작성하라.
 * 최종적으로 모든 문자를 다 담을 수 있을 만큼
 * 충분한 공간이 이미 확보되어 있으며
 * 문자열의 최종 길이가 함께 주어진다고 가정해도 된다
 * (자바로 구현한다면 배열 안에서 작업할 수 있도록 문자 배열(character array)을 이용하라)
 */
public class Case3 {

	private static char[] repaceSpace(char[] source, int trueLength) {
		int spaceCount = 0;
		int index = 0;
		for(int i  = 0; i < trueLength; i++) {
			if(source[i] == ' ') {
				spaceCount++;
			}
		}
		index = trueLength + spaceCount * 2;
		char[] target = new char[index];
		if(trueLength < source.length) target[trueLength] = '\0';
		for(int i = trueLength - 1; i >= 0; i--) {
			if(source[i] == ' ') {
				target[index - 1] = '0';
				target[index - 2] = '2';
				target[index - 3] = '%';
				index -= 3;
			} else {
				target[index - 1] = source[i];
				index--;
			}
		}
		return target;
	}

	public static void main(String[] args) {
		String trueString = "Mr John Smith";
		char[] str = trueString.toCharArray();
		System.out.println(str);
		char[] result = repaceSpace(str, trueString.length());
		System.out.println(result);
	}

}
