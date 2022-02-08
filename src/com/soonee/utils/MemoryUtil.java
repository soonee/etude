package com.soonee.utils;

import javax.sound.midi.Soundbank;

public class MemoryUtil {
	// VM Heap Max Size
	public static void getMaxMemorySize() {
		long maxMemory = (Runtime.getRuntime().maxMemory()) / (1024 * 1024);
		System.out.println(maxMemory + "MB");
	}
	// VM Heap Total Size
	public static void getTotalMemorySize() {
		long totalMemory = (Runtime.getRuntime().totalMemory()) / (1024 * 1024);
		System.out.println(totalMemory + "MB");
	}
	// VM Heap Allocation Size
	public static void getAllocMemorySize() {
		long allocMemory = ( (Runtime.getRuntime().totalMemory()) - (Runtime.getRuntime().freeMemory())  ) / (1024 * 1024);
		System.out.println(allocMemory + "MB");
	}
}
