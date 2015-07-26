package com.jdc.res.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jdc.restaurant.model.BaseModel.Param;
import com.jdc.restaurant.model.Category;
import com.jdc.restaurant.model.ConnectionManager;
import com.jdc.restaurant.model.MenuItem;
import com.jdc.restaurant.model.Model;

public class MenuItemTest {
	
	private Model<MenuItem> model;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ConnectionManager.truncate("order_details", "menu_item", "category");
		
		Model<Category> catModel = Category.getModel();
		
		List<Category> list = Arrays.asList(
				new Category("Hot Drinks"),
				new Category("Cool Drinks"),
				new Category("Noodle"),
				new Category("Snacks")
				);
		
		for(Category c : list) {
			catModel.create(c);
		}
	}

	@Before
	public void setUp() throws Exception {
		model = MenuItem.getModel();
	}

	@Test
	public void test1() {
		
		MenuItem m = new MenuItem("Coffee", 350, 1);
		
		int result = model.create(m);
		assertEquals(1, result);
	}
	
	@Test
	public void test2() {
		MenuItem item = model.find(Param.param("id", 1));
		assertNotNull(item);
		assertEquals("Coffee", item.getMenu());
		assertEquals(350, item.getPrice());
		assertEquals(1, item.getId());
		assertEquals(1, item.getCategory_id());
	}
	
	@Test
	public void test3() {
		
		List<MenuItem> list = Arrays.asList(
				new MenuItem("Tea", 300, 1),
				new MenuItem("Coca Colla", 700, 2),
				new MenuItem("Marinda", 300, 2),
				new MenuItem("Kyaoh", 3000, 3),
				new MenuItem("Sartae", 2000, 4)
				);
		
		list.forEach(model::create);
		
		List<MenuItem> items = model.getAll();
		assertNotNull(items);
		assertEquals(6, items.size());
		
	}

	@Test
	public void test4() {
		Category cat = Category.getModel().find(Param.param("id", 1));
		
		List<MenuItem> list = model.getWhere("category_id = ?", Arrays.asList(cat.getId()));
		
		assertEquals(2, list.size());
	}
	
	@Test
	public void test5() {
		List<MenuItem> list = model.getWhere("menu = ?", Arrays.asList("Tea"));
		assertNotNull(list);
		
		assertEquals(1, list.size());
	}

}
