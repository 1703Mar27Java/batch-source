package com.revature.io;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class DogHandler extends DefaultHandler {

	
	 @Override
	    public void startElement(String uri,String localname, String qName, Attributes attributes) throws SAXException{
	        System.out.println(qName+": ");
	    }
	    /*
	     * The method that gets called at the end of an element * We'll print that
	     * the element has ended.
	     */ @Override
	    public void endElement(String uri, String localName, String qName) throws SAXException {
	        System.out.println("// " + qName);
	    }
	    /* What we do when we encounter the contents of the element. */ @Override
	    public void characters(char[] ch, int start, int length) throws SAXException {
	        System.out.println(new String(ch, start, length));
	    }
	
}
