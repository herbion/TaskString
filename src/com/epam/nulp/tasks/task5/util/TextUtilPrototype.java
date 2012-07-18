package com.epam.nulp.tasks.task5.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.epam.nulp.tasks.task5.text.Text;

enum SettingsText {
    IGNORE_CASE, DO_NOT_IGNORE_CASE
}

@Deprecated
public class TextUtilPrototype {
    // public static final String BY_WORDS = "\\W*\\b[a-z]+\\b\\W*";
    public static final String SPACES_REGEX = "\\s+";

    public static final String BY_WORDS = "[^\\w']";
    public static boolean SILENT_MODE = false;
//    public static <T> Collection<?> changeText(Text text, Parser parser) {
//	return parser.parse(text);
//	
//    }
    public static void UniqueWords(List<String> text) {
	String[] wordsToTest = text.get(0).split(BY_WORDS);
	
	System.out.println("TESTING WORDS UNIQUE: "
		+ Arrays.toString(wordsToTest));
	boolean found = false;
	for (String word : wordsToTest) {
	    for (String sentence : text.subList(1, text.size())) {
		if (sentence.contains(word)) {
		    found = true;
		    break;
		}
	    }
	    if (!found)
		System.out.println("Unique: " + word);
	    found = false;
	}
    }
    public static void UniqueWords(Text text) {
//	Sentence wordsToTest = text.get(0).getOnlyWords();
//	System.out.println("TESTING WORDS UNIQUE: " + wordsToTest);
//	boolean found = false;
//	for (SentencePart word : wordsToTest) {
//	    for (Sentence sentence : text.subList(1, text.size())) {
//		if (sentence.toString().contains(word.toString())) {
//		    found = true;
//		    break;
//		}
//	    }
//	    if (!found)
//		System.out.println("Unique: " + word);
//	    found = false;
//	}
	// v2
//	List<SentencePart> wordsToTest = text.get(0).getOnlyWords();
//	Set<Word> set = new HashSet<Word>(text.subList(1, text.size).getAllWords());
//	for (Word w: wordsToTest) {
//	    if (!set.contains(w))
//		System.out.println("Unique");
//	}
    }
    public static String[] parseWords(String sentence) {
	return sentence.split(BY_WORDS);
	
    }
    public static void printAlphabethical(List<String> text) {
	List<String> sorted = new ArrayList<String>();

	for (String sentence : text) {
	    for (String word : sentence.split(BY_WORDS)) {
		if (word.isEmpty())
		    continue;
		sorted.add(word);
	    }
	}
	Collections.sort(sorted);
	char prefix = sorted.get(0).charAt(0);
	for (String word : sorted) {
	    System.out.print(word + ", ");
	    if (!word.startsWith(String.valueOf(prefix))) {
		prefix = word.charAt(0);
		System.out.println(".");
	    }
	}
    }
 



    public static String trimmSpacesSymbols(String sentence) {
	return sentence.trim().replaceAll(SPACES_REGEX, " ");
    }

    public static Map<Integer, ArrayList<String>> sortByLetterOccur(List<String> text, char letter) {
	Map<Integer, ArrayList<String>> sortedByOccur = new TreeMap<Integer, ArrayList<String>>();
	
	for (String sentence : text) {
	    for (String word : sentence.split(BY_WORDS)) {
		if (word.isEmpty())
		    continue;
		int occur = StringUtil.count(word, String.valueOf(letter), true);
		if (!sortedByOccur.containsKey(occur))
		    sortedByOccur.put(occur, new ArrayList<String>());
		sortedByOccur.get(occur).add(word);
	    }
	}

	for (Integer count : sortedByOccur.keySet()) {
	    ArrayList<String> words = sortedByOccur.get(count);
	    Collections.sort(words);
	    
	    if (!SILENT_MODE) {
		System.out.println("Group: " + count);
		for (String word : words)
		    System.out.println(word);
	    }
	}
	return sortedByOccur;
    }

    public static void sortByVovelsPercent(List<String> text) {
	Map<Double, ArrayList<String>> hashMap = new TreeMap<Double, ArrayList<String>>();

	for (String sentence : text) {
	    for (String word : sentence.split(BY_WORDS)) {
		if (word.isEmpty())
		    continue;
		Double persentOfVovels = StringUtil.countVowels(word)
			/ (double) word.length();
		if (!hashMap.containsKey(persentOfVovels)) {
		    hashMap.put(persentOfVovels, new ArrayList<String>());
		}
		hashMap.get(persentOfVovels).add(word);
	    }
	}

	for (Double persent : hashMap.keySet()) {
	    System.out.println("Persent: " + persent);
	    ArrayList<String> words = hashMap.get(persent);
	    Collections.sort(words);

	    for (String word : words) {
		System.out.println(word);
	    }
	}
	return;

    }
    public void printPolindromes(String test) {
	for (int palindromeMinLength = 3; palindromeMinLength < test.length(); palindromeMinLength++)
	    for (int i = 0; i + palindromeMinLength < test.length(); i++)
		if (isPalindrome(test.substring(i, i + palindromeMinLength)))
		    System.out.println(test.substring(i, i + palindromeMinLength));
    }

    private boolean isPalindrome(String s) {
	    return s.contentEquals(new StringBuilder(s).reverse());
    }
    public static void main(String[] args) {
//	ReaderFile readerFile = new ReaderFile();
//	List<String> content = readerFile.readContent("test");
//	List<String> trimmText = new ArrayList<String>();
//	
//	for (String string : content) {
//	    trimmText.add(TextUtil.trimmSpacesSymbols(string));
//	    System.out.println(TextUtil.trimmSpacesSymbols(string));
//	}
//	System.out.println("TextUtil.sortByLetterOccur(trimmText, 'i')");
//	TextUtil.sortByLetterOccur(trimmText, 'i');
//	System.out.println("TextUtil.UniqueWords(content)");
//	TextUtil.UniqueWords(content);
//	System.out.println("TextUtil.sortByVovelsPercent(content)");
//	TextUtil.sortByVovelsPercent(content);
//	System.out.println("TextUtil.printAlphabethical(content)");
//	TextUtil.printAlphabethical(content);
	
//	System.out.println(new File("/home/herbion/bundle.properties").exists());
//	ResourceBundle.getBundle("")
//	System.out.println(resource.getParameter("file.input"));
    }
}
