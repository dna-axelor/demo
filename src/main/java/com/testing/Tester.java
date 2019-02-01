//package com.testing;
//
//import java.util.List;
//
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//
//import org.hibernate.SQLQuery;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.annotations.SelectBeforeUpdate;
//import org.hibernate.cfg.Configuration;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import com.google.inject.Singleton;
//
//@Path("/test")
//@Singleton
//public class Tester {
//
//	private static SessionFactory factory;
//
//	@SelectBeforeUpdate
//	public void setUp() {
//
//	}
//
//	@GET
//	@Path("/run")
//	@Produces(MediaType.TEXT_PLAIN)
//	@Test
//	public void test() {
//
//		factory = new Configuration().configure().buildSessionFactory();
//		Session session = factory.openSession();
//		String hql = "select name from DataEmp where  NOT (DataEmp IS NOT NULL)";
//		SQLQuery query = session.createSQLQuery(hql);
//
//		System.out.println(query);
//
//		if (query != null) {
//
//			System.out.println("First Name is Null.");
//		}
//	}
//
//	@After
//	public void tearDown() {
//
//	}
//
//}
