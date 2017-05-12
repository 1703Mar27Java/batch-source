package com.revature.main;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.revature.client.ForestClient;
import com.revature.model.Cave;

public class Driver {

	public static void main(String[] args) {

		ForestClient fc = new ForestClient();
		/*System.out.println(fc.getCaveByName("tempusercave2"));
		System.out.println(fc.getCaves());
		*/
		Cave c = new Cave("Bedrock2");
		System.out.println(fc.saveCave(c));
		
		ArrayList<Cave> caves = fc.getCaves();
		System.out.println(caves);
		
		

	}

}
