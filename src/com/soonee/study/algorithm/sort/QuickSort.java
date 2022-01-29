package com.soonee.study.algorithm.sort;

import java.util.Random;

/**
 * 퀵정렬
 * 피봇선정방법에 따라 3가지 존재
 * 1. 처음 선정
 * 2. 가운데 선정
 * 3. 마지막 선정
 * 4. 무작위 선정
 */
public class QuickSort {

	public enum PartitionType {
		FIRST,
		MIDDLE,
		LAST,
		RANDOM
	}

	private static void swap(int[] arr, int source, int target) {
		int temp = arr[source];
		arr[source] = arr[target];
		arr[target] = temp;
	}

	private static int partition(int[] arr, PartitionType type, int start, int finish) {
		int pivot = 0;
		int index = start;
		switch (type) {
			case FIRST:
				pivot = start;
				break;
			case MIDDLE:
				pivot = (start + finish + 1) / 2;
				break;
			case LAST:
				pivot = finish;
				break;
			case RANDOM:
				Random rd = new Random(System.currentTimeMillis());
				pivot = rd.nextInt(finish - start + 1) + start;
				break;
		}
		// pivot 값은 이제 arr[finish]
		swap(arr, pivot, finish);
		for(int i = start; i < finish; i++) {
			if(arr[i] <= arr[finish]) {
				swap(arr, index, i);
				index++;
			}
		}
		swap(arr, index, finish);
		return index;
	}

	private static void sort(int[] arr, int start, int finish, PartitionType type) {
		if(finish <= start) return;
		int pivot = partition(arr, type, start, finish);
		sort(arr, start, pivot - 1, type);
		sort(arr, pivot + 1, finish, type);
	}

	private static int partition2(int[] arr, int left, int right, PartitionType type) {
		int temp = 0;
		// 분할 기준 원소 선정
		int pivot = 0;
		switch (type) {
			case FIRST:
				pivot = left;
				break;
			case MIDDLE:
				pivot = (left + right + 1) / 2;
				break;
			case LAST:
				pivot = right;
				break;
			case RANDOM:
				Random rd = new Random(System.currentTimeMillis());
				pivot = rd.nextInt(right - left + 1) + left;
				break;
		}
		while(left <= right) {
			// 왼쪽에서 오른쪽으로 옮겨야 하는 원소 탐색
			while(arr[left] < pivot) left++;
			// 오른쪽에서 왼쪽으로 옮겨야 하는 원소 탐색
			while(arr[right] > pivot) right--;
			// 원소를 스왑한 뒤 left와 right를 이동
			if(left <= right) {
				// 스왑
				temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}
		return left;
	}
	public static void sort2(int[] arr, int left, int right) {
		int index = partition2(arr, left, right, PartitionType.MIDDLE);
		if(left < index - 1) sort2(arr, left, index - 1);
		if(index < right) sort2(arr, index, right);
	}

	public static void sort(int[] arr, PartitionType type) {
		sort(arr, 0, arr.length - 1, type);
	}

	public static void sort(int[] arr) {
		sort2(arr, 0, arr.length - 1);
	}

}
