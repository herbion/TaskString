package com.epam.nulp.tasks.task5.filter;

import java.util.Iterator;
import java.util.List;

@SuppressWarnings("rawtypes")
public class FilterStrategy {
    @SuppressWarnings("unchecked")
    public static Iterator<?> filter(List text, Filter<?> f) {
	return f.filter(text);
    }
}
