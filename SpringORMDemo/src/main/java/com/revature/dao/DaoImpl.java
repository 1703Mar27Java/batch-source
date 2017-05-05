package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Bear;
import com.revature.beans.Cave;

@Transactional
public class DaoImpl implements Dao {
	
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Bear> getBears() {
		Session s = sessionFactory.getCurrentSession();
		List<Bear> bears = new ArrayList<Bear>();
		bears = s.createQuery("from Bear").list();
		return bears;
	}

	@Override
	public List<Cave> getCaves() {
		Session s = sessionFactory.getCurrentSession();
		List<Cave> caves = new ArrayList<Cave>();
		caves = s.createQuery("from Cave").list();
		return caves;
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void makeBear(Bear bear) {
		Session s = sessionFactory.getCurrentSession();
		s.saveOrUpdate(bear.getCave());
		s.save(bear);
	}
	
	

}
