package com.jdc.restaurant.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.jdc.restaurant.model.Bill;
import com.jdc.restaurant.model.Order;
import com.jdc.restaurant.model.OrderDetails;
import com.jdc.restaurant.model.Table;

public class OrderService {

	public void checkOut(Table table) {

		// find active bill for table
		Bill b = getActiveBill(table);

		// if there is active bill
		if (null != b) {

			Bill.getModel().update(
					"status=?, modification = ?",
					"id=?",
					Arrays.asList(1, Timestamp.valueOf(LocalDateTime.now()),
							b.getId()));
		}

	}

	public List<OrderDetails> getOrdersForTable(Table table) {

		// find active bill for table
		Bill b = getActiveBill(table);

		// if there is active bill
		if (null != b) {
			return this.getOrdersForBill(b);
		}

		return new ArrayList<>();
	}

	public void doOrder(Table table, List<OrderDetails> details) {

		// find active bill for table
		Bill b = getActiveBill(table);

		// if not active active -> create bill
		if (null == b) {
			Bill.getModel().create(new Bill(table));

			b = getActiveBill(table);
		}

		// create order
		Order.getModel().create(new Order(b));
		List<Order> od = Order.getModel().getWhere(
				"bill_id = ? order by od_time desc", Arrays.asList(b.getId()));

		// create order detils
		if (od.size() > 0) {
			Order o = od.get(0);

			for (OrderDetails d : details) {
				d.setOrder(o);
				OrderDetails.getModel().create(d);
			}
		}

		// update bill
		List<OrderDetails> detailsList = getOrdersForBill(b);

		int subTotal = detailsList.stream()
				.mapToInt(a -> a.getCount() * a.getMenu().getPrice()).sum();
		double tax = subTotal * 0.05;
		double total = subTotal + tax;

		Bill.getModel().update("sub_total = ?, tax = ?, total = ?", "id = ?",
				Arrays.asList(subTotal, tax, total, b.getId()));
	}

	public List<OrderDetails> getOrdersForBill(Bill b) {
		List<OrderDetails> result = new ArrayList<>();
		// find orders for bill
		List<Order> orders = Order.getModel().getWhere("bill_id = ?",
				Arrays.asList(b.getId()));

		// find all orders
		for (Order od : orders) {
			result.addAll(OrderDetails.getModel().getWhere("order_id = ?",
					Arrays.asList(od.getId())));
		}
		return result;
	}

	private Bill getActiveBill(Table table) {
		// find active bill for table
		List<Bill> bills = Bill.getModel()
				.getWhere("rtable_id = ? and status = ?",
						Arrays.asList(table.getId(), 0));

		for (Bill b : bills)
			return b;

		return null;
	}

}
