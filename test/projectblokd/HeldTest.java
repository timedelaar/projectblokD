/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Tim
 */
public class HeldTest {
    
    private Held instance;
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
        instance = new Held();
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
    public void testVerplaats1 () {
        huidigVeld.addSpelItem(instance);
        Richtingen richting = Richtingen.EAST;
        huidigVeld.setNeighbour(richting, buur);
        instance.verplaats(richting);
        assertTrue(!huidigVeld.hasHeld());
        assertTrue(buur.hasHeld());
    }
    
    /**
     * Test of verplaats method, of class Held.
     */
    @Test
    public void testVerplaats2 () {
        huidigVeld.addSpelItem(instance);
        SpelItem item = new ZwakkeMuur();
        buur.addSpelItem(item);
        Richtingen richting = Richtingen.NORTH;
        huidigVeld.setNeighbour(Richtingen.NORTH, buur);
        instance.verplaats(richting);
        assertTrue(huidigVeld.hasHeld());
        assertTrue(!buur.kanVerplaatsen(instance));
    }
    
    /**
     * Test of verplaats method, of class Held.
     */
    @Test
    public void testVerplaats3 () {
        huidigVeld.addSpelItem(instance);
        SpelItem item = new Bazooka();
        buur.addSpelItem(item);
        Richtingen richting = Richtingen.WEST;
        huidigVeld.setNeighbour(richting, buur);
        instance.verplaats(richting);
        assertTrue(!huidigVeld.hasHeld());
        assertTrue(buur.hasHeld());
    }
    
    /**
     * Test of verplaats method, of class Held.
     */
    @Test
    public void testVerplaats4 () {
        huidigVeld.addSpelItem(instance);
        SpelItem item = new Water();
        buur.addSpelItem(item);
        Richtingen richting = Richtingen.SOUTH;
        huidigVeld.setNeighbour(richting, buur);
        instance.verplaats(richting);
        assertTrue(huidigVeld.hasHeld());
        assertTrue(!buur.hasHeld());
    }
    
    /**
     * Test of verplaats method, of class Held.
     */
    @Test
    public void testVerplaats5 () {
        huidigVeld.addSpelItem(instance);
        instance.addBoot(new Boot());
        SpelItem item = new Water();
        buur.addSpelItem(item);
        Richtingen richting = Richtingen.SOUTH;
        huidigVeld.setNeighbour(richting, buur);
        instance.verplaats(richting);
        assertTrue(!huidigVeld.hasHeld());
        assertTrue(buur.hasHeld());
    }
}
