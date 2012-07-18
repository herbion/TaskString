package com.epam.nulp.tasks.task5.text;

import java.util.Comparator;

import com.epam.nulp.tasks.task5.text.exception.NotWordException;

/**
 **  String with benefits.
 */
public class Word extends SentencePart implements Comparable<Word>{
    private static final String NOT_A_WORD_REGEX = "\\W+|_";
//    private String value; 
    
    public final static Comparator<Word> COMPARATOR_CASE_INSENSETIVE = new Comparator<Word>() {
	@Override
	public int compare(Word o1, Word o2) {
	    return o1.getValue().compareToIgnoreCase(o2.getValue());
	}
    };
    public final static Comparator<Word> COMPARATOR_CASE_SENSETIVE = new Comparator<Word>() {
	@Override
	public int compare(Word o1, Word o2) {
	    return o1.getValue().compareTo(o2.getValue());
	}
    };
    public Word(String value) {
	this.value = value;
    }

    public static Word ValueOf(String word) throws NotWordException {
	if (!isWord(word)) // TODO: Don't forget to Fix that regexp
	    throw new NotWordException("Not a word!");
	return new Word(word);
    }

    public static boolean isWord(String word) {
	return !word.matches(NOT_A_WORD_REGEX);
    }

    @Override
    public String toString() {
	return value;
    }

    public boolean startsWith(String prefix) {
	return value.startsWith(prefix);
    }

    public int length() {
	return value.length();
    }

    public char charAt(int index) {
	return value.charAt(index);
    }

    public boolean contains(CharSequence s) {
	return value.contains(s);
    }


    public boolean equalsIgnoreCase(String anotherString) {
	return value.equalsIgnoreCase(anotherString);
    }

    public boolean isEmpty() {
	return value.isEmpty();
    }

    public boolean contentEquals(StringBuffer sb) {
	return value.contentEquals(sb);
    }

    public boolean contentEquals(CharSequence cs) {
	return value.contentEquals(cs);
    }

    public int compareTo(String anotherString) {
	return value.compareTo(anotherString);
    }

    public int compareToIgnoreCase(String str) {
	return value.compareToIgnoreCase(str);
    }

    public boolean startsWith(String prefix, int toffset) {
	return value.startsWith(prefix, toffset);
    }

    public boolean endsWith(String suffix) {
	return value.endsWith(suffix);
    }


    public int indexOf(int ch) {
	return value.indexOf(ch);
    }

    public int indexOf(int ch, int fromIndex) {
	return value.indexOf(ch, fromIndex);
    }

    public int lastIndexOf(int ch) {
	return value.lastIndexOf(ch);
    }

    public int lastIndexOf(int ch, int fromIndex) {
	return value.lastIndexOf(ch, fromIndex);
    }

    public int indexOf(String str) {
	return value.indexOf(str);
    }

    public int indexOf(String str, int fromIndex) {
	return value.indexOf(str, fromIndex);
    }

    public int lastIndexOf(String str) {
	return value.lastIndexOf(str);
    }

    public int lastIndexOf(String str, int fromIndex) {
	return value.lastIndexOf(str, fromIndex);
    }

    public String substring(int beginIndex, int endIndex) {
	return value.substring(beginIndex, endIndex);
    }

    public String toLowerCase() {
	return value.toLowerCase();
    }

    public String toUpperCase() {
	return value.toUpperCase();
    }

    @Override
    public int compareTo(Word o) {
	return this.value.compareTo(o.value);
    }
}