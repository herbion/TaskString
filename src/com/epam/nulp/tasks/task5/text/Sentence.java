package com.epam.nulp.tasks.task5.text;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.epam.nulp.tasks.task5.text.exception.NotWordException;

@SuppressWarnings("serial")
public class Sentence extends LinkedList<SentencePart> {
    private static final String SPLIT_STRING_INTO_TOKENS = "\\b([\\w\'-]+)|([^\\s\\w])+\\s*\\b?";

    public Sentence() {

    }

    public boolean addWord(String word) {
	return add(new Word(word));
    }

    public boolean addPunctution(String punctuation) {
	return add(new Punctuation(punctuation));
    }

    public List<Word> getOnlyWords() {
	ArrayList<Word> newSentence = new ArrayList<Word>();
	for (SentencePart part : this)
	    if (part instanceof Word)
		newSentence.add((Word)part);
	return newSentence;
    }

    /**
     * Builds a sentence object from a string. Parsing it into words or
     * punctuation (!words) Using nasty regexp. Need to fix.
     * 
     * @param s
     *            String from witch you want to build.
     * @return Happiness.
     */
    public static Sentence parseString(String s) {
	Sentence newSentence = new Sentence();
	Pattern pattern = Pattern.compile(SPLIT_STRING_INTO_TOKENS,
		Pattern.DOTALL);
	Matcher matcher = pattern.matcher(s);
	while (matcher.find()) {
	    String token = matcher.group();
	    if (token.isEmpty())
		continue;
	    try {
		newSentence.add(Word.ValueOf(token.trim()));
	    } catch (NotWordException e) {
		newSentence.add(Punctuation.valueOf(token.trim()));
	    }
	}
	return newSentence;
    }

    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder();
	for (SentencePart part : this) {
	    sb.append(part).append(" ");
	    
	}
	//TODO: Dirty. Fix that.
//	sb.deleteCharAt(sb.length());
//	sb.setLength(sb.length() - 1);
	return sb.toString();
    }

}