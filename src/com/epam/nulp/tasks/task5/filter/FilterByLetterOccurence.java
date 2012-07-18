package com.epam.nulp.tasks.task5.filter;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.epam.nulp.tasks.task5.text.Word;
import com.epam.nulp.tasks.task5.util.StringUtil;

public class FilterByLetterOccurence extends Filter<Word> {

    private char letter;

    public static Map<Integer, List<Word>> filterByLetterOccurence(
	    List<Word> words, char ch) {
	Map<Integer, List<Word>> sortedByOccur = new TreeMap<Integer, List<Word>>();
	for (Word word : words) {
	    int occur = StringUtil.count(word.toString(),
		    String.valueOf(ch), true);
	    if (!sortedByOccur.containsKey(occur))
		sortedByOccur.put(occur, new ArrayList<Word>());
	    if (!sortedByOccur.get(occur).contains(word))
		sortedByOccur.get(occur).add(word);
	}
	// { key : value }
	// { count.of.letter.in.word : group.of.words }
	for (Entry<Integer, List<Word>> entry : sortedByOccur.entrySet()) {
	    // TODO: Sort or not to sort. Look for task.
	    Collections.sort(entry.getValue(), Word.COMPARATOR_CASE_SENSETIVE);
	    if (!NO_OUTPUT)
		getOutput().println(
			MessageFormat.format("Group #{0}\n{1}", entry.getKey(),
				entry.getValue()));
	}
	return sortedByOccur;
    }

    public char getLetter() {
	return letter;
    }

    public void setLetter(char letter) {
	this.letter = letter;
    }

    @Override
    public Iterator<Entry<Integer, List<Word>>> filter(List<Word> input) {
	return filterByLetterOccurence(input, letter).entrySet().iterator();
    }

}
