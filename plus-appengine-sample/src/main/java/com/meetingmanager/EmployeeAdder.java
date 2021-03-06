package com.meetingmanager;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.googlecode.objectify.ObjectifyService;

public class EmployeeAdder extends HttpServlet {
	// Process the http POST of the form
	  @Override
	  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		    //UserServiceFactory.getUserService().createLoginURL(req.getRequestURI());
		    UserService userService = UserServiceFactory.getUserService();
		    User user = userService.getCurrentUser();  // Find out who the user is.
		    
		    Employee employee;
		    employee = new Employee("alex", "radu", "asd", null);
		    

		    // Use Objectify to save the greeting and now() is used to make the call synchronously as we
		    // will immediately get a new page using redirect and we want the data to be present.
		    ObjectifyService.ofy().save().entity(employee).now();

		    resp.sendRedirect("/index.jsp");
	  }
	  
	  @Override
	  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		  

		    
	  }
	  
}
