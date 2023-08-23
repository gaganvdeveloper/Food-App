package com.tyss.foodapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tyss.foodapp.dto.User;
import com.tyss.foodapp.service.implementation.UserServiceImplementation;
import com.tyss.foodapp.util.Role;

@WebServlet("/userregister")
public class UserRegisterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UserServiceImplementation service = new UserServiceImplementation();

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		Role role = Role.valueOf(req.getParameter("role"));

		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setRole(role);
		user.setPassword(password);
		User user1 = service.saveUser(user);
		RequestDispatcher dispatcher = null;
		
		if (user1 != null) {
			PrintWriter writer = resp.getWriter();
			writer.write(
					"<h1 style='color:darkgreen;'>Registration Successfull... <br><br>You Can Login Now...!!!</h1>");
			dispatcher = req.getRequestDispatcher("userlogin.jsp");
			dispatcher.forward(req, resp);
		} else {
			PrintWriter writer = resp.getWriter();
			writer.write("<h1 style='color:red;'>Fail to Register...</h1>");
			dispatcher = req.getRequestDispatcher("userregister.jsp");
			dispatcher.forward(req, resp);
		}

	}

}
