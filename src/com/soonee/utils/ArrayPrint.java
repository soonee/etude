package com.soonee.utils;

import java.util.Arrays;

public class ArrayPrint {
	public static void intArrayPrint(int[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}
}
