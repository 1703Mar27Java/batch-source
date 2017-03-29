package com.revature.io;

import java.io.*;

public class Serialize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "src/SerializedThings/PersonDemo";
		Person person = new Person("john", 23, "123456789");
		writeObject(fileName, person);
		readObject(fileName);
	}

	static void writeObject(String filename, Object obj) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
			oos.writeObject(obj);
			System.out.println(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void readObject(String filename) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			Object o = ois.readObject();
			System.out.println(o);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
