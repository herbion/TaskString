package com.epam.nulp.tasks.task5.util;

import java.io.PrintStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import com.epam.nulp.tasks.task5.text.Sentence;
import com.epam.nulp.tasks.task5.text.Text;
import com.epam.nulp.tasks.task5.text.Word;

@Deprecated
public class OldTextUtil {
    private static PrintStream OUT = System.out;
    public static boolean SILENT_MODE = false;

    public static Set<Word> UniqueWords(Text text) {
	Set<Word> uniqueWords = new HashSet<Word>();
	uniqueWords.addAll(text.get(0).getOnlyWords());
	
	List<Sentence> subList = text.subList(1, text.size());
	Set<Word> wordsToTest = new HashSet<Word>(uniqueWords);
	for (Word word : wordsToTest) 
	    for (Sentence sentence : subList) 
		if (sentence.getOnlyWords().contains(word)) {
		    uniqueWords.remove(word);
		    break;
		}
	
	if (!SILENT_MODE) {
	    getOutput().println("Testing word for uniquality: " + wordsToTest);
	    getOutput().println("Unique are: " + uniqueWords);
	}
	return uniqueWords;
    }

    public static Map<Character, List<Word>> filterWordsInAlphabeticalOrder(
	    List<Word> words, Comparator<Word> c) {
	Map<Character, List<Word>> treeMap = new TreeMap<Character, List<Word>>();

	for (Word word : words) {
	    Character prefix = Character.toLowerCase(word.charAt(0));
	    if (!treeMap.containsKey(prefix))
		treeMap.put(prefix, new ArrayList<Word>());
	    if (!treeMap.get(prefix).contains(word))
		treeMap.get(prefix).add(word);
	}

	for (List<Word> _words : treeMap.values())
	    Collections.sort(_words, Word.COMPARATOR_CASE_SENSETIVE);

	for (Character aplha : treeMap.keySet())
	    getOutput().println(treeMap.get(aplha));
	return treeMap;
    }

    @Deprecated
    public static void printAplhabetical(List<Word> words, Comparator<Word> c) {
	List<Word> sortedWords = new ArrayList<Word>(words);
	Collections.sort(sortedWords, c);

	char lastPrefix = sortedWords.get(0).charAt(0);

	for (Word word : sortedWords) {
	    char wordPrefix = Character.toLowerCase(word.charAt(0));
	    lastPrefix = Character.toLowerCase(lastPrefix);
	    // ignoring case
	    if (wordPrefix != lastPrefix) {
		lastPrefix = word.charAt(0);
		getOutput().println(".");
	    } else
		System.out.print(", ");
	    getOutput().print(word);
	}
	return;
    }

    public static Map<Character, List<Word>> filterWordsInAlphabeticalOrder(
	    List<Word> words) {
	return filterWordsInAlphabeticalOrder(words,
		Word.COMPARATOR_CASE_INSENSETIVE);

    }

    public static Map<Integer, ArrayList<Word>> filterByLetterOccurence(
	    List<Word> words, char letter) {
	Map<Integer, ArrayList<Word>> sortedByOccur = new TreeMap<Integer, ArrayList<Word>>();

	for (Word word : words) {
	    int occur = StringUtil.count(word.toString(),
		    String.valueOf(letter), true);
	    if (!sortedByOccur.containsKey(occur))
		sortedByOccur.put(occur, new ArrayList<Word>());
	    if (!sortedByOccur.get(occur).contains(word))
		sortedByOccur.get(occur).add(word);
	}
	// { key : value }
	// { count.of.letter.in.word : group.of.words }
	for (Entry<Integer, ArrayList<Word>> entry : sortedByOccur.entrySet()) {
	    // TODO: Sort or not to sort. Look for task.
	    Collections.sort(entry.getValue(), Word.COMPARATOR_CASE_SENSETIVE);
	    if (!SILENT_MODE)
		getOutput().println(
			MessageFormat.format("Group #{0}\n{1}", entry.getKey(),
				entry.getValue()));
	}
	return sortedByOccur;
    }

    public static Map<Double, List<Word>> filterByVovelsPercent(
	    List<Word> words) {
	Map<Double,List<Word>> tree = new TreeMap<Double, List<Word>>();

	for (Word word : words) {
	    Double persentOfVovels = StringUtil.countVowels(word.toString())
		    / (double) word.length();
	    if (!tree.containsKey(persentOfVovels))
		tree.put(persentOfVovels, new ArrayList<Word>());
	    if (!tree.get(persentOfVovels).contains(word))
		tree.get(persentOfVovels).add(word);
	}

	for (List<Word> group : tree.values())
	    Collections.sort(group, Word.COMPARATOR_CASE_INSENSETIVE);

	for (Entry<Double, List<Word>> entry : tree.entrySet())
	    getOutput().println(
		    String.format("%% %.4f", entry.getKey()) + "\n"
			    + entry.getValue());
	return tree;
    }

    public static PrintStream getOutput() {
	return OUT;
    }

    public static void setOutput(PrintStream newOutput) {
	OUT = newOutput;
    }

}
