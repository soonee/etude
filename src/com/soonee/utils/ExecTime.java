package com.soonee.utils;
//32343291319119
//32380340318971
public class ExecTime {
	private long start;
	private long stop;

	public void start() {
		start = System.nanoTime();
	}
	public void stop() {
		stop = System.nanoTime();
	}
	public long getRunTimeNano() {
		return stop - start;
	}
	public void printExecTime() {
		System.out.println( String.format("%.3f", (stop - start) / (double)1000000000)  + " sec" );
	}
}
