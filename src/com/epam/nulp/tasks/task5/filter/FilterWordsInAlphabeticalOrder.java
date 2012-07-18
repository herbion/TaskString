package com.epam.nulp.tasks.task5.filter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.epam.nulp.tasks.task5.text.Word;

public class FilterWordsInAlphabeticalOrder extends Filter<Word> {

    public static Map<Character, List<Word>> filterWordsInAlphabeticalOrder(
	    List<Word> input, Comparator<Word> c) {
	Map<Character, List<Word>> treeMap = new TreeMap<Character, List<Word>>();

	for (Word word : input) {
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
    
    public static Map<Character, List<Word>> filterWordsInAlphabeticalOrder(
	    List<Word> input) {
	return filterWordsInAlphabeticalOrder(input,
		Word.COMPARATOR_CASE_INSENSETIVE);

    }

    @Override
    public Iterator<Map.Entry<Character, List<Word>>> filter(List<Word> input) {
	return filterWordsInAlphabeticalOrder(input).entrySet().iterator();
    }

}
