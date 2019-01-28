package com.rest.jsp;

import javax.ws.rs.core.Response;

public interface DataAbstract {

	public Response saveEmp(String id, String name, String company, EmpForm form);

	public Response saveEmpForm(EmpForm form);

}
