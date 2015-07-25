package com.jdc.res.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jdc.restaurant.entity.Category;
import com.jdc.restaurant.model.CategoryModel;
import com.jdc.restaurant.model.ConnectionManager;

public class CategoryModelTest {
	
	private CategoryModel model;
	
	@BeforeClass
	public static void initTable() {
		ConnectionManager.truncate("order_details", "menu_item", "category");
	}
	
	@Before
	public void init() {
		model = new CategoryModel();
	}

	@Test
	public void test1() {
		
		Category c = new Category();
		c.setName("Hot Drinks");
		
		int result = model.create(c);
		
		assertEquals(1, result);
	}
	
	@Test
	public void test2() {
		Category cat = model.find(1);
		
		assertNotNull(cat);
		
		assertEquals("Hot Drinks", cat.getName());
		
		assertEquals(1, cat.getId());
	}
	
	@Test
	public void test3() {
		Category c = new Category();
		c.setName("Cool Drinks");
		model.create(c);
		
		Category c1 = new Category();
		c1.setName("Snacks");
		model.create(c1);
		
		List<Category> list = model.getAll();
		assertNotNull(list);
		
		assertEquals(3, list.size());
		
	}
	

}
