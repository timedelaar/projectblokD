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
public class CheaterTest {
    
    private Cheater cheater;
    
    public CheaterTest () {
    }

    @BeforeClass
    public static void setUpClass () throws Exception {
    }

    @AfterClass
    public static void tearDownClass () throws Exception {
    }
    
    @Before
    public void setUp () {
        cheater = new Cheater(10, new Doolhof(100, 100, "maze1", new KeyBoardListener()));
    }
    
    @After
    public void tearDown () {
    }

    /**
     * Test of actie method, of class Cheater.
     */
    @Test
    public void testActie () {
        Veld veld = new Veld();
        Held held = new Held();
        veld.addSpelItem(cheater);
        veld.powerUp(held);
    }
}
