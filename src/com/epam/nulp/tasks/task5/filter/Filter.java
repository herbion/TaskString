package com.epam.nulp.tasks.task5.filter;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;

public abstract class Filter<T> {
    abstract public Iterator<?> filter(List<T> input);

    private static PrintStream OUT = System.out;
    public static boolean NO_OUTPUT = false;

    public static PrintStream getOutput() {
	return OUT;
    }

    public static void setOutput(PrintStream oUT) {
	OUT = oUT;
    }

}
