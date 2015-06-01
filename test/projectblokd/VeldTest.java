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
    
    @Test
    public void testHasVriend () {
        veld.addSpelItem(new Vriend(new Doolhof(100,100)));
        assertTrue(veld.hasVriend());
    }
    
    @Test
    public void testHasVriend2 () {
        veld.addSpelItem(new Muur());
        assertTrue(!veld.hasVriend());
    }
}
