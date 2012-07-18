package com.epam.nulp.tasks.task5.util;

import java.util.Enumeration;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;

public class Resource {
    private ResourceBundle rb;
    private Resource(ResourceBundle rb) {
	this.rb = rb;
    }

    public static Resource loadResourse(String bundleName, Locale locale) throws Exception {
	ResourceBundle bundle = null;
	try {
	    bundle = ResourceBundle.getBundle(bundleName, locale);
	    return new Resource(bundle);
	} catch (MissingResourceException e) {
	    System.out.println("Resource: " + bundleName + " missing.");
	     throw new Exception(e);
	}
//	return null;
    }

    public static Resource loadResource(String pathToResourse) throws Exception {
	return loadResourse(pathToResourse, Locale.getDefault());
    }

    public final String getParameter(String key) {
	return rb.getString(key);
    }

    public final String[] getParametersArray(String key) {
	return rb.getStringArray(key);
    }

    public Enumeration<String> getParametersKeys() {
	return rb.getKeys();
    }

    public boolean containsParametr(String key) {
	return rb.containsKey(key);
    }

    public Set<String> ParametersSet() {
	return rb.keySet();
    }
}
