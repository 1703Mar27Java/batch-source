package one.to.many;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.dao.*;
import com.revature.dao.util.HibernateUtil;

public class MainClass {

	public static void main(String[] args) {

		DAO dao = new DAOImpl();
		//List<Cave> allCaves = dao.getCaves();
		//System.out.println(allCaves);
		//List<Bear> allBears = dao.getBears();
		//System.out.println(allBears);
		//System.out.println(allBears.get(3).getCave());
		System.out.println(dao.getBearByName("Baloo"));

	}
	
	static void init(){
		Session session  = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		/*create transient objects*/
		
		Cave c1 = new Cave("Howe Caverns");
		Cave c2 = new Cave("tempusercave2");
		Bear b1 = new Bear("Yogi",c1);
		Bear b2 = new Bear("Beets",c1);
		Bear b3 = new Bear("Baloo",c1);
		
		Bear b4 = new Bear("Beartlestar Galactibear",c2);
		Bear b5 = new Bear("Bear Trek",c2);
		Bear b6 = new Bear("Bear Bears",c2);
		
		/*save objects*/
		
		session.save(c1);
		session.save(c2);
		
		session.save(b1);
		session.save(b2);
		session.save(b3);
		session.save(b4);
		session.save(b5);
		session.save(b6);
		
		/*commit and close session*/
		
		tx.commit();
		session.close();
	}

}
