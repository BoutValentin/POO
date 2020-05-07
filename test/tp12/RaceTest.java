package tp12;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class RaceTest {
	private Competitor c0, c1, c2, c3, c4;
	private Stage s0, s1, s2, s3, s4;
	private Race r0, r1;

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

		this.r0 = new Race("xxx");
		this.r0.addCompetitor(this.c0);
		this.r0.addCompetitor(this.c1);
		this.r0.addCompetitor(this.c2);
		this.r0.addCompetitor(this.c3);
		this.r0.addStage(this.s0);
		this.r0.addStage(this.s1);
		this.r0.addStage(this.s2);
		this.r0.addStage(this.s3);

		this.r1 = new Race("zzz");

		try {
			this.r0.record(this.c0, this.s0, 100);
			this.r0.record(this.c1, this.s0, 100);
			this.r0.record(this.c2, this.s0, 110);
			this.r0.record(this.c3, this.s0, 120);
			this.r0.record(this.c0, this.s1, 0);
			this.r0.record(this.c1, this.s1, 3);
			this.r0.record(this.c2, this.s1, 1);
			this.r0.record(this.c3, this.s1, 4);
			this.r0.record(this.c0, this.s2, 200);
			this.r0.record(this.c1, this.s2, 220);
			this.r0.record(this.c2, this.s2, 180);
			this.r0.record(this.c3, this.s2, 240);
			this.r0.record(this.c0, this.s3, 1);
			this.r0.record(this.c1, this.s3, 2);
			this.r0.record(this.c2, this.s3, 0);
			this.r0.record(this.c3, this.s3, 1);
		} catch(Exception e) {}
	}

	@Test
	public void test_getCompetitor() {
		// without exception
		boolean result = false;
		try {
			assertEquals(this.c0, this.r0.getCompetitor(0));
			assertEquals(this.c1, this.r0.getCompetitor(1));
		} catch(Exception e) {
			result = true;
		}
		assertFalse(result);
		// with Exception_UnknownCompetitor
		result = false;
		try {
			this.r0.getCompetitor(4);
		} catch(Exception_UnknownCompetitor e) {
			result = true;
		}
		assertTrue(result);
	}

	@Test
	public void test_getNbCompetitors() {
		assertEquals(4, this.r0.getNbCompetitors());
		this.r0.addCompetitor(this.c4);
		assertEquals(5, this.r0.getNbCompetitors());
	}

	@Test
	public void test_getNbTeams() {
		assertEquals(3, this.r0.getNbTeams());
		assertEquals(0, this.r1.getNbTeams());
		this.r1.addCompetitor(this.c0);
		assertEquals(1, this.r1.getNbTeams());
	}

	@Test
	public void test_getNbCountries() {
		assertEquals(3, this.r0.getNbCountries());
		assertEquals(0, this.r1.getNbCountries());
		this.r1.addCompetitor(this.c0);
		assertEquals(1, this.r1.getNbCountries());
	}

	@Test
	public void test_getTotalNbShots() {
		assertEquals(15, this.r0.getTotalNbShots());
		assertEquals(0, this.r1.getTotalNbShots());
		this.r1.addStage(this.s1);
		assertEquals(5, this.r1.getTotalNbShots());
	}

	@Test
	public void test_getTotalLength() {
		assertEquals(3000, this.r0.getTotalLength());
		assertEquals(0, this.r1.getTotalLength());
		this.r1.addStage(this.s0);
		assertEquals(1000, this.r1.getTotalLength());
	}

	@Test
	public void test_isValid() {
		boolean result = false;
		// -- without exception
		try {
			this.r0.isValid(this.c0);
			this.r0.isValid(0);
		} catch(Exception_UnknownCompetitor e) {
			result = true;
		}
		assertFalse(result);
		// -- with exception using Competitor
		try {
			this.r0.isValid(this.c4);
		} catch(Exception_UnknownCompetitor e) {
			result = true;
		}
		assertTrue(result);
		// -- with exception using id number
		result = false;
		try {
			this.r0.isValid(4);
		} catch(Exception_UnknownCompetitor e) {
			result = true;
		}
		assertTrue(result);
	}

	@Test
	public void test_record() {
		boolean result = false;
		// without exception
		try {
			this.r1.addCompetitor(this.c0);
			this.r1.addStage(this.s4);
			this.r1.record(this.c0, this.s4, 10);
		} catch(Exception_UnknownCompetitor | Exception_InvalidRecord e) {
			result = true;
		}
		assertFalse(result);
		// with Exception_InvalidRecord
		try {
			this.r1.record(this.c0, this.s0, 100);
		} catch(Exception_UnknownCompetitor e) {
		} catch(Exception_InvalidRecord e) {
			result = true;
		}
		assertTrue(result);
		result = false;
		// with Exception_UnknownCompetitor
		try {
			this.r0.record(this.c4, this.s0, 50);
		} catch(Exception_InvalidRecord e) {
		} catch(Exception_UnknownCompetitor e) {
			result = true;
		}
		assertTrue(result);
	}

	@Test
	public void test_getScore() {
		boolean result = false;
		// without exception
		try {
			assertEquals(100, this.r0.getScore(this.c0, this.s0));
			assertEquals(100, this.r0.getScore(0, 0));
		} catch(Exception_UnknownCompetitor | Exception_NoResult e) {
			result = true;
		}
		assertFalse(result);
		// with Exception_NoResult -- using Competitor, not ID
		this.r1.addCompetitor(this.c4);
		this.r1.addStage(this.s0);
		result = false;
		try {
			this.r1.getScore(this.c4, this.s0);
		} catch(Exception_UnknownCompetitor e) {
		} catch(Exception_NoResult e) {
			result = true;
		}
		assertTrue(result);
		// with Exception_NoResult -- using ID, not Competitor
		result = false;
		try {
			this.r1.getScore(4, 0);
		} catch(Exception_UnknownCompetitor e) {
		} catch(Exception_NoResult e) {
			result = true;
		}
		assertTrue(result);
		// with Exception_UnknownCompetitor -- using Competitor, not ID
		result = false;
		try {
			this.r0.getScore(this.c4, this.s0);
		} catch(Exception_NoResult e) {
		} catch(Exception_UnknownCompetitor e) {
			result = true;
		}
		assertTrue(result);
		// with Exception_UnknownCompetitor -- using ID, not Competitor
		result = false;
		try {
			this.r0.getScore(4, 0);
		} catch(Exception_NoResult e) {
		} catch(Exception_UnknownCompetitor e) {
			result = true;
		}
		assertTrue(result);
	}

	@Test
	public void test_getCompetitorScore() {
		assertEquals(310, this.r0.getCompetitorScore(this.c0));
		assertEquals(370, this.r0.getCompetitorScore(this.c1));
		assertEquals(300, this.r0.getCompetitorScore(this.c2));
		assertEquals(410, this.r0.getCompetitorScore(this.c3));
		assertEquals(0, this.r0.getCompetitorScore(this.c4));
	}

	@Test
	public void test_getCountryScore() {
		assertEquals(610.0/2, this.r0.getCountryScore(Country.FRANCE), 0.001);
		assertEquals(370.0/1, this.r0.getCountryScore(Country.RUSSIA), 0.001);
		assertEquals(410.0/1, this.r0.getCountryScore(Country.ITALY), 0.001);
		assertEquals(Double.MAX_VALUE, this.r0.getCountryScore(Country.AUSTRIA), 0.001);
	}

	@Test
	public void test_getTeamScore() {
		assertEquals(610.0/2, this.r0.getTeamScore(Team.TEAM_1), 0.001);
		assertEquals(370.0/1, this.r0.getTeamScore(Team.TEAM_2), 0.001);
		assertEquals(410.0/1, this.r0.getTeamScore(Team.TEAM_3), 0.001);
	}

	/*@Test
	public void test_competitorRanking() {
		List<Competitor> expected = new ArrayList<Competitor>();
		expected.add(this.c2);
		expected.add(this.c0);
		expected.add(this.c1);
		expected.add(this.c3);
		List<Competitor> result = this.r0.competitorRanking();
		assertEquals(expected, result);
	}

	@Test
	public void test_countryRanking() {
		List<Country> expected = new ArrayList<Country>();
		expected.add(Country.FRANCE);
		expected.add(Country.RUSSIA);
		expected.add(Country.ITALY);
		expected.add(Country.AUSTRIA);
		expected.add(Country.SWEDEN);
		expected.add(Country.GERMANY);
		List<Country> result = this.r0.countryRanking();
		assertEquals(expected, result);
	}

	@Test
	public void test_teamRanking() {
		List<Team> expected = new ArrayList<Team>();
		expected.add(Team.TEAM_1);
		expected.add(Team.TEAM_2);
		expected.add(Team.TEAM_3);
		List<Team> result = this.r0.teamRanking();
		assertEquals(expected, result);
	}

	@Test
	public void test_deserterSet() {
		this.r1.clearResult();
		// empty deserterSet -- no competitor
		Set<Competitor> expected = new HashSet<Competitor>();
		this.r1.addStage(this.s0);
		this.r1.addStage(this.s1);
		this.r1.clearResult();
		Set<Competitor> result = this.r1.deserterSet();
		assertEquals(expected, result);
		// empty deserterSet -- one competitor
		this.r1.addCompetitor(this.c0);
		try {
			this.r1.record(this.c0, this.s0, 10);
			this.r1.record(this.c0, this.s1, 10);
		} catch(Exception e) {}
		result = this.r1.deserterSet();
		assertEquals(expected, result);
		// one deserter -- all stages missing
		expected.add(this.c1);
		this.r1.addCompetitor(this.c1);
		result = this.r1.deserterSet();
		assertEquals(expected, result);
		// two deserter -- the first stage missing
		expected.add(this.c2);
		this.r1.addCompetitor(this.c2);
		try {
			this.r1.record(this.c2, this.s1, 10);
		} catch(Exception e) {}
		result = this.r1.deserterSet();
		assertEquals(expected, result);
		// three deserter -- a stage missing (anywhere else)
		expected.add(this.c3);
		this.r1.addCompetitor(this.c3);
		try {
			this.r1.record(this.c3, this.s0, 10);
		} catch(Exception e) {}
		result = this.r1.deserterSet();
		assertEquals(expected, result);
	}*/
}
