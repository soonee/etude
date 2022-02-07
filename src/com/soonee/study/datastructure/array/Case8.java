package com.soonee.study.datastructure.array;

import com.soonee.utils.ArrayPrint;

import java.util.Arrays;

/**
 * 0 행렬 만들기
 * M x N 행렬의 한 원소가 0일 경우
 * 해당 원소가 속한 행과 열의 모든 원소를
 * 0으로 설정하는 알고맂믕르 작성하라.
 */
public class Case8 {
	private static void setZeros1(int[][] matrix) {
		// 행 배열로 체크
		boolean[] row = new boolean[matrix.length];
		// 열 배열로 체크
		boolean[] column = new boolean[matrix[0].length];
		// 값이 0인 행과 열으이 인덱스를 저장한다
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}
		for(int i = 0; i < row.length; i++) {
			if(row[i]) nullifyRow(matrix, i);
		}
		for(int j = 0; j < column.length; j++) {
			if(column[j]) nullifyColumn(matrix, j);
		}
	}
	private static void nullifyRow(int[][] matrix, int row) {
		for(int i = 0; i < matrix.length; i++) {
			matrix[row][i] = 0;
		}
	}
	private static void nullifyColumn(int[][] matrix, int column) {
		for(int j = 0; j < matrix.length; j++) {
			matrix[j][column] = 0;
		}
	}

	public static void main(String[] args) {
		int size = 4;
		int[][] matrix = {
			{1, 2, 4, 0},
			{5, 1, 2, 1},
			{0, 2, 0, 2},
			{1, 2, 4, 3}
		};
		ArrayPrint.intArrayPrint(matrix);
		System.out.println();
		setZeros1(matrix);
		ArrayPrint.intArrayPrint(matrix);
	}
}
