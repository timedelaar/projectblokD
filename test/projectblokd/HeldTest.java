/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.util.Iterator;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Tim
 */
public class HeldTest {
    
    private Held held;
    private Veld huidigVeld;
    private Veld buur;
    
    public HeldTest () {
    }

    @BeforeClass
    public static void setUpClass () throws Exception {
    }

    @AfterClass
    public static void tearDownClass () throws Exception {
    }
    
    @Before
    public void setUp () {
        held = new Held();
        huidigVeld = new Veld();
        buur = new Veld();
    }
    
    @After
    public void tearDown () {
    }

    /**
     * Test of verplaats method, of class Held.
     */
    @Test
    public void testVerplaats_Oost () {
        huidigVeld.addSpelItem(held);
        Richtingen richting = Richtingen.EAST;
        huidigVeld.setNeighbour(richting, buur);
        held.verplaats(richting);
        assertTrue(!huidigVeld.hasHeld());
        assertTrue(buur.hasHeld());
    }
    
    /**
     * Test of verplaats method, of class Held.
     */
    @Test
    public void testVerplaats_West () {
        huidigVeld.addSpelItem(held);
        Richtingen richting = Richtingen.WEST;
        huidigVeld.setNeighbour(richting, buur);
        held.verplaats(richting);
        assertTrue(!huidigVeld.hasHeld());
        assertTrue(buur.hasHeld());
    }
    
    /**
     * Test of verplaats method, of class Held.
     */
    @Test
    public void testVerplaats_Noord () {
        huidigVeld.addSpelItem(held);
        Richtingen richting = Richtingen.NORTH;
        huidigVeld.setNeighbour(richting, buur);
        held.verplaats(richting);
        assertTrue(!huidigVeld.hasHeld());
        assertTrue(buur.hasHeld());
    }
    
    /**
     * Test of verplaats method, of class Held.
     */
    @Test
    public void testVerplaats_Zuid () {
        huidigVeld.addSpelItem(held);
        Richtingen richting = Richtingen.SOUTH;
        huidigVeld.setNeighbour(richting, buur);
        held.verplaats(richting);
        assertTrue(!huidigVeld.hasHeld());
        assertTrue(buur.hasHeld());
    }
    
    /**
     * Test of verplaats method, of class Held.
     */
    @Test
    public void testVerplaats2 () {
        huidigVeld.addSpelItem(held);
        SpelItem item = new ZwakkeMuur();
        buur.addSpelItem(item);
        Richtingen richting = Richtingen.NORTH;
        huidigVeld.setNeighbour(Richtingen.NORTH, buur);
        held.verplaats(richting);
        assertTrue(huidigVeld.hasHeld());
        assertTrue(!buur.kanVerplaatsen(held));
    }
    
    /**
     * Test of verplaats method, of class Held.
     */
    @Test
    public void testVerplaats3 () {
        huidigVeld.addSpelItem(held);
        SpelItem item = new Bazooka();
        buur.addSpelItem(item);
        Richtingen richting = Richtingen.WEST;
        huidigVeld.setNeighbour(richting, buur);
        held.verplaats(richting);
        assertTrue(!huidigVeld.hasHeld());
        assertTrue(buur.hasHeld());
    }
    
    /**
     * Test of verplaats method, of class Held.
     */
    @Test
    public void testVerplaats4 () {
        huidigVeld.addSpelItem(held);
        SpelItem item = new Water();
        buur.addSpelItem(item);
        Richtingen richting = Richtingen.SOUTH;
        huidigVeld.setNeighbour(richting, buur);
        held.verplaats(richting);
        assertTrue(huidigVeld.hasHeld());
        assertTrue(!buur.hasHeld());
    }
    
    /**
     * Test of verplaats method, of class Held.
     */
    @Test
    public void testVerplaats5 () {
        huidigVeld.addSpelItem(held);
        held.addBoot(new Boot());
        SpelItem item = new Water();
        buur.addSpelItem(item);
        Richtingen richting = Richtingen.SOUTH;
        huidigVeld.setNeighbour(richting, buur);
        held.verplaats(richting);
        assertTrue(!huidigVeld.hasHeld());
        assertTrue(buur.hasHeld());
    }

    /**
     * Test of addBazooka method, of class Held.
     */
    @Test
    public void testAddHasBazooka () {
        Bazooka bazooka = new Bazooka();
        held.addBazooka(bazooka);
        boolean expResult = true;
        boolean result = held.hasBazooka();
        assertEquals(expResult, result);
    }

    /**
     * Test of addBazooka method, of class Held.
     */
    @Test
    public void testAddHasBazooka2 () {
        boolean expResult = false;
        boolean result = held.hasBazooka();
        assertEquals(expResult, result);
    }

    /**
     * Test of addBoot method, of class Held.
     */
    @Test
    public void testAddHasBoot () {
        Boot boot = new Boot();
        held.addBoot(boot);
        boolean expResult = true;
        boolean result = held.hasBoot();
        assertEquals(expResult, result);
    }

    /**
     * Test of addBoot method, of class Held.
     */
    @Test
    public void testAddHasBoot2 () {
        boolean expResult = false;
        boolean result = held.hasBoot();
        assertEquals(expResult, result);
    }

    /**
     * Test of kanVerplaatsen method, of class Held.
     */
    @Test
    public void testKanVerplaatsen_Held () {
        Held held2 = new Held();
        boolean expResult = true;
        boolean result = held.kanVerplaatsen(held2);
        assertEquals(expResult, result);
    }

    /**
     * Test of kanVerplaatsen method, of class Held.
     */
    @Test
    public void testKanVerplaatsen_Kogel () {
        Kogel kogel = new Kogel(Richtingen.EAST);
        boolean expResult = true;
        boolean result = held.kanVerplaatsen(kogel);
        assertEquals(expResult, result);
    }
}
