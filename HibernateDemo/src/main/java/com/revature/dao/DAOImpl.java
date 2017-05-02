package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.revature.dao.util.HibernateUtil;

import one.to.many.Bear;
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

}
