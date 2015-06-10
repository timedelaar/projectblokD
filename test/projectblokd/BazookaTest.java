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
 * @author Aymren
 */
public class BazookaTest {
    
    private Held held;
    private Kogel kogel;
    private Bazooka instance;
            
    public BazookaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of schiet method, of class Bazooka.
     */
    @Test
    public void testSchiet() {
        kogel = new Kogel(Richtingen.EAST);
        held.getVeld().addSpelItem(kogel);
        kogel.setVeld(held.getVeld());
    }

    /**
     * Test of actie method, of class Bazooka.
     */
    @Test
    public void testActie() {
        held.addBazooka(instance);
    }
}
