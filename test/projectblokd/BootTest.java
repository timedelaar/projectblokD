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
public class BootTest {
    
    public BootTest () {
    }

    @BeforeClass
    public static void setUpClass () throws Exception {
    }

    @AfterClass
    public static void tearDownClass () throws Exception {
    }
    
    @Before
    public void setUp () {
    }
    
    @After
    public void tearDown () {
    }

    /**
     * Test of actie method, of class Boot.
     */
    @Test
    public void testActie () {
        Held held = new Held();
        Veld veld = new Veld();
        Boot boot = new Boot();
        veld.addSpelItem(boot);
        veld.powerUp(held);
    }
}
