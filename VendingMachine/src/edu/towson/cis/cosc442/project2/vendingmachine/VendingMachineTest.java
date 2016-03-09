package edu.towson.cis.cosc442.project2.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {

	VendingMachine vend1;
	VendingMachineItem item1, item2;
	static final double cost1 = 10;
	static final double cost2 = 20;

	@Before
	public void setUp() throws Exception {
		vend1 = new VendingMachine();

		item1 = new VendingMachineItem("Test1", cost1);
		item2 = new VendingMachineItem("Test2", cost2);

	}

	@After
	public void tearDown() throws Exception {
		vend1 = null;
		item1 = null;
		item2 = null;
	}

	@Test
	public void testAddItem() {
		vend1.addItem(item1, "A");

		try {
			vend1.addItem(item2, "A");
			fail("Expected exception");
		} catch (VendingMachineException e) {

		}

	}

	@Test
	public void testRemoveItem() {
		vend1.addItem(item1, "A");
		assertEquals(item1, vend1.removeItem("A"));
	}

	@Test
	public void testRemoveItemException() {
		try {
			vend1.removeItem("B");
			fail("Expected Exception");
		} catch (VendingMachineException e) {

		}
	}

	@Test
	public void testInsertMoney() {
		vend1.insertMoney(20);
	}

	@Test
	public void testInsertMoneyException() {
		try {
			vend1.insertMoney(-20);
			fail("Expected Exception");
		} catch (VendingMachineException e) {

		}
	}

	@Test
	public void testGetBalance() {
		vend1.insertMoney(20);
		assertEquals(20, vend1.getBalance(), .01);
	}

	@Test
	public void testGetBalanceNoMoney() {
		assertEquals(0, vend1.getBalance(), .01);
	}

	@Test
	public void testMakePurchase() {
		vend1.insertMoney(20);
		vend1.addItem(item1, "A");
		assertEquals(true, vend1.makePurchase("A"));
		assertEquals(10, vend1.getBalance(), .01);
	}

	@Test
	public void testMakePurchaseNoItem() {
		assertEquals(false, vend1.makePurchase("B"));
	}

	@Test
	public void testMakePurchaseNoMoney() {
		vend1.addItem(item2, "B");
		assertEquals(false, vend1.makePurchase("B"));
	}

	@Test
	public void testReturnChange() {
		vend1.insertMoney(20);
		assertEquals(20, vend1.returnChange(), .01);
	}

	@Test
	public void testReturnChangeNoBalance() {
		assertEquals(0, vend1.returnChange(), .01);
	}

	@Test
	public void testReturnChangeMakePurchase() {
		vend1.addItem(item1, "A");
		vend1.insertMoney(20);
		vend1.makePurchase("A");
		assertEquals(10, vend1.returnChange(), .01);
	}

}
