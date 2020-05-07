package tp12;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class CompetitorTest {
	public Competitor c1, c2, c3, c4, c5;

	@Before
	public void beforeATest() {
		Competitor.resetCpt();
		this.c1 = new Competitor("Alice", Country.FRANCE, Team.TEAM_1);
		this.c2 = new Competitor("Bruno", Country.RUSSIA, Team.TEAM_2);
		this.c3 = new Competitor("Clément", Country.FRANCE, Team.TEAM_1);
		this.c4 = new Competitor("Dora", Country.ITALY, Team.TEAM_3);
		this.c5 = new Competitor("Éloïse", Country.ITALY, Team.TEAM_2);
	}

	@Test
	public void test_getID() {
		assertEquals(0, this.c1.getID());
		assertEquals(1, this.c2.getID());
		assertEquals(2, this.c3.getID());
		assertEquals(3, this.c4.getID());
		assertEquals(4, this.c5.getID());
	}

	@Test
	public void test_toString() {
		assertEquals("0-Alice(FR) -> TEAM_1", this.c1.toString());
		assertEquals("1-Bruno(RS) -> TEAM_2", this.c2.toString());
		assertEquals("2-Clément(FR) -> TEAM_1", this.c3.toString());
		assertEquals("3-Dora(IT) -> TEAM_3", this.c4.toString());
		assertEquals("4-Éloïse(IT) -> TEAM_2", this.c5.toString());
	}

	@Test
	public void test_isFrom() {
		// using a country
		assertTrue(this.c1.isFrom(Country.FRANCE));
		assertFalse(this.c1.isFrom(Country.RUSSIA));
		// using a team
		assertTrue(this.c1.isFrom(Team.TEAM_1));
		assertFalse(this.c1.isFrom(Team.TEAM_2));
	}
}
