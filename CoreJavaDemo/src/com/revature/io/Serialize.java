package com.revature.io;

import java.io.*;

public class Serialize {

	public static void main(String[] args) {

		String fileName = "src/serializedThings/PersonDemo";
		Person person = new Person("John", 23, "123456789");
		writeObject(fileName, person);
		readObject(fileName);

	}

	static void writeObject(String fileName, Object obj) {

		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
			oos.writeObject(obj);
			System.out.println(obj);
			oos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void readObject(String fileName) {
		
		try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(fileName))){
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
