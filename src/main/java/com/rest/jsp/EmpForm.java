package com.rest.jsp;

import javax.ws.rs.FormParam;

public class EmpForm {

	@FormParam("id")
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@FormParam("name")
	private String name;
	@FormParam("company")
	private String company;

}
