package com.soonee.study.algorithm.sort;

public class SelectionSort {
	public void ascendSort(final int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int minElementIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minElementIndex] > arr[j]) {
					minElementIndex = j;
				}
			}
			if (minElementIndex != i) {
				int temp = arr[i];
				arr[i] = arr[minElementIndex];
				arr[minElementIndex] = temp;
			}
		}
	}
	public void sortTest() {
		int[] array = {2,1,4,6,3,5};
		this.ascendSort(array);
	}
}
