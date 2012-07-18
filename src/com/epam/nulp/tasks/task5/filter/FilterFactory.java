package com.epam.nulp.tasks.task5.filter;

import com.epam.nulp.tasks.task5.filter.exception.UndefinedOptionException;
import com.epam.nulp.tasks.task5.util.Resource;

public class FilterFactory {
    private static Resource res;
    public static Filter<?> getFilterInstance(FiltersEnum parser) throws UndefinedOptionException {
	switch (parser) {
		case GET_UNIQUE_WORDS_IN_FIST_SENTENCE: {
		    return new FilterByUniqWords();
		}
        	case GET_WORDS_BY_OCCURENCE_OF_CUSTOM_LETTER: {
        	    FilterByLetterOccurence f = new FilterByLetterOccurence();
        	    f.setLetter(res.getParameter("sort.by.letter").charAt(0));
		    return f;
        	}
        	case GET_WORDS_SORTED_APHABETICAL: {
        	    return new FilterWordsInAlphabeticalOrder();
        	}
        	case GET_WORDS_BY_PERCENT_OF_VOVELS: {
        	    return new FilterByVovelsPercent();
        	}
        	default:
        	    throw new UndefinedOptionException();
	}
    }
    public static Resource getResource() {
	return res;
    }
    public static void setResource(Resource res) {
	FilterFactory.res = res;
    }
}
