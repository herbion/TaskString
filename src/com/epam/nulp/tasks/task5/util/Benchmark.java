package com.epam.nulp.tasks.task5.util;

public class Benchmark {
    private long start, end;
    /**
     * @return Return difference between end & start in milliseconds.
     */
    public double bench(Runnable function) {
	start();
	function.run();
	end();
	return diff();
    }
    final private double diff() {
	return (end - start)/1e6;
    }
    final private void end() {
	end = System.nanoTime();
    }
    final private void start() {
	start = System.nanoTime();
    }
}
