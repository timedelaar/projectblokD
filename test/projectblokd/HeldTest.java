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
public class HeldTest {
    
    private Held instance;
<<<<<<< HEAD
=======
    private Veld huidigVeld;
    private Veld buur;
>>>>>>> e4dfb862c61d260d34bb26acba1959a66bd890ed
    
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
        huidigVeld = new Veld();
        buur = new Veld();
    }
    
    @After
    public void tearDown () {
    }

    /**
     * Test of verplaats method, of class Held.
     */
    @Test
    public void testVerplaats1 () {
        huidigVeld.addSpelItem(instance);
        Richtingen richting = Richtingen.EAST;
        huidigVeld.setNeighbour(richting, buur);
        instance.verplaats(richting);
        assertTrue(!huidigVeld.hasHeld());
        assertTrue(buur.hasHeld());
    }
    
    /**
     * Test of verplaats method, of class Held.
     */
    @Test
    public void testVerplaats2 () {
        huidigVeld.addSpelItem(instance);
        SpelItem item = new ZwakkeMuur();
        buur.addSpelItem(item);
        Richtingen richting = Richtingen.NORTH;
        huidigVeld.setNeighbour(Richtingen.NORTH, buur);
        instance.verplaats(richting);
        assertTrue(huidigVeld.hasHeld());
        assertTrue(!buur.kanVerplaatsen(instance));
    }
    
    /**
     * Test of verplaats method, of class Held.
     */
    @Test
    public void testVerplaats3 () {
        huidigVeld.addSpelItem(instance);
        SpelItem item = new Bazooka();
        buur.addSpelItem(item);
        Richtingen richting = Richtingen.WEST;
        huidigVeld.setNeighbour(richting, buur);
        instance.verplaats(richting);
        assertTrue(!huidigVeld.hasHeld());
        assertTrue(buur.hasHeld());
    }
    
    /**
     * Test of verplaats method, of class Held.
     */
    @Test
    public void testVerplaats4 () {
        huidigVeld.addSpelItem(instance);
        SpelItem item = new Water();
        buur.addSpelItem(item);
        Richtingen richting = Richtingen.SOUTH;
        huidigVeld.setNeighbour(richting, buur);
        instance.verplaats(richting);
        assertTrue(huidigVeld.hasHeld());
        assertTrue(!buur.hasHeld());
    }
    
    /**
     * Test of verplaats method, of class Held.
     */
    @Test
    public void testVerplaats5 () {
        huidigVeld.addSpelItem(instance);
        instance.addBoot(new Boot());
        SpelItem item = new Water();
        buur.addSpelItem(item);
        Richtingen richting = Richtingen.SOUTH;
        huidigVeld.setNeighbour(richting, buur);
        instance.verplaats(richting);
        assertTrue(!huidigVeld.hasHeld());
        assertTrue(buur.hasHeld());
    }

    /**
     * Test of schiet method, of class Held.
     */
    @Test
    public void testSchiet() {
        System.out.println("schiet");
        Held instance = new Held();
        instance.schiet();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verplaats method, of class Held.
     */
    @Test
    public void testVerplaats() {
        System.out.println("verplaats");
        Richtingen richting = null;
        Held instance = new Held();
        instance.verplaats(richting);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addBazooka method, of class Held.
     */
    @Test
    public void testAddBazooka() {
        System.out.println("addBazooka");
        Bazooka bazooka = null;
        Held instance = new Held();
        instance.addBazooka(bazooka);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasBazooka method, of class Held.
     */
    @Test
    public void testHasBazooka() {
        System.out.println("hasBazooka");
        Held instance = new Held();
        boolean expResult = false;
        boolean result = instance.hasBazooka();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addBoot method, of class Held.
     */
    @Test
    public void testAddBoot() {
        System.out.println("addBoot");
        Boot boot = null;
        Held instance = new Held();
        instance.addBoot(boot);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasBoot method, of class Held.
     */
    @Test
    public void testHasBoot() {
        System.out.println("hasBoot");
        Held instance = new Held();
        boolean expResult = false;
        boolean result = instance.hasBoot();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of kanVerplaatsen method, of class Held.
     */
    @Test
    public void testKanVerplaatsen_Held() {
        System.out.println("kanVerplaatsen");
        Held held = null;
        Held instance = new Held();
        boolean expResult = false;
        boolean result = instance.kanVerplaatsen(held);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of kanVerplaatsen method, of class Held.
     */
    @Test
    public void testKanVerplaatsen_Kogel() {
        System.out.println("kanVerplaatsen");
        Kogel kogel = null;
        Held instance = new Held();
        boolean expResult = false;
        boolean result = instance.kanVerplaatsen(kogel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class Held.
     */
    @Test
    public void testDestroy_0args() {
        System.out.println("destroy");
        Held instance = new Held();
        instance.destroy();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class Held.
     */
    @Test
    public void testDestroy_Iterator() {
        System.out.println("destroy");
        Iterator iter = null;
        Held instance = new Held();
        instance.destroy(iter);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
