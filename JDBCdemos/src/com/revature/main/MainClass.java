package com.revature.main;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.dao.CaveDAOImpl;
import com.revature.domain.Cave;
import com.revature.util.ConnectionUtil;

public class MainClass {

	public static void main(String[] args) {
	
		/*Connection con=	ConnectionUtil.getConnection();
		System.out.println(con.toString());*/
			
			/*Cave c=new Cave(7,"Mammoth",9);
			CaveDAOImpl dao=new CaveDAOImpl();
			dao.createCave(c);*/
		

		Cave c=new Cave("BAT",9);
		c=new Cave(8,"YELLOWSTONE",9);
		CaveDAOImpl dao=new CaveDAOImpl();
		dao.updateCave(c);
		
		/*Cave d=new Cave("YELLOWSTONE",9);
		dao.createCavePS(d);*/
		
		
		
		

	}

}
