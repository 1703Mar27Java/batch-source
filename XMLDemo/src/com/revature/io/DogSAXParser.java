package com.revature.io;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class DogSAXParser {

	public static void main(String[] args) {
		String filename = "src/Dogs.xml";
		DogSAXParser.ReadDogs(filename);
		
	}
	
	static void ReadDogs(String filename){
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try{
			SAXParser saxParser = factory.newSAXParser();
			DogHandler handler = new DogHandler();
			saxParser.parse(filename, handler);
			
		} catch (ParserConfigurationException e){
			e.printStackTrace();
		} catch (SAXException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
	}

}
