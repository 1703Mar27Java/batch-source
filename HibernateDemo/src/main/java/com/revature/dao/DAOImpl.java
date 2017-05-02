package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.dao.util.HibernateUtil;

import one.to.many.Bear;
import one.to.many.Beehive;
import one.to.many.Cave;

public class DAOImpl implements DAO {

	@Override
	public List<Cave> getCaves() {
		List<Cave> caves = new ArrayList<Cave>();
		Session sesh = HibernateUtil.getSession();
		caves = sesh.createQuery("from Cave").list();
		return caves;
	}

	@Override
	public List<Bear> getBears() {
		List<Bear> bears = new ArrayList<Bear>();
		Session sesh = HibernateUtil.getSession();
		bears = sesh.createQuery("from Bear").list();
		return bears;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Bear getBearByName(String bearName) {
		Bear bear = null;
		List<Bear> bears = new ArrayList<Bear>();
		Session sesh = HibernateUtil.getSession();
		bears = sesh.createQuery("from Bear where name = :namevar").
				setString("namevar",bearName).list();
		if(!bears.isEmpty()){
			bear = bears.get(0);
		}
		return bear;
	}

	@Override
	public int saveBear(Bear b) {
		Session s = HibernateUtil.getSession();
		//Transaction tx = s.beginTransaction();
		int result =  (int) s.save(b);
		//tx.commit();
		s.close();
		return result;
	}

	@Override
	public void persistBear(Bear b) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.persist(b);
		tx.commit();
		s.close();
		
	}

	@Override
	public int saveCave(Cave c) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int result =  (int) s.save(c);
		tx.commit();
		s.close();
		return result;
	}

	@Override
	public void persistCave(Cave c) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.persist(c);
		tx.commit();
		s.close();
	}

	@Override
	public int feedBear(int bId, int bhId, int honeyAmt) {
		int amtFed = 0;
	
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		Bear b = (Bear) s.get(Bear.class, bId);
		Beehive bh = (Beehive) s.get(Beehive.class, bhId);
		
		int obw = b.getWeight();
		int ohw = bh.getWeight();
		if (bh.getWeight()-honeyAmt >= 0) {
		
			b.setWeight(obw+honeyAmt);
			bh.setWeight(ohw-honeyAmt);
			s.merge(b);
			s.merge(bh);
			amtFed = honeyAmt;
			
		} else {
			b.setWeight(obw+ohw);
			bh.setWeight(0);
			s.merge(b);
			s.merge(bh);
			amtFed = ohw;
		}
		
		tx.commit();
		s.close();
		
		return amtFed;
	}

	

}
