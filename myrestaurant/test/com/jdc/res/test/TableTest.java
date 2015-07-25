package com.jdc.res.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jdc.restaurant.entity.Table;
import com.jdc.restaurant.model.ConnectionManager;
import com.jdc.restaurant.model.TableModel;

public class TableTest {
	
	private TableModel model;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ConnectionManager.truncate("order_details", "`order`", "bill", "rtable");
	}

	@Before
	public void setUp() throws Exception {
		model = new TableModel();
	}

	@Test
	public void test1() {
		Table t = new Table("Table No 1");
		int result = model.create(t);
		assertEquals(1, result);
	}
	
	@Test
	public void test2() {
		Table t = model.find(1);
		assertNotNull(t);
		assertEquals("Table No 1", t.getTableNumber());
	}
	
	@Test
	public void test3() {
		IntStream.rangeClosed(2, 10).forEach(a -> {
			Table t = new Table(String.format("Table No %d", a));
			model.create(t);
		});
		
		List<Table> list = model.getAll();
		assertNotNull(list);
		assertEquals(10, list.size());
	}

}
