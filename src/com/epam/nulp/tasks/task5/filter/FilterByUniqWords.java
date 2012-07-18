package com.epam.nulp.tasks.task5.filter;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.epam.nulp.tasks.task5.text.Sentence;
import com.epam.nulp.tasks.task5.text.SentencePart;
import com.epam.nulp.tasks.task5.text.Word;

public class FilterByUniqWords extends Filter<Sentence> {

    private Set<Word> getUniqueWordsFrom(List<Sentence> text) {
	Set<Word> uniqueWords = new HashSet<Word>();
	System.out.println(text.get(0).getOnlyWords());
	for (SentencePart s: text.get(0).getOnlyWords())
	    uniqueWords.add((Word) s);
	
	List<Sentence> subList = text.subList(1, text.size());
	Set<Word> wordsToTest = new HashSet<Word>(uniqueWords);
	for (Word word : wordsToTest) 
	    for (Sentence sentence : subList) 
		if (sentence.getOnlyWords().contains(word)) {
		    uniqueWords.remove(word);
		    break;
		}
	
	if (!NO_OUTPUT) {
	    getOutput().println("Testing word for uniquality: " + wordsToTest);
	    getOutput().println("Unique are: " + uniqueWords);
	}
	return uniqueWords;
    }

    @Override
    public Iterator<?> filter(List<Sentence> input) {
	return getUniqueWordsFrom(input).iterator();
    }

}
