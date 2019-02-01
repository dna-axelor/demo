package com.rest.jsp;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Singleton;
//import com.testing.Tester;

@Singleton
public class AppModule implements Module {

	@Override
	public void configure(Binder binder) {
		//binder.bind(Tester.class);
		binder.bind(GuiceTester.class);
		binder.bind(EmployeeService.class);
		binder.bind(DataAbstract.class).to(DataImplementation.class);
}

	// private Set<Object> singletons = new HashSet<Object>();
	//
	// public AppModule() {
	//
	// singletons.add(new EmployeeService());
	//
	// }
	//
	// @Override
	// public Set<Object> getSingletons() {
	// return singletons;
	// }

}
