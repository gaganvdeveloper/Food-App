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

@WebServlet("/userlogin")
public class UserLoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		UserServiceImplementation service = new UserServiceImplementation();
		User user = service.verifyUserByEmailAndPassword(email, password);
		RequestDispatcher dispatcher = null;
		if (user != null) {
			HttpSession session = req.getSession();
			session.setAttribute("name", user.getName());
			session.setAttribute("role", user.getRole());
			session.setAttribute("user", user);
			if (user.getRole().equals(Role.BRANCHMANAGER)) {
				dispatcher = req.getRequestDispatcher("branchmanagerhome.jsp");
				dispatcher.forward(req, resp);
			} else if (user.getRole().equals(Role.ADMIN)) {
				dispatcher = req.getRequestDispatcher("adminhome.jsp");
				dispatcher.forward(req, resp);
			} else if (user.getRole().equals(Role.STAFF)) {
				dispatcher = req.getRequestDispatcher("staffhome.jsp");
				dispatcher.forward(req, resp);
			} else {
				dispatcher = req.getRequestDispatcher("customerhome.jsp");
				dispatcher.forward(req, resp);
			}

		} else {
			PrintWriter writer = resp.getWriter();
			writer.write("<h1 style='color:red;'>Failed To Login...</h1>");
			dispatcher = req.getRequestDispatcher("userlogin.jsp");
			dispatcher.include(req, resp);
		}

	}

}
