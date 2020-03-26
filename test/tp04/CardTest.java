package tp04;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CardTest {
	public Card c1, c2, c3, c4, c5, c6, c7;
	@Before
	public void initialization() {
		c1 = new Card(Color.HEART, Rank.TEN);
		c2 = new Card(Color.HEART, Rank.JACK);
		c3 = new Card(Color.DIAMOND, Rank.TEN);
		c4 = new Card(Color.CLUB, Rank.SEVEN);
		c5 = new Card(Color.SPADE, null);
		c6 = new Card(null, Rank.JACK);
		c7 = new Card(Color.HEART, Rank.TEN);
	}
	@Test
	public void testEqualsCard() {
		assertTrue(c1.equals(c1));
		assertFalse(c1.equals(null));
		assertFalse(c1.equals(c2));
		assertFalse(c1.equals(c3));
		assertFalse(c1.equals(c4));
		assertFalse(c1.equals(c5));
		assertFalse(c1.equals(c6));
		assertTrue(c1.equals(c7));
	}
	@Test
	public void testCompareColor() {
		assertTrue(c1.compareColor(c1) == 0);
		assertTrue(c1.compareColor(c2) == 0);
		assertTrue(c1.compareColor(c3) > 0);
		assertTrue(c1.compareColor(c4) > 0);
		assertTrue(c1.compareColor(c5) < 0);
		// impossible avec c6 (cas null non géré au niveau du getter)
		assertTrue(c1.compareColor(c7) == 0);
	}
	@Test
	public void testCompareRank() {
		assertTrue(c1.compareRanK(c1) == 0);
		assertTrue(c1.compareRanK(c2) < 0);
		assertTrue(c1.compareRanK(c3) == 0);
		assertTrue(c1.compareRanK(c4) > 0);
		// impossible avec c5 (cas null non géré au niveau du getter)
		assertTrue(c1.compareRanK(c6) < 0);
		assertTrue(c1.compareRanK(c7) == 0);
	}
}
