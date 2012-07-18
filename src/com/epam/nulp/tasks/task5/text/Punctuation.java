package com.epam.nulp.tasks.task5.text;

public class Punctuation extends SentencePart {
    public Punctuation(String punctuation) {
	this.value = punctuation;
    }

    public static Punctuation valueOf(String punctuation) {
	return new Punctuation(punctuation);
    }

    @Override
    public String toString() {
	return value;
    }
}