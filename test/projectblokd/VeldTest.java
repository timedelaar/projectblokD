/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.Graphics;
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Tim
 */
public class VeldTest {
    
    private Veld veld;
    private Veld buurNoord;
    private Veld buurOost;
    private Veld buurZuid;
    private Veld buurWest;
    
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
        buurNoord = new Veld();
        buurOost = new Veld();
        buurZuid = new Veld();
        buurWest = new Veld();
    }
    
    @After
    public void tearDown () {
    }

    /**
     * Test of getNeighbour method, of class Veld.
     */
    @Test
    public void testSetGetNeighbour () {
        Richtingen richting = Richtingen.EAST;
        veld.setNeighbour(richting, buurOost);
        Veld result = veld.getNeighbour(richting);
        assertEquals(buurOost, result);
    }

    /**
     * Test of getNeighbour method, of class Veld.
     */
    @Test
    public void testSetGetNeighbour2 () {
        Richtingen richting = Richtingen.SOUTH;
        veld.setNeighbour(richting, buurZuid);
        Veld result = veld.getNeighbour(richting);
        assertEquals(buurZuid, result);
    }

    /**
     * Test of getNeighbour method, of class Veld.
     */
    @Test
    public void testSetGetNeighbour3 () {
        Richtingen richting = Richtingen.WEST;
        veld.setNeighbour(richting, buurWest);
        Veld result = veld.getNeighbour(richting);
        assertEquals(buurWest, result);
    }

    /**
     * Test of getNeighbour method, of class Veld.
     */
    @Test
    public void testSetGetNeighbour4 () {
        Richtingen richting = Richtingen.NORTH;
        veld.setNeighbour(richting, buurNoord);
        Veld result = veld.getNeighbour(richting);
        assertEquals(buurNoord, result);
    }
    
    @Test
    public void testHasVriend () {
        veld.addSpelItem(new Vriend(new Doolhof(100,100, "maze1", new KeyBoardListener())));
        assertTrue(veld.hasVriend());
    }
    
    @Test
    public void testHasVriend2 () {
        veld.addSpelItem(new Muur());
        assertTrue(!veld.hasVriend());
    }

    /**
     * Test of getNeighbours method, of class Veld.
     */
    @Test
    public void testGetNeighbours () {
        veld.setNeighbour(Richtingen.NORTH, buurNoord);
        veld.setNeighbour(Richtingen.EAST, buurOost);
        veld.setNeighbour(Richtingen.SOUTH, buurZuid);
        veld.setNeighbour(Richtingen.WEST, buurWest);
        ArrayList<Veld> result = veld.getNeighbours();
        ArrayList<Veld> expResult = new ArrayList<>();
        expResult.add(buurNoord);
        expResult.add(buurOost);
        expResult.add(buurZuid);
        expResult.add(buurWest);
        boolean succes = true;
        for (Veld buur : expResult) {
            if (!result.contains(buur)) {
                succes = false;
            }
        }
        assertTrue(succes);
    }
    
    /**
     * Test of kanVerplaatsen method, of class Veld.
     */
    @Test
    public void testKanVerplaatsen_Held () {
        Held held = new Held();
        boolean expResult = true;
        boolean result = veld.kanVerplaatsen(held);
        assertEquals(expResult, result);
    }

    /**
     * Test of kanVerplaatsen method, of class Veld.
     */
    @Test
    public void testKanVerplaatsen_Held_Muur () {
        Held held = new Held();
        veld.addSpelItem(new Muur());
        boolean expResult = false;
        boolean result = veld.kanVerplaatsen(held);
        assertEquals(expResult, result);
    }

    /**
     * Test of kanVerplaatsen method, of class Veld.
     */
    @Test
    public void testKanVerplaatsen_Held_ZwakkeMuur () {
        Held held = new Held();
        veld.addSpelItem(new ZwakkeMuur());
        boolean expResult = false;
        boolean result = veld.kanVerplaatsen(held);
        assertEquals(expResult, result);
    }

    /**
     * Test of kanVerplaatsen method, of class Veld.
     */
    @Test
    public void testKanVerplaatsen_Held_SterkeMuur () {
        Held held = new Held();
        veld.addSpelItem(new SterkeMuur());
        boolean expResult = false;
        boolean result = veld.kanVerplaatsen(held);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of kanVerplaatsen method, of class Veld.
     */
    @Test
    public void testKanVerplaatsen_Held_Helper () {
        Held held = new Held();
        veld.addSpelItem(new Helper());
        boolean expResult = true;
        boolean result = veld.kanVerplaatsen(held);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of kanVerplaatsen method, of class Veld.
     */
    @Test
    public void testKanVerplaatsen_Held_Bazooka () {
        Held held = new Held();
        veld.addSpelItem(new Bazooka());
        boolean expResult = true;
        boolean result = veld.kanVerplaatsen(held);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of kanVerplaatsen method, of class Veld.
     */
    @Test
    public void testKanVerplaatsen_Held_Boot () {
        Held held = new Held();
        veld.addSpelItem(new Boot());
        boolean expResult = true;
        boolean result = veld.kanVerplaatsen(held);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of kanVerplaatsen method, of class Veld.
     */
    @Test
    public void testKanVerplaatsen_Held_Cheater () {
        Held held = new Held();
        veld.addSpelItem(new Cheater(10, new Doolhof(100, 100, "maze1", new KeyBoardListener())));
        boolean expResult = true;
        boolean result = veld.kanVerplaatsen(held);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of kanVerplaatsen method, of class Veld.
     */
    @Test
    public void testKanVerplaatsen_Held_Water () {
        Held held = new Held();
        veld.addSpelItem(new Water());
        boolean expResult = false;
        boolean result = veld.kanVerplaatsen(held);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of kanVerplaatsen method, of class Veld.
     */
    @Test
    public void testKanVerplaatsen_Held_Water2 () {
        Held held = new Held();
        held.addBoot(new Boot());
        veld.addSpelItem(new Water());
        boolean expResult = true;
        boolean result = veld.kanVerplaatsen(held);
        assertEquals(expResult, result);
    }

    /**
     * Test of kanVerplaatsen method, of class Veld.
     */
    @Test
    public void testKanVerplaatsen_Kogel () {
        Kogel kogel = new Kogel(Richtingen.EAST);
        kogel.stopTimer();
        boolean expResult = true;
        boolean result = veld.kanVerplaatsen(kogel);
        assertEquals(expResult, result);
    }

    /**
     * Test of kanVerplaatsen method, of class Veld.
     */
    @Test
    public void testKanVerplaatsen_Kogel_Muur () {
        Kogel kogel = new Kogel(Richtingen.EAST);
        kogel.stopTimer();
        veld.addSpelItem(new Muur());
        boolean expResult = false;
        boolean result = veld.kanVerplaatsen(kogel);
        assertEquals(expResult, result);
    }

    /**
     * Test of kanVerplaatsen method, of class Veld.
     */
    @Test
    public void testKanVerplaatsen_Kogel_ZwakkeMuur () {
        Kogel kogel = new Kogel(Richtingen.EAST);
        kogel.stopTimer();
        veld.addSpelItem(new ZwakkeMuur());
        boolean expResult = false;
        boolean result = veld.kanVerplaatsen(kogel);
        assertEquals(expResult, result);
    }

    /**
     * Test of kanVerplaatsen method, of class Veld.
     */
    @Test
    public void testKanVerplaatsen_Kogel_SterkeMuur () {
        Kogel kogel = new Kogel(Richtingen.EAST);
        kogel.stopTimer();
        veld.addSpelItem(new SterkeMuur());
        boolean expResult = false;
        boolean result = veld.kanVerplaatsen(kogel);
        assertEquals(expResult, result);
    }

    /**
     * Test of kanVerplaatsen method, of class Veld.
     */
    @Test
    public void testKanVerplaatsen_Kogel_Helper () {
        Kogel kogel = new Kogel(Richtingen.EAST);
        kogel.stopTimer();
        veld.addSpelItem(new Helper());
        boolean expResult = true;
        boolean result = veld.kanVerplaatsen(kogel);
        assertEquals(expResult, result);
    }

    /**
     * Test of kanVerplaatsen method, of class Veld.
     */
    @Test
    public void testKanVerplaatsen_Kogel_Cheater () {
        Kogel kogel = new Kogel(Richtingen.EAST);
        kogel.stopTimer();
        veld.addSpelItem(new Cheater(10, new Doolhof(100, 100, "maze1", new KeyBoardListener())));
        boolean expResult = true;
        boolean result = veld.kanVerplaatsen(kogel);
        assertEquals(expResult, result);
    }

    /**
     * Test of kanVerplaatsen method, of class Veld.
     */
    @Test
    public void testKanVerplaatsen_Kogel_Bazooka () {
        Kogel kogel = new Kogel(Richtingen.EAST);
        kogel.stopTimer();
        veld.addSpelItem(new Bazooka());
        boolean expResult = true;
        boolean result = veld.kanVerplaatsen(kogel);
        assertEquals(expResult, result);
    }

    /**
     * Test of kanVerplaatsen method, of class Veld.
     */
    @Test
    public void testKanVerplaatsen_Kogel_Boot () {
        Kogel kogel = new Kogel(Richtingen.EAST);
        kogel.stopTimer();
        veld.addSpelItem(new Boot());
        boolean expResult = true;
        boolean result = veld.kanVerplaatsen(kogel);
        assertEquals(expResult, result);
    }

    /**
     * Test of kanVerplaatsen method, of class Veld.
     */
    @Test
    public void testKanVerplaatsen_Kogel_Water () {
        Kogel kogel = new Kogel(Richtingen.EAST);
        kogel.stopTimer();
        veld.addSpelItem(new Water());
        boolean expResult = true;
        boolean result = veld.kanVerplaatsen(kogel);
        assertEquals(expResult, result);
    }

    /**
     * Test of addSpelItem method, of class Veld.
     */
    @Test
    public void testAddSpelItem () {
        SpelItem spelItem = new Muur();
        Veld instance = new Veld();
        instance.addSpelItem(spelItem);
    }

    /**
     * Test of verwijderSpelItem method, of class Veld.
     */
    @Test
    public void testVerwijderSpelItem () {
        SpelItem item = new Boot();
        veld.addSpelItem(item);
        assertTrue(veld.hasBoot());
        veld.verwijderSpelItem(item);
        assertTrue(!veld.hasBoot());
    }

    /**
     * Test of destroySpelItems method, of class Veld.
     */
    @Test
    public void testDestroySpelItems () {
        veld.addSpelItem(new Muur());
        veld.destroySpelItems();
        assertTrue(!veld.kanVerplaatsen(new Held()));
    }

    /**
     * Test of destroySpelItems method, of class Veld.
     */
    @Test
    public void testDestroySpelItems2 () {
        veld.addSpelItem(new ZwakkeMuur());
        veld.destroySpelItems();
        assertTrue(veld.kanVerplaatsen(new Held()));
    }

    /**
     * Test of powerUp method, of class Veld.
     */
    @Test
    public void testPowerUp () {
        Held held = new Held();
        veld.powerUp(held);
        boolean expResult = false;
        boolean result = held.hasBazooka();
        assertEquals(expResult, result);
    }

    /**
     * Test of powerUp method, of class Veld.
     */
    @Test
    public void testPowerUp2 () {
        Held held = new Held();
        veld.addSpelItem(new Bazooka());
        veld.powerUp(held);
        boolean expResult = true;
        boolean result = held.hasBazooka();
        assertEquals(expResult, result);
    }

    /**
     * Test of hasBoot method, of class Veld.
     */
    @Test
    public void testHasBoot () {
        boolean expResult = false;
        boolean result = veld.hasBoot();
        assertEquals(expResult, result);
    }

    /**
     * Test of hasBoot method, of class Veld.
     */
    @Test
    public void testHasBoot2 () {
        veld.addSpelItem(new Boot());
        boolean expResult = true;
        boolean result = veld.hasBoot();
        assertEquals(expResult, result);
    }

    /**
     * Test of hasBazooka method, of class Veld.
     */
    @Test
    public void testHasBazooka () {
        boolean expResult = false;
        boolean result = veld.hasBazooka();
        assertEquals(expResult, result);
    }

    /**
     * Test of hasBazooka method, of class Veld.
     */
    @Test
    public void testHasBazooka2 () {
        veld.addSpelItem(new Bazooka());
        boolean expResult = true;
        boolean result = veld.hasBazooka();
        assertEquals(expResult, result);
    }

    /**
     * Test of hasHeld method, of class Veld.
     */
    @Test
    public void testHasHeld () {
        boolean expResult = false;
        boolean result = veld.hasHeld();
        assertEquals(expResult, result);
    }

    /**
     * Test of hasHeld method, of class Veld.
     */
    @Test
    public void testHasHeld2 () {
        veld.addSpelItem(new Held());
        boolean expResult = true;
        boolean result = veld.hasHeld();
        assertEquals(expResult, result);
    }

    /**
     * Test of hasWater method, of class Veld.
     */
    @Test
    public void testHasWater () {
        boolean expResult = false;
        boolean result = veld.hasWater();
        assertEquals(expResult, result);
    }

    /**
     * Test of hasWater method, of class Veld.
     */
    @Test
    public void testHasWater2 () {
        veld.addSpelItem(new Water());
        boolean expResult = true;
        boolean result = veld.hasWater();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAfstand method, of class Veld.
     */
    @Test
    public void testSetGetAfstand () {
        int afstand = 5;
        veld.setAfstand(afstand);
        int result = veld.getAfstand();
        assertEquals(afstand, result);
    }

    /**
     * Test of isOnderdeelRoute method, of class Veld.
     */
    @Test
    public void testIsGetOnderdeelRoute () {
        boolean bool = false;
        veld.isOnderdeelRoute(bool);
        boolean result = veld.getOnderdeelRoute();
        assertEquals(bool, result);
    }

    /**
     * Test of isOnderdeelRoute method, of class Veld.
     */
    @Test
    public void testIsGetOnderdeelRoute2 () {
        boolean bool = true;
        veld.isOnderdeelRoute(bool);
        boolean result = veld.getOnderdeelRoute();
        assertEquals(bool, result);
    }
}
