package com.epam.nulp.tasks.task5.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FileUtil {
    private List<String> text = new LinkedList<String>();

    private BufferedReader br = null;

    private void addContentToList() {
	String line = null;
	try {
	    while ((line = br.readLine()) != null)
		text.add(line);
	} catch (IOException e) {
	    System.err.println("Error while reading from file.");
	}
    }

    private void closeFile() {
	try {
	    if (br != null)
		br.close();
	} catch (IOException e) {
	    System.err.println("Error while closing.");
	}
    }

    private BufferedReader openFileToRead(String fileName) {
	try {
	    return (br = new BufferedReader(new java.io.FileReader(fileName)));
	} catch (FileNotFoundException e) {
	    System.err.println("Can\'t find a file" + fileName);
	    return null;
	}
    }

    public static List<String> readContent(String fileName) {
	FileUtil util = new FileUtil();
	try {
	    if ((util.openFileToRead(fileName)) != null)
		util.addContentToList();
	    return util.text;
	} finally {
	    util.closeFile();
	}
    }
    public static <T> void writeToFile(String annotation, String fileName, Iterator<T> newContent) {
  	PrintWriter pw = null;
  	try {
  	    try {
  		pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(fileName), true)));
  	    } catch (IOException e) {
  		System.err.println("Sorry, i can\'t open file. Closing...");
  		return;
  	    }
  	    pw.println(annotation);
  	    for (Iterator<T> iterator = newContent; iterator.hasNext();) {
		try {
		    pw.println(iterator.next());
		} catch (Exception e) {
		    System.err.println("Error while writing data to file:");
		}
	    }
  	    pw.println();
  	} finally {
  	    try {
  		pw.close();
  		System.out.println("Results saved in: "
  			+ System.getProperty("user.dir")
  			+ System.getProperty("file.separator") + fileName);
  	    } catch (Exception e) {
  		System.err.println("Error while closing file: " + fileName);
  	    }
  	}
      }
}