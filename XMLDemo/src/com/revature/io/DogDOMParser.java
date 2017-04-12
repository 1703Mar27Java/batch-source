package com.revature.io;


import java.io.IOException;

import javax.xml.parsers.*;


import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class DogDOMParser {

	public static void main(String[] args) {
		String filename="src/Dogs.xml";
		DogDOMParser.readDogs(filename);
	}
	
	static void readDogs(String filename){
		DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();//factory design pattern
		DocumentBuilder dBuilder;
		try{
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc= dBuilder.parse(filename);
			doc.getDocumentElement().normalize();
			System.out.println(doc.getDocumentElement().getNodeName());
			NodeList dogList= doc.getElementsByTagName("dog");
			for(int i=0;i<dogList.getLength();i++){
				Node dog=dogList.item(1);
				System.out.println("\t"+dog.getNodeName());
				NodeList puppies=dog.getChildNodes();
				
				for(int j=0;j<puppies.getLength();j++){
					Node puppy=puppies.item(j);
					if(puppy.getNodeType()==Node.ELEMENT_NODE){
						System.out.println("\t\t"+puppy.getNodeName()+" :"+puppy.getTextContent());
					}
				}
				
			}
		}catch(ParserConfigurationException e){
			e.printStackTrace();
		}catch(SAXException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}

}
