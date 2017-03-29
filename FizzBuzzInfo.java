package com.Revature.io;
import java.io.*;

public class FizzBuzzInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6058507650456973290L;
	private int startRange;
	private int endRange;
	private int a;
	private int b;
	
	public FizzBuzzInfo(int sr, int er, int a, int b){
		this.startRange = sr;
		this.endRange = er;
		this.a = a;
		this.b = b;
	}
	
	public void doFizzBuzz(){
		for(int i = startRange; i <= endRange; i++){
			if(i%a == 0 || i%b == 0){
				if(i%a == 0) System.out.print("fizz");
				if(i%b == 0) System.out.print("buzz");
			}else{
				System.out.print(i);
			}
			System.out.println();
		}
	}
	void writeToFile(String filename) {
		try {
			FileWriter fw = new FileWriter(filename);
			for(int i = startRange; i <= endRange; i++){
				if(i%a == 0 || i%b == 0){
					if(i%a == 0) fw.write("fizz");
					if(i%b == 0) fw.write("buzz");
				}else{
					fw.write(i+"");
				}
				fw.write("\n");
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	void writeObject(String filename, Object obj) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
			oos.writeObject(obj);
			System.out.println(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	void readObject(String filename) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			Object obj = ois.readObject();
			System.out.println(obj);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}


	public int getStartRange() {
		return startRange;
	}

	public void setStartRange(int startRange) {
		this.startRange = startRange;
	}

	public int getEndRange() {
		return endRange;
	}

	public void setEndRange(int endRange) {
		this.endRange = endRange;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		result = prime * result + b;
		result = prime * result + endRange;
		result = prime * result + startRange;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FizzBuzzInfo other = (FizzBuzzInfo) obj;
		if (a != other.a)
			return false;
		if (b != other.b)
			return false;
		if (endRange != other.endRange)
			return false;
		if (startRange != other.startRange)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FizzBuzzInfo [startRange=" + startRange + ", endRange=" + endRange + ", a=" + a + ", b=" + b + "]";
	}
	
}
