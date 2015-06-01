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
    private Doolhof doolhof;
    
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
    }
    
    @After
    public void tearDown () {
    }

    /**
     * Test of verplaats method, of class Held.
     */
    @Test
    public void testVerplaats1 () {
        Veld huidigVeld = new Veld();
        huidigVeld.addSpelItem(instance);
        Veld buurOost = new Veld();
        huidigVeld.setNeighbour(Richtingen.EAST, buurOost);
        Richtingen richting = Richtingen.EAST;
        instance.verplaats(richting);
        assertEquals(null, huidigVeld.hasSpelItem());
        assertEquals(instance, buurOost.hasSpelItem());
    }
    
    /**
     * Test of verplaats method, of class Held.
     */
    @Test
    public void testVerplaats2 () {
        Veld huidigVeld = new Veld();
        huidigVeld.addSpelItem(instance);
        Veld buurOost = new Veld();
        SpelItem item = new ZwakkeMuur();
        buurOost.addSpelItem(item);
        huidigVeld.setNeighbour(Richtingen.EAST, buurOost);
        Richtingen richting = Richtingen.EAST;
        instance.verplaats(richting);
        assertEquals(instance, huidigVeld.hasSpelItem());
        assertEquals(item, buurOost.hasSpelItem());
    }
    
    /**
     * Test of verplaats method, of class Held.
     */
    @Test
    public void testVerplaats3 () {
        Veld huidigVeld = new Veld();
        huidigVeld.addSpelItem(instance);
        Veld buurOost = new Veld();
        SpelItem item = new Cheater(10, new Doolhof(100,100));
        buurOost.addSpelItem(item);
        huidigVeld.setNeighbour(Richtingen.EAST, buurOost);
        Richtingen richting = Richtingen.EAST;
        instance.verplaats(richting);
        assertEquals(null, huidigVeld.hasSpelItem());
        assertEquals(instance, buurOost.hasSpelItem());
    }
}
