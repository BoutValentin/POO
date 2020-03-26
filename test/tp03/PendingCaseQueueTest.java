package tp03;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PendingCaseQueueTest {
	public PendingCase d1 ;
	public PendingCase d2 ;
	public PendingCase d3 ;
	public PendingCase d4 ;
	public PendingCase d5 ;
	public PendingCaseQueue p1 ;
	public PendingCaseQueue p2 ;
	
	@Before
	public void testBefore() {
		d1 = new PendingCase("Michel", "Conforama", 525.02);
		d2 = new PendingCase("Andre", "Decathlon", 2.21);
		d3 = new PendingCase("Bernard", "Auchan", 5689.21);
		d4 = new PendingCase("Samuel", "Leroy Merlin", 1.21);
		d5 = new PendingCase("Philou", "Apple", 245.21);
		p1 = new PendingCaseQueue(5);
		p2 = new PendingCaseQueue(5);
		p2.addOne(d1);
		p2.addOne(d2);
		p2.addOne(d3);
		p2.addOne(d4);
		p2.addOne(d5);
	}
	@Test
	public void testClear() {
		assertFalse(this.p2.isEmpty());
		this.p2.clear();
		assertTrue(this.p1.isEmpty());
		assertTrue(this.p2.isEmpty());
	}

	@Test
	public void testIsEmpty() {
		assertTrue(p1.isEmpty());
		assertFalse(p2.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertTrue(p2.isFull());
		assertFalse(p1.isFull());	
	}

	@Test
	public void testAddOne() {
		assertTrue(p1.addOne(d1));
		assertFalse(p2.addOne(d2));
	}
	
	@Test
	public void testRemoveOne() {
		assertNull(this.p1.removeOne());
		assertEquals(d1, this.p2.removeOne());
	}

}
