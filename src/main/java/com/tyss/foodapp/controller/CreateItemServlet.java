package com.tyss.foodapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tyss.foodapp.dto.Item;
import com.tyss.foodapp.service.implementation.ItemServiceImplementation;
import com.tyss.foodapp.util.Type;

@WebServlet(value = "/createitem")
public class CreateItemServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ItemServiceImplementation service = new ItemServiceImplementation();

		String name = req.getParameter("name");
		String productId = req.getParameter("productId");
		Type type = Type.valueOf(req.getParameter("type"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		double price = Double.parseDouble(req.getParameter("price"));

		Item item = new Item();
		item.setName(name);
		item.setPrice(price);
		item.setQuantity(quantity);
		item.setProductId(quantity);
		item.setType(type);

		Item item1 = service.saveItem(item);

		RequestDispatcher dispatcher = null;
		if (item1 != null) {
//			dispatcher = req.getRequestDispatcher("staffhome.jsp");
//			dispatcher.forward(req, resp);
			resp.sendRedirect("staffhome.jsp");
		} else {
			resp.getWriter().write("<h1 style='color:red;'>Unable To Add Item</h1>");
			dispatcher = req.getRequestDispatcher("staffhome.jsp");
			dispatcher.include(req, resp);
		}
	}

}
