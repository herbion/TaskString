package com.epam.nulp.tasks.task5.text;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.epam.nulp.tasks.task5.util.StringUtil;

public class Text extends LinkedList<Sentence> {
    private static final String SENTENCE_MATCHER = ".+?[?!.]+\"?";
    /**
     * Because of warning.
     */
    private static final long serialVersionUID = -808743362207862176L;

    /**
     * @return All i need is all words in text for my task.
     */
    public List<Word> getAllWords() {
	List<Word> words = new ArrayList<Word>();
	for (Sentence sentence : this) {
	    // FIX: maybe it safe, maybe not.
	    for (SentencePart word : sentence.getOnlyWords()) {
		words.add((Word) word);
	    }
	}
	return words;
    }

    public static Text valueOf(List<String> lines) {
	Text text = new Text();
	String join = StringUtil.join(lines.toArray(), " ");
	Pattern p = Pattern.compile(SENTENCE_MATCHER); //sentence parse
	Matcher matcher = p.matcher(join);

	while(matcher.find())
	    text.add(Sentence.parseString(matcher.group()));
	return text;
    }
    public static Text valueOf(List<String> lines, BreakIterator bi) {
	Text text = new Text();
	
	String source = StringUtil.join(lines.toArray(), "");
	
	bi.setText(source);
	
	int start = bi.first();
	     for (int end = bi.next(); end != BreakIterator.DONE; start = end, end = bi.next()) {
	          text.add(Sentence.parseString(source.substring(start,end)));
	}
	return text;
    }
}