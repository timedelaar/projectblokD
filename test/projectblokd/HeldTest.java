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
        doolhof = new Doolhof(100, 100);
        instance = new Held(doolhof);
    }
    
    @After
    public void tearDown () {
    }

    /**
     * Test of checkVeld method, of class Held.
     */
    @Test
    public void testCheckVeld1 () {
        Veld veld = new Veld();
        boolean expResult = true;
        boolean result = instance.checkVeld(veld);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of checkVeld method, of class Held.
     */
    @Test
    public void testCheckVeld2 () {
        Veld veld = new Veld();
        SpelItem item = new Muur();
        veld.setSpelItem(item);
        boolean expResult = false;
        boolean result = instance.checkVeld(veld);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of checkVeld method, of class Held.
     */
    @Test
    public void testCheckVeld3 () {
        Veld veld = new Veld();
        SpelItem item = new Cheater(10, doolhof);
        veld.setSpelItem(item);
        boolean expResult = true;
        boolean result = instance.checkVeld(veld);
        assertEquals(expResult, result);
    }

    /**
     * Test of verplaats method, of class Held.
     */
    @Test
    public void testVerplaats1 () {
        Veld huidigVeld = new Veld();
        huidigVeld.setSpelItem(instance);
        Veld buurOost = new Veld();
        huidigVeld.setNeighbour(Richtingen.EAST, buurOost);
        Richtingen richting = Richtingen.EAST;
        instance.verplaats(richting);
        assertEquals(null, huidigVeld.getSpelItem());
        assertEquals(instance, buurOost.getSpelItem());
    }
    
    /**
     * Test of verplaats method, of class Held.
     */
    @Test
    public void testVerplaats2 () {
        Veld huidigVeld = new Veld();
        huidigVeld.setSpelItem(instance);
        Veld buurOost = new Veld();
        SpelItem item = new Muur();
        buurOost.setSpelItem(item);
        huidigVeld.setNeighbour(Richtingen.EAST, buurOost);
        Richtingen richting = Richtingen.EAST;
        instance.verplaats(richting);
        assertEquals(instance, huidigVeld.getSpelItem());
        assertEquals(item, buurOost.getSpelItem());
    }
    
    /**
     * Test of verplaats method, of class Held.
     */
    @Test
    public void testVerplaats3 () {
        Veld huidigVeld = new Veld();
        huidigVeld.setSpelItem(instance);
        Veld buurOost = new Veld();
        SpelItem item = new Cheater(10, doolhof);
        buurOost.setSpelItem(item);
        huidigVeld.setNeighbour(Richtingen.EAST, buurOost);
        Richtingen richting = Richtingen.EAST;
        instance.verplaats(richting);
        assertEquals(null, huidigVeld.getSpelItem());
        assertEquals(instance, buurOost.getSpelItem());
    }
}
