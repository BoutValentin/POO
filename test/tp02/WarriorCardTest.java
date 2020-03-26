package tp02;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
public class WarriorCardTest {
    WarriorCard c1;
    WarriorCard c2;
    WarriorCard c3;
    WarriorCard c4;

    @BeforeClass
    public static void beforeAllTests() {System.out.println("Start test series");}
    @AfterClass
    public static void afterAllTests() {System.out.println("End test series");}
    @Before
    public void beforeATest() {
        c1 = new WarriorCard("w1", 10, 10);
        c2 = new WarriorCard("w1", 5, 5);
        c3 = new WarriorCard("w2", 20, 20);
        c4 = c1;
    }
    @After
    public void afterATest() {System.out.println("--------- end of a test---------");}
    @Test
    public void testEquals() {
        System.out.println("testEquals");
        assertTrue(c1.equals(c1));
        assertFalse(c1.equals(c2));
        assertFalse(c1.equals(c3));
        assertTrue(c1.equals(c4));
    }
    @Test
    public void testToString() {
        System.out.println("testToString");
        assertEquals("w1[S=10,A=10]", c1.toString());
        assertEquals("w2[S=20,A=20]", c3.toString());
    }

}