package com.soonee.study.datastructure.array;

import com.sun.org.apache.xml.internal.utils.MutableAttrListImpl;

import java.util.Arrays;

/**
 * 행렬회전
 * 이미지를 표현하는 N X N 행렬이 있다.
 * 이미지의 각 픽셀은 4바이트로 표현된다.
 * 이때, 이미지를 90도 회전시키는 메서들 작성하라.
 * 행렬을 추가로 사용하지 않고서도 할 수 있겠는가?
 */
public class Case7 {
	private static boolean rotate(char[][] matrix) {
		if(matrix.length == 0 || matrix.length != matrix[0].length)
			return false;
		int matrixLength = matrix.length;
		int firstFinish = matrixLength / 2;
		for(int firstStart = 0; firstStart < firstFinish; firstStart++) {
			System.out.println("=================================");
			int secondFinish = matrixLength - 1 - firstStart;
			for(int secondStart = firstStart; secondStart < secondFinish; secondStart++) {
				System.out.println("------------------------------------------------------------------");
				int offset = secondStart - firstStart;
				char temp = matrix[firstStart][secondStart];
				// 왼쪽아래 -> 왼쪽 위
				System.out.printf("(%d, %d): %c -> (%d, %d) : %c\n",
						firstStart, secondStart, matrix[firstStart][secondStart],
						secondFinish - offset, firstStart, matrix[secondFinish - offset][firstStart]
				);
				matrix[firstStart][secondStart] = matrix[secondFinish - offset][firstStart];
				// 오른쪽 아래 -> 왼쪽 아래
				System.out.printf("(%d, %d): %c -> (%d, %d) : %c\n",
						secondFinish - offset, firstStart, matrix[secondFinish - offset][firstStart],
						secondFinish, secondFinish - offset, matrix[secondFinish][secondFinish - offset]
				);
				matrix[secondFinish - offset][firstStart] = matrix[secondFinish][secondFinish - offset];
				// 오른쪽 위 -> 오른쪽 아래
				System.out.printf("(%d, %d): %c -> (%d, %d) : %c\n",
						secondFinish, secondFinish - offset, matrix[secondFinish][secondFinish - offset],
						secondStart, secondFinish, matrix[secondStart][secondFinish]
				);
				matrix[secondFinish][secondFinish - offset] = matrix[secondStart][secondFinish];
				// 왼쪽 위 ->
				System.out.printf("(%d, %d): %c -> (%d, %d) : %c\n",
						secondStart, secondFinish, matrix[secondStart][secondFinish],
						firstStart, secondStart, temp
				);
				matrix[secondStart][secondFinish] = temp;
			}
		}
		return true;
	}
	private static void printMatrix(char[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}
	private static void invoke(char[][] matrix) {
		printMatrix(matrix);
		System.out.println();
		rotate(matrix);
		System.out.println();
		printMatrix(matrix);
	}
	private static void test(char[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}

	public static void main(String[] args) {
		int matrixSize = 6;
		char[][] matrix = new char[matrixSize][matrixSize];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = (char) ('a' + j);
			}
		}
		invoke(matrix);
	}
}
