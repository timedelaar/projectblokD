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
public class KogelTest {
    
    Kogel kogel;
    Richtingen richting;
    
    public KogelTest () {
    }

    @BeforeClass
    public static void setUpClass () throws Exception {
    }

    @AfterClass
    public static void tearDownClass () throws Exception {
    }
    
    @Before
    public void setUp () {
        richting = Richtingen.NORTH;
        kogel = new Kogel(richting);
    }
    
    @After
    public void tearDown () {
    }

    /**
     * Test of omdraaien method, of class Kogel.
     */
    @Test
    public void testOmdraaien () {
        kogel.omdraaien();
        Richtingen expResult = Richtingen.SOUTH;
        Richtingen result = kogel.getRichting();
        assertEquals(expResult, result);
    }

    /**
     * Test of kanVerplaatsen method, of class Kogel.
     */
    @Test
    public void testKanVerplaatsen_Held () {
        Held held = new Held();
        boolean expResult = true;
        boolean result = kogel.kanVerplaatsen(held);
        assertEquals(expResult, result);
    }

    /**
     * Test of kanVerplaatsen method, of class Kogel.
     */
    @Test
    public void testKanVerplaatsen_Kogel () {
        Kogel kogel2 = new Kogel(richting);
        boolean expResult = true;
        boolean result = kogel.kanVerplaatsen(kogel2);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of verplaats method, of class Kogel.
     * Eerste testgeval, test paden 1-2.
     */
    @Test
    public void testVerplaats_1 () {
        Veld veld = new Veld();
        veld.addSpelItem(kogel);
        boolean expResult = true;
        boolean result = veld.hasKogel();
        assertEquals(expResult, result);
        kogel.forceVerplaats();
        expResult = false;
        result = veld.hasKogel();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of verplaats method, of class Kogel.
     * Eerste testgeval, test paden 1-3.
     */
    @Test
    public void testVerplaats_2 () {
        Veld veld = new Veld();
        veld.addSpelItem(kogel);
        Veld veld2 = new Veld();
        veld.setNeighbour(richting, veld2);
        
        kogel.forceVerplaats();
        
        boolean expResult = false;
        boolean result = veld.hasKogel();
        assertEquals(expResult, result);
        
        expResult = true;
        result = veld2.hasKogel();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of verplaats method, of class Kogel.
     * Eerste testgeval, test paden 1-4.
     */
    @Test
    public void testVerplaats_3 () {
        Veld veld = new Veld();
        veld.addSpelItem(kogel);
        Veld veld2 = new Veld();
        ZwakkeMuur muur = new ZwakkeMuur();
        veld2.addSpelItem(muur);
        veld.setNeighbour(richting, veld2);
        
        kogel.forceVerplaats();
        
        boolean expResult = false;
        boolean result = veld.hasKogel();
        assertEquals(expResult, result);
        
        expResult = false;
        result = veld2.hasKogel();
        assertEquals(expResult, result);
        
        expResult = false;
        result = veld2.hasMuur();
        assertEquals(expResult, result);
    }
}
