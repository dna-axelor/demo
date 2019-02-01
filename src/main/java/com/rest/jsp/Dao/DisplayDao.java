package com.rest.jsp.Dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rest.jsp.hibernate.EmpData;

public class DisplayDao {

	private static SessionFactory factory;

	public void hello() {
		System.out.println("Hello");
	}

	public List<EmpData> Display() {

		factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "from EmpData";
		Query query = session.createQuery(hql);
		List<EmpData> hq = (List<EmpData>) query.getResultList();

		return hq;
	}

	public boolean delete(String id) {
		factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Query query = session.createQuery("delete EmpData where id = :id");
		query.setParameter("id", id);
		session.beginTransaction();
		query.executeUpdate();
		session.getTransaction().commit();
		return true;
	}

	public List<EmpData> get(String id) {
		factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "select * from DataEmp where id = :id";
		SQLQuery query = session.createNativeQuery(hql);
		query.addEntity(EmpData.class);
		query.setParameter("id", id);

		List results = query.list();

		return results;
	}

	public boolean update(String id, String name, String company) {

		factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "update DataEmp SET name = :name,company = :company where id = :id";
		Query query = session.createNativeQuery(hql);
		query.setParameter("id", id);
		query.setParameter("name", name);
		query.setParameter("company", company);

		session.beginTransaction();
		query.executeUpdate();
		session.getTransaction().commit();
		return true;
	}

}
