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
public class DakTest {
    
    private Dak dak;
    
    public DakTest () {
    }

    @BeforeClass
    public static void setUpClass () throws Exception {
    }

    @AfterClass
    public static void tearDownClass () throws Exception {
    }
    
    @Before
    public void setUp () {
        dak = new Dak();
    }
    
    @After
    public void tearDown () {
    }

    /**
     * Test of kanVerplaatsen method, of class Dak.
     */
    @Test
    public void testKanVerplaatsen_Held () {
        Held held = new Held();
        boolean expResult = true;
        boolean result = dak.kanVerplaatsen(held);
        assertEquals(expResult, result);
    }

    /**
     * Test of kanVerplaatsen method, of class Dak.
     */
    @Test
    public void testKanVerplaatsen_Kogel () {
        Kogel kogel = new Kogel(Richtingen.NORTH);
        kogel.stopTimer();
        boolean expResult = true;
        boolean result = dak.kanVerplaatsen(kogel);
        assertEquals(expResult, result);
    }
}
