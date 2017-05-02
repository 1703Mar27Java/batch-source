package one.to.many;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.revature.dao.*;
import com.revature.dao.util.HibernateUtil;

public class MainClass {

	public static void main(String[] args) {

		DAO dao = new DAOImpl();

		// List<Cave> allCaves = dao.getCaves();
		// System.out.println(allCaves);
		// List<Bear> allBears = dao.getBears();
		// System.out.println(allBears);
		// System.out.println(allBears.get(3).getCave());
		// System.out.println(dao.getBearByName("Baloo"));
		Bear getBear = getBearExample(200);
		if (getBear != null) {
		System.out.println(getBear.getName());}
		Bear loadBear = loadBearExample(200);
		System.out.println(loadBear.getId());
		if (loadBear != null) {
			System.out.println(loadBear.getName());}
	}

	static Bear getBearExample(int id) {
		Session session = HibernateUtil.getSession();
		Bear b = (Bear) session.get(Bear.class, id);
		session.close();
		return b;
	}
	static Bear loadBearExample(int id) {
		Session session = HibernateUtil.getSession();
		Bear b = (Bear) session.load(Bear.class, id);
		//System.out.println(b); //this forces the proxies to ACTUALLY load
		session.close();
		return b;
	}

	static void useCriteria() {
		Session session = HibernateUtil.getSession();
		List yogiBears = session.createCriteria(Bear.class).add(Restrictions.like("name", "Y%")).list();
		System.out.println(yogiBears);

		List mediumBears = session.createCriteria(Bear.class).add(Restrictions.between("weight", 200, 800))
				.addOrder(Order.asc("weight")).list();
		System.out.println(mediumBears);

		Criteria cr = session.createCriteria(Bear.class);
		cr.setProjection(Projections.rowCount());
		List rowCount = cr.list();
		System.out.println("number of bears: " + rowCount.get(0));

		Criteria hw = session.createCriteria(Beehive.class);
		hw.setProjection(Projections.sum("weight"));
		List totalHoney = hw.list();
		System.out.println("available pounds of honey: " + totalHoney.get(0));

		session.close();
	}

	static void execNamedQuery() {
		Session session = HibernateUtil.getSession();
		Query query = session.getNamedQuery("findBearByName");
		query.setString("namevar", "Baloo");
		List<Bear> bears = query.list();
		System.out.println(bears.size());
		Iterator<Bear> itr = bears.iterator();
		while (itr.hasNext()) {
			Bear b = itr.next();
			System.out.println(b);
		}
		session.close();
	}

	static void maxWeightInCave() {
		Session session = HibernateUtil.getSession();

		List results = session.createQuery("select bear.cave, max(bear.weight) from Bear bear " + "group by bear.cave")
				.list();
		while (results.iterator().hasNext()) {
			System.out.println(results.iterator().next());

		}

		session.close();
	}

	static void init() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		/* create transient objects */

		Cave c1 = new Cave("Howe Caverns");
		Cave c2 = new Cave("tempusercave2");
		Bear b1 = new Bear("Yogi", 400, c1);
		Bear b2 = new Bear("Beets", 500, c1);
		Bear b3 = new Bear("Baloo", 1000, c1);

		Bear b4 = new Bear("Beartlestar Galactibear", 20, c2);
		Bear b5 = new Bear("Bear Trek", 150, c2);
		Bear b6 = new Bear("Bear Bears", 400, c2);
		Bear b7 = new Bear("Beary McBearface", 100, c2);

		Beehive bh1 = new Beehive(150);
		Beehive bh2 = new Beehive(300);

		/* save objects */

		session.save(c1);
		session.save(c2);

		session.save(b1);
		session.save(b2);
		session.save(b3);
		session.save(b4);
		session.save(b5);
		session.save(b6);
		session.save(b7);

		session.save(bh1);
		session.save(bh2);

		/* commit and close session */

		tx.commit();
		session.close();
	}

}
