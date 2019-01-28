package com.rest.jsp;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.inject.Inject;

//@Path("/manage")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public class EmployeeService {

	private final DataAbstract db;

	@Inject
	public EmployeeService(DataAbstract db) {

		this.db = db;

	}

	// @POST
	// @Path("/save")
	// @Consumes(MediaType.APPLICATION_FORM_URLENCODED)

	// @Formatted
	public Response saveEmp(String id, String name, String company, EmpForm form) {

		return db.saveEmp(id, name, company, form);
	}

	public Response saveEmpForm(EmpForm form) {

		return db.saveEmpForm(form);
	}

}
