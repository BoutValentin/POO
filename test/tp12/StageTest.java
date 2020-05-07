package tp12;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class StageTest {
	private Competitor c0, c1, c2, c3, c4;
	private Stage s0, s1, s2, s3, s4;

	@Before
	public void beforeATest() {
		Competitor.resetCpt();
		this.c0 = new Competitor("Alice", Country.FRANCE, Team.TEAM_1);
		this.c1 = new Competitor("Bruno", Country.RUSSIA, Team.TEAM_2);
		this.c2 = new Competitor("Clément", Country.FRANCE, Team.TEAM_1);
		this.c3 = new Competitor("Dora", Country.ITALY, Team.TEAM_3);
		this.c4 = new Competitor("Éloïse", Country.ITALY, Team.TEAM_2);

		Stage.resetCpt();
		this.s0 = new SkiingStage(1000);
		this.s1 = new ShootingStage(5);
		this.s2 = new SkiingStage(2000);
		this.s3 = new ShootingStage(10);
		this.s4 = new SkiingStage(500);

		boolean result = false;
		try {
			this.s0.record(this.c0, 100); this.s0.record(this.c1, 100);
			this.s1.record(this.c0, 0); this.s1.record(this.c1, 3);
			this.s2.record(this.c0, 200);
			this.s3.record(this.c0, 1);
			this.s4.record(this.c0, 50);
		} catch(Exception_InvalidRecord e) {
			result = true;
		}
		assertFalse(result);
	}

	@Test
	public void test_getID() {
		assertEquals(0, this.s0.getID());
		assertEquals(1, this.s1.getID());
		assertEquals(2, this.s2.getID());
		assertEquals(3, this.s3.getID());
		assertEquals(4, this.s4.getID());
	}

	@Test
	public void test_getType() {
		assertEquals("Skiing", this.s0.getType());
		assertEquals("Shooting", this.s1.getType());
		assertEquals("Skiing", this.s2.getType());
		assertEquals("Shooting", this.s3.getType());
		assertEquals("Skiing", this.s4.getType());
	}

	@Test
	public void test_getNbShots() {
		assertEquals(0, this.s0.getNbShots());
		assertEquals(5, this.s1.getNbShots());
		assertEquals(0, this.s2.getNbShots());
		assertEquals(10, this.s3.getNbShots());
		assertEquals(0, this.s4.getNbShots());
	}

	@Test
	public void test_getLength() {
		assertEquals(1000, this.s0.getLength());
		assertEquals(0, this.s1.getLength());
		assertEquals(2000, this.s2.getLength());
		assertEquals(0, this.s3.getLength());
		assertEquals(500, this.s4.getLength());
	}

	@Test
	public void test_clear() {
		assertFalse(this.s0.results.size()==0);
		this.s0.clear();
		assertTrue(this.s0.results.size()==0);
	}

	@Test
	public void test_record() {
		// without exception
		assertEquals(2, this.s0.getNbRecord());
		assertEquals(2, this.s1.getNbRecord());
		assertEquals(1, this.s2.getNbRecord());
		assertEquals(1, this.s3.getNbRecord());
		assertEquals(1, this.s4.getNbRecord());
		// with Exception_InvalidRecord
		boolean result = false;
		try {
			this.s0.record(this.c0, 100);
		} catch(Exception_InvalidRecord e) {
			result = true;
		}
		assertTrue(result);
	}

	@Test
	public void test_getScore() {
		// without exception
		boolean result = false;
		try {
			assertEquals(100, this.s0.getScore(this.c0));
			assertEquals(0, this.s1.getScore(this.c0));
			assertEquals(100, this.s0.getScore(this.c1));
			assertEquals(3*10, this.s1.getScore(this.c1));
			List<Competitor> tmp = new ArrayList<Competitor>();
			tmp.add(this.c0); tmp.add(this.c1);
			assertEquals(200, this.s0.getScore(tmp));
		} catch(Exception_NoResult e) {
			result = true;
		}
		assertFalse(result);
		// with Exception_NoResult
		// a competitor alone
		result = false;
		try {
			this.s0.getScore(this.c4);
		} catch(Exception_NoResult e) {
			result = true;
		}
		assertTrue(result);
		// with Exception_NoResult
		// a list of nonexistant competitor only
		result = false;
		List<Competitor> tmp = new ArrayList<Competitor>();
		tmp.add(this.c2); tmp.add(this.c3);
		try {
			this.s0.getScore(tmp);
		} catch(Exception_NoResult e) {
			result = true;
		}
		assertTrue(result);
		// with Exception_NoResult
		// a mixed list
		result = false;
		tmp = new ArrayList<Competitor>();
		tmp.add(this.c0); tmp.add(this.c1); tmp.add(this.c3);
		try {
			this.s0.getScore(tmp);
		} catch(Exception_NoResult e) {
			result = true;
		}
		assertTrue(result);
	}
}
