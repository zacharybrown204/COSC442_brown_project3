package edu.towson.cis.cosc442.project2.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineItemTest {
	
	public VendingMachineItem item1;
	public VendingMachineItem item2;

	@Before
	public void setUp() throws Exception {
		item1 = new VendingMachineItem("Test1", 20);
	}

	@After
	public void tearDown() throws Exception {
		item1 = null;
		item2 = null;
	}

	@Test
	public void testVendingMachineItem() {
		try {
			item2 = new VendingMachineItem("Test2", -20);
			fail("Constructor should throw an exception");
		} catch (VendingMachineException e) {
			
		}
	}

	@Test
	public void testGetName() {
		assertEquals("Test1", item1.getName());
	}

	@Test
	public void testGetPrice() {
		assertEquals(20, item1.getPrice(), .001);
	}

}
