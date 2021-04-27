package com.orgky.examples.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.orgky.examples.model.Iva;

public class IvaDAOImpl implements IvaDAO{

	private static final Logger logger = LoggerFactory.getLogger(IvaDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addIva(Iva p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Iva saved successfully, Iva Details="+p);
	}

	@Override
	public void updateIva(Iva p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Iva updated successfully, Iva Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Iva> listIvas() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Iva> ivaList = session.createQuery("from Iva").list();
		for(Iva p : ivaList){
			logger.info("Iva List::"+p);
		}
		return ivaList;
	}

	@Override
	public Iva getIvaById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Iva p = (Iva) session.load(Iva.class, Integer.valueOf(id));
		logger.info("Iva loaded successfully, Iva details="+p);
		return p;
	}

	@Override
	public void removeIva(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Iva p = (Iva) session.load(Iva.class, Integer.valueOf(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Iva deleted successfully, iva details="+p);
	}
}
