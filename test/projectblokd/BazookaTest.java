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
public class BazookaTest {
    
    private Bazooka bazooka;
    
    public BazookaTest () {
    }

    @BeforeClass
    public static void setUpClass () throws Exception {
    }

    @AfterClass
    public static void tearDownClass () throws Exception {
    }
    
    @Before
    public void setUp () {
        bazooka = new Bazooka();
    }
    
    @After
    public void tearDown () {
    }

    /**
     * Test of schiet method, of class Bazooka.
     */
    @Test
    public void testSchiet () {
        Richtingen richting = Richtingen.NORTH;
        Veld veld = new Veld();
        Held held = new Held();
        veld.addSpelItem(held);
        veld.addSpelItem(bazooka);
        veld.powerUp(held);
        bazooka.schiet(richting);
    }
}
