package com.tyss.foodapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tyss.foodapp.service.implementation.ItemServiceImplementation;

@WebServlet(value = "/deleteitem")
public class DeleteItemServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("zdxfcghjkl");
		ItemServiceImplementation service = new ItemServiceImplementation();
		int id = Integer.parseInt(req.getParameter("id"));
		RequestDispatcher dispatcher = null;
		PrintWriter writer = resp.getWriter();
		if (service.deleteItemById(id)) {
			writer.write("<h1 style='color:green;'>Item Deleted Successfully...</h1>");
//			resp.setContentType("text/html");
			dispatcher = req.getRequestDispatcher("staffhome.jsp");
			dispatcher.include(req, resp);
		} else {
			writer.write("<h3 style='color:red;'>Unable to Delete Item...</h3>");
			dispatcher = req.getRequestDispatcher("staffhome.jsp");
			dispatcher.include(req, resp);
		}
	}

}
