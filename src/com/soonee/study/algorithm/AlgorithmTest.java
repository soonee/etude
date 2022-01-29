package com.soonee.study.algorithm;

import com.soonee.study.algorithm.sort.QuickSort;
import com.soonee.study.algorithm.sort.InsertionSort;
import com.soonee.utils.ExecTime;

import java.util.Arrays;
import java.util.Random;

public class AlgorithmTest {

	public static void printArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
		return;
	}

	public static void main(String args[]) {
		int arraySize = 10;
		int[] insert = new int[arraySize];
		int[] quick = new int[arraySize];
		int[] quick2 = new int[arraySize];
		Random rd = new Random(System.currentTimeMillis());
		for(int i = 0; i < arraySize - 1; i++) {
			insert[i] = rd.nextInt(arraySize);
			quick[i] = rd.nextInt(arraySize);
			quick2[i] = rd.nextInt(arraySize);
		}

		ExecTime timer = new ExecTime();

		// 1.808 sec - 10만개일때
		// 43.691 sec - 50만개일때
		timer.start();
		printArray(insert);
		InsertionSort.sort(insert);
		printArray(insert);
		timer.stop();
		timer.printExecTime();

		// 0.020 sec - 10만개일때
		// 0.083 sec - 50만개일때
		timer.start();
		printArray(quick);
		QuickSort.sort(quick, QuickSort.PartitionType.RANDOM);
		printArray(quick);
		timer.stop();
		timer.printExecTime();

		timer.start();
		printArray(quick2);
		QuickSort.sort2(quick2, 0, quick2.length - 1);
		printArray(quick2);
		timer.stop();
		timer.printExecTime();
		return;
	}

}
