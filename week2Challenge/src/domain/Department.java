package domain;

public class Department {
	private String name;
	private int avgSal;
	
	public Department() {
		super();
	}
	
	public Department(String name, int avgSal) {
		super();
		this.name = name;
		this.avgSal = avgSal;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAvgSal() {
		return avgSal;
	}
	public void setAvgSal(int avgSal) {
		this.avgSal = avgSal;
	}



}
