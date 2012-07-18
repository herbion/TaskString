package com.epam.nulp.tasks.task5.text;

public abstract class SentencePart {
    protected String value;

    public String getValue() {
	return value;
    }

    public void setValue(String value) {
	this.value = value;
    }

    public abstract String toString();

    public boolean equals(Object anObject) {
	return value.equals(anObject.toString());
    }
    
}