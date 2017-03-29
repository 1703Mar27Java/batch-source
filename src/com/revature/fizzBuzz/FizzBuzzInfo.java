package com.revature.fizzBuzz;

import java.io.Serializable;

public class FizzBuzzInfo implements Serializable{

	/**
	 * 
	 */
	private int[] stats;
	private String output;
	private static final long serialVersionUID = 393477062406249024L;
	public FizzBuzzInfo(String info,int...stats){
		this.stats = new int[4];
		if(stats.length>3){
		for(int i = 0; i<4;++i)
		{
			this.stats[i]=stats[i];
			output = info;
		}}
	}
	public int[] getStats() {
		return stats;
	}
	public void setStats(int[] stats) {
		this.stats = stats;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
