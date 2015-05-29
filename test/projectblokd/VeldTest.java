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
public class VeldTest {
    
    private Veld veld;
    private Veld veld2;
    
    public VeldTest () {
    }

    @BeforeClass
    public static void setUpClass () throws Exception {
    }

    @AfterClass
    public static void tearDownClass () throws Exception {
    }
    
    @Before
    public void setUp () {
        veld = new Veld();
        veld2 = new Veld();
    }
    
    @After
    public void tearDown () {
    }

    /**
     * Test of getNeighbour method, of class Veld.
     */
    @Test
    public void testSetGetNeighbour () {
        veld.setNeighbour(Richtingen.EAST, veld2);
        Veld result = veld.getNeighbour(Richtingen.EAST);
        assertEquals(veld2, result);
    }

    /**
     * Test of getSpelItem method, of class Veld.
     */
    @Test
    public void testSetGetSpelItem () {
        Muur muur = new Muur();
        veld.setSpelItem(muur);
        SpelItem expResult = muur;
        SpelItem result = veld.getSpelItem();
        assertEquals(expResult, result);
    }

    /**
     * Test of verwijderSpelItem method, of class Veld.
     */
    @Test
    public void testVerwijderSpelItem () {
        Muur muur = new Muur();
        veld.setSpelItem(muur);
        veld.verwijderSpelItem();
        SpelItem expResult = null;
        SpelItem result = veld.getSpelItem();
        assertEquals(expResult, result);
    }
}
