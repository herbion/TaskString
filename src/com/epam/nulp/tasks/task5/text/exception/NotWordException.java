package com.epam.nulp.tasks.task5.text.exception;

@SuppressWarnings("serial")
public class NotWordException extends Exception {

    public NotWordException(String string) {
	super(string);
    }
    public NotWordException() {
    }
}
