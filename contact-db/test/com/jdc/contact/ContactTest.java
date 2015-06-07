package com.jdc.contact;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jdc.jdbc.ConnectionManager;
import com.jdc.jdbc.Model;
import com.jdc.jdbc.Param;

public class ContactTest {

	private Model<Contact> model;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ConnectionManager.truncate(Arrays.asList("contact"));
	}

	@Before
	public void setUp() throws Exception {
		model = Model.instance(Contact.class, Contact::map);
	}

	@Test
	public void test1() {
		Contact c = new Contact();
		c.setName("Aung Aung");
		c.setMobile("098876666");
		c.setAddress("Yangon");
		
		Contact c2 = model.insert(c);
		Assert.assertEquals(1, c2.getId());
	}
	
	@Test
	public void test2() {
		Contact c = model.find(Param.instance("id", 1));
		Assert.assertEquals("Aung Aung", c.getName());
	}

	@Test
	public void test3() {
		List<Contact> list = model.find(null, null);
		Assert.assertEquals(1, list.size());
	}
	
	@Test
	public void test4() {
		List<Contact> list = model.find("name like ?", Arrays.asList("%Aung"));
		Assert.assertEquals(1, list.size());
	}
	
}
