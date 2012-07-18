package com.epam.nulp.tasks.task5;

import java.util.List;
import java.util.MissingResourceException;

import com.epam.nulp.tasks.task5.filter.FilterFactory;
import com.epam.nulp.tasks.task5.filter.FilterStrategy;
import com.epam.nulp.tasks.task5.filter.FiltersEnum;
import com.epam.nulp.tasks.task5.filter.exception.UndefinedOptionException;
import com.epam.nulp.tasks.task5.text.Sentence;
import com.epam.nulp.tasks.task5.text.Text;
import com.epam.nulp.tasks.task5.text.Word;
import com.epam.nulp.tasks.task5.util.FileUtil;
import com.epam.nulp.tasks.task5.util.Resource;

public class Main {

    private static final String RESOURCE_BUNDLE = "resource.bundle";

    public static void main(String[] args) {
	Resource res;

	try {
	    res = Resource.loadResource(RESOURCE_BUNDLE);
	    FilterFactory.setResource(res);
	} catch (Exception e) {
	    System.out.println(e.getCause().getMessage());
	    return;
	}
	String output = res.getParameter("file.output");
	Text text = Text.valueOf(FileUtil.readContent(res.getParameter("file.input")));

	for (Sentence sentence : text)
	    System.out.println(sentence);

	List<Word> allWords = text.getAllWords();
	
	try {
	    // # 1
	    System.out.println("Sort word by specific letter occurrence:");
	    FileUtil.writeToFile(
		    res.getParameter("annotation.sort.by.letter.occur") + " "
			    + res.getParameter("sort.by.letter"),
		    output,
		    FilterStrategy.filter(
			    allWords,
			    FilterFactory
				    .getFilterInstance(FiltersEnum.GET_WORDS_BY_OCCURENCE_OF_CUSTOM_LETTER)));

	    // # 2
	    System.out
		    .println("Find unique words in first sentence against whole text:");
	    FileUtil.writeToFile(
		    res.getParameter("annotation.find.uniq.word.in.first.sentence"),
		    output,
		    FilterStrategy.filter(
			    text,
			    FilterFactory
				    .getFilterInstance(FiltersEnum.GET_UNIQUE_WORDS_IN_FIST_SENTENCE)));

	    // # 3
	    System.out.println("Words sorted by percent of vovels:");
	    FileUtil.writeToFile(
		    res.getParameter("annotation.sort.by.vowels.percent"),
		    output,
		    FilterStrategy.filter(
			    allWords,
			    FilterFactory
				    .getFilterInstance(FiltersEnum.GET_WORDS_BY_PERCENT_OF_VOVELS)));

	    // # 4
	    System.out.println("Words groups in aplhabetical order:");
	    FileUtil.writeToFile(
		    res.getParameter("annotation.sort.words.alphabetical.order"),
		    output,
		    FilterStrategy.filter(
			    allWords,
			    FilterFactory
				    .getFilterInstance(FiltersEnum.GET_WORDS_SORTED_APHABETICAL)));

	} catch (UndefinedOptionException e) {
	    System.out.println(res.getParameter("error.unknown.settings"));
	} catch (MissingResourceException e) {
	    System.out.println("Missing resouce.");
	}
	
	System.out.println(res.getParameter("message.done"));
    }
}