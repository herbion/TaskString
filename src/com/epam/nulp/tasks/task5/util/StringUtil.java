package com.epam.nulp.tasks.task5.util;

public class StringUtil {
    public static final String VOVELS_STING = "eyioua";

    public static String capitalize(String s) {
	if (s == null)
	    throw new NullPointerException("You know why.");
	if (s.isEmpty())
	    return s;

	return String.valueOf(s.charAt(0)).toUpperCase()
		.concat(s.substring(1).toLowerCase());
    }

    public static int count(String text, String letters, boolean IGNORE_CASE) {
	if (IGNORE_CASE) {
	    text = text.toLowerCase();
	    letters = letters.toLowerCase();
	}
	int found = 0;
	for (int i = 0; i < text.length(); i++)
	    if (letters.contains(text.substring(i, i + 1)))
		++found;
	return found;
	// return ((pos=str.indexOf(letter, pos)) == -1)?0:1+count(str, letter,
	// pos+1);
    }

    public static int countVowels(String word) {
	return count(word, VOVELS_STING, true);
    }

    public static String join(Object[] parts, String delimitier) {
	StringBuilder sb = new StringBuilder();
	for (Object part : parts)
	    sb.append(part).append(delimitier);
	return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public static void printWithIndexes(String... array) {
	int i = 1;
	for (String string : array) {
	    System.out.printf("%d%s%s\n", i++, ") ", string);
	}
    }
}
