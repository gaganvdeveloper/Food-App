package com.tyss.foodapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tyss.foodapp.dto.FoodOrder;
import com.tyss.foodapp.dto.Item;
import com.tyss.foodapp.dto.User;
import com.tyss.foodapp.service.implementation.FoodOrderServiceImplementation;
import com.tyss.foodapp.service.implementation.ItemServiceImplementation;
import com.tyss.foodapp.util.Status;

@WebServlet("/createfoodorder")
public class CreateFoodOrderServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ItemServiceImplementation iservice = new ItemServiceImplementation();

		FoodOrderServiceImplementation service = new FoodOrderServiceImplementation();

		String name = req.getParameter("customerName");

		long phone = Long.parseLong(req.getParameter("customerPhoneNumber"));

		String[] iIds = req.getParameterValues("itemId");

		String status = req.getParameter("status");

		List<Item> items = iservice.findAllItems();

		System.out.println(items);
		
		List<Item> items1 = new ArrayList<>();

		for (Item i : items) {
			for (String s : iIds) {
				int uid = Integer.parseInt(s);
				
				if (uid == i.getId()) {
					System.out.println("hi");
					items1.add(i);
					System.out.println("Hello");
				}
			}
		}
		System.out.println(items1);

		FoodOrder foodOrder = new FoodOrder();
		foodOrder.setCustomerName(name);
		foodOrder.setContactNumber(phone);
		foodOrder.setItems(items1);
		foodOrder.setStatus(Status.valueOf(status));
		foodOrder.setUser((User) req.getSession(false).getAttribute("user"));
		foodOrder.setTotalPrice(service.calculateTotalFoodOrderPrice(foodOrder));

		RequestDispatcher dispatcher = null;
		PrintWriter writer = resp.getWriter();
		if (service.saveFoodOrder(foodOrder) != null) {
			writer.write("<h1>FoodOrder Created Successfully...</h1>");
			dispatcher = req.getRequestDispatcher("staffhome.jsp");
			dispatcher.include(req, resp);

		} else {
			writer.write("<h1>Unable To Create FoodOrder...</h1>");
			dispatcher = req.getRequestDispatcher("staffhome.jsp");
			dispatcher.include(req, resp);
		}

	}

}
