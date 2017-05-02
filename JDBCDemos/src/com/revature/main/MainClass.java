package com.revature.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.revature.dao.CaveDAOImpl;
import com.revature.domain.Cave;
import com.revature.util.ConnectionUtil;

public class MainClass {

	public static void main(String[] args) {
		
		CaveDAOImpl dao = new CaveDAOImpl();
			
			/*Connection con;
			try {
				con = ConnectionUtil.getConnectionFromFile("connection.properties");
				System.out.println(con.toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		
			
			/*Cave c = new Cave("BAT",9);
			
			dao.createCave(c);
			
			Cave d = new Cave("YELLOWSTONE",9);
			dao.createCavePS(d);*/
			
			/*List<Cave> c = dao.retrieveAllCaves();
			System.out.println(c.toString());*/
			
			dao.executeHelloWorld();
			

	}

}
