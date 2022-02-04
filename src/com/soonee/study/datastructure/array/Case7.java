package com.soonee.study.datastructure.array;

import java.util.Arrays;

/**
 * 행렬회전
 * 이미지를 표현하는 N X N 행렬이 있다.
 * 이미지의 각 픽셀은 4바이트로 표현된다.
 * 이때, 이미지를 90도 회전시키는 메서들 작성하라.
 * 행렬을 추가로 사용하지 않고서도 할 수 있겠는가?
 */
public class Case7 {
	private static boolean rotate(int[][] matrix) {
		if(matrix.length == 0 || matrix.length != matrix[0].length)
			return false;
		int n = matrix.length;
		for(int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - 1 -layer;
			for(int i = first; i < last; i++) {
				int offset = i - first;
				int top = matrix[first][i];
				// 왼쪽 -> 위쪽
				matrix[first][i] = matrix[last - offset][first];
				// 아래쪽 -> 왼쪽
				matrix[last - offset][first] = matrix[last][last - offset];
				// 오른쪽 -> 아래쪽
				matrix[last][last - offset] = matrix[i][last];
				// 위쪽 -> 오른쪽
				matrix[i][last] = top;
			}
		}
		return true;
	}
	private static void printMatrix(int[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}

	public static void main(String[] args) {
		int matrixSize = 9;
		int[][] matrix = new int[matrixSize][matrixSize];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = i + 1;
			}
		}
		printMatrix(matrix);
		System.out.println();
		rotate(matrix);
		printMatrix(matrix);
	}
}
