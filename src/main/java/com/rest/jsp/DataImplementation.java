package com.rest.jsp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.google.inject.Singleton;
import com.rest.jsp.hibernate.EmpData;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Singleton
public class DataImplementation implements DataAbstract {

	private static SessionFactory factory;

	static Map<String, String> map = new HashMap<String, String>();

	public Response saveEmp(String id, String name, String company, EmpForm form) {

		map.put("id", id);
		map.put("name", name);
		map.put("company", company);

		EmpData emp = new EmpData();
		emp.setId(id);
		emp.setName(name);
		emp.setCompany(company);

		factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		session.beginTransaction();
		session.save(emp);
		session.getTransaction().commit();

		session.close();

		return Response.ok().entity("Data Added Successfully.").build();
	}

	public Response saveEmpForm(EmpForm form) {

		// map.put("id", form.getId());
		// map.put("name", form.getName());
		// map.put("company", form.getCompany());
		// System.out.println(map);
		// System.out.println(form.getId());

		factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "from EmpData";
		Query query = session.createQuery(hql);
		List<EmpData> hq = (List<EmpData>) query.getResultList();

		return Response.ok(hq).build();
	}
}
