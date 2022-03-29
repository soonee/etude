package com.soonee.study.algorithm.sort;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BubbleSort {
	public void sort(Integer[] arr) {
		int n = arr.length;
		IntStream.range(0, n - 1)
				.flatMap(i -> IntStream.range(1, n - i))
				.forEach(j -> {
					if (arr[j - 1] > arr[j]) {
						int temp = arr[j];
						arr[j] = arr[j - 1];
						arr[j - 1] = temp;
					}
				});
	}
	public static void sortTest() {
		Integer[] array = {2,1,4,6,3,5};
		BubbleSort instance = new BubbleSort();
		instance.sort(array);
		System.out.println("sort : " + Arrays.toString(array));
	}
}
