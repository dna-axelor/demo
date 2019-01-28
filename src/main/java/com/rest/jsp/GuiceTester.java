package com.rest.jsp;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.Form;
import org.jboss.resteasy.annotations.providers.jaxb.Formatted;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;

@Path("/manage")
@Singleton
public class GuiceTester {

	Injector inj = Guice.createInjector(new AppModule());
	EmployeeService emps = inj.getInstance(EmployeeService.class);

	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	@Formatted
	public Response saveEmp(@FormParam("id") String id, @FormParam("name") String name,
			@FormParam("company") String company,@Form EmpForm form ) {

		return emps.saveEmp(id, name, company,form);
	}

	@GET
	@Path("/saveform")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	@Formatted
	public Response saveEmpForm(@Form EmpForm form) {
		return emps.saveEmpForm(form);
	}

}
